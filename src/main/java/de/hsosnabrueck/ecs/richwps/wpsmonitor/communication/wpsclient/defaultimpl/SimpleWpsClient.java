/*
 * Copyright 2014 Florian Vogelpohl <floriantobias@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.hsosnabrueck.ecs.richwps.wpsmonitor.communication.wpsclient.defaultimpl;

import de.hsosnabrueck.ecs.richwps.wpsmonitor.communication.wpsclient.WpsClient;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.communication.wpsclient.WpsClientConfig;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.communication.wpsclient.WpsConnectionException;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.communication.wpsclient.WpsException;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.communication.wpsclient.WpsRequest;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.communication.wpsclient.WpsResponse;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * A very simple WpsClient Implementation based on Apache HTTP Components Lib.
 * This WPS Client is developed to send a raw request over http-post method to a
 * wps server. After the request is executed, the client awaits a response.
 *
 * This simple wps client can check the response for WPS-Errors. If the
 * WpsResponse is not a valid XML String, the client will interprete this as
 * connection error, because the wps server seems to be unreachable (or no wps
 * server runs at this server).
 *
 * @see WpsClient
 * @see WpsResponse
 * @see WpsRequest
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class SimpleWpsClient implements WpsClient {

    private String wpsExceptionMessage;
    private final static Logger log = LogManager.getLogger();
    private HttpClient httpClient;

    @Override
    public void init(final WpsClientConfig config) {
        log.debug("Init WpsClient with {}", config);
        
        Integer timeout = config.getConnectionTimeout();

        RequestConfig.Builder requestBuilder = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .setConnectionRequestTimeout(timeout);

        httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestBuilder.build())
                .build();
    }

    @Override
    public WpsResponse execute(WpsRequest wpsRequest) {

        String responseBody = null;
        Date responseTime = null;
        WpsResponse response = null;

        if (wpsRequest != null) {
            try {
                // build http request
                HttpPost httpRequest = buildRequest(wpsRequest);

                log.debug("Sending Request to Server: {}", wpsRequest.getProcessInfo().getWpsUri());
                
                // prepare and do request (init requestTime)
                wpsRequest.prepareRequest();
                HttpResponse httpResponse = httpClient.execute(httpRequest);
                responseTime = new Date();
                
                log.debug("Response received.");

                // get response body
                HttpEntity responseEntity = httpResponse.getEntity();
                responseBody = EntityUtils.toString(responseEntity);
            } catch (UnsupportedEncodingException ex) {
                log.debug(ex);
            } catch (IOException ex) {
                log.debug(ex);
            }

            // create response Object
            response = new WpsResponse(responseBody, responseTime);

            // set exception if necessary
            if (responseBody == null) {
                response.setException(new WpsConnectionException());
            } else {
                try {
                    if (isWpsException(responseBody)) {
                        WpsException ex;

                        if (wpsExceptionMessage == null || wpsExceptionMessage.equals("")) {
                            ex = new WpsException();
                        } else {
                            ex = new WpsException(wpsExceptionMessage);

                            log.debug(wpsExceptionMessage);
                        }

                        response.setException(ex);
                    }
                } catch (NoWpsResponse ex) {
                    response.setException(new WpsConnectionException());
                }
            }
        }

        return response;
    }

    private HttpPost buildRequest(final WpsRequest wpsRequest) throws UnsupportedEncodingException {
        HttpPost httpRequest = new HttpPost(wpsRequest.getProcessInfo().getWpsUri());
        List<NameValuePair> body = new ArrayList<NameValuePair>();
        body.add(new BasicNameValuePair("request", wpsRequest.getRawRequest()));

        httpRequest.setEntity(new UrlEncodedFormEntity(body));

        return httpRequest;
    }

    private Boolean isWpsException(final String responseBody) throws NoWpsResponse {
        try {
            Document doc = getDocumentBuilder().parse(new InputSource(new StringReader(responseBody)));
            NodeList nl = doc.getElementsByTagNameNS("*", "ExceptionText");

            if (nl.getLength() > 0) {
                StringBuilder strBuilder = new StringBuilder();

                for (int i = 0; i < nl.getLength(); i++) {
                    strBuilder.append(nl.item(i).getTextContent());
                    strBuilder.append("\n----\n");
                }

                wpsExceptionMessage = strBuilder.toString();

                return true;
            } else {
                return false;
            }
        } catch (SAXException ex) {
            log.debug(ex);
        } catch (IOException ex) {
            log.debug(ex);
        } catch (ParserConfigurationException ex) {
            log.debug(ex);
        } catch (DOMException ex) {
            log.debug(ex);
        }

        log.debug("Exception occured while parsing the WpsResponse body. Interpreting as ConnectionError.");
        throw new NoWpsResponse();
    }

    private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setNamespaceAware(true);

        return docBuilderFactory.newDocumentBuilder();
    }
}
