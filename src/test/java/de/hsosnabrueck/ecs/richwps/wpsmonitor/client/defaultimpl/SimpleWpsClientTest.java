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
package de.hsosnabrueck.ecs.richwps.wpsmonitor.client.defaultimpl;

import de.hsosnabrueck.ecs.richwps.wpsmonitor.client.WpsClient;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.client.WpsProcessInfo;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.client.WpsRequest;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.client.WpsResponse;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sun.security.x509.OIDMap;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class SimpleWpsClientTest {

    private final static String WPS_URI = "http://localhost:8080/wps/WebProcessingService";
    private final static String TEST_REQUEST_FILE = "/request.xml";

    private static String rawRequest;
    private WpsProcessInfo info;
    private WpsClient client;

    public SimpleWpsClientTest() {
    }

    private static Path getFilePath() {
        String strPath = SimpleWpsClientTest.class.getResource(TEST_REQUEST_FILE).getPath();

        // Windows Path fix
        if (strPath.charAt(2) == ':') {
            strPath = strPath.substring(1);
        }

        return Paths.get(strPath);
    }

    @BeforeClass
    public static void setUpClass() {
        StringBuilder buf = new StringBuilder();
        Scanner scan = null;

        try {
            Path path = getFilePath();
            scan = new Scanner(path, StandardCharsets.UTF_8.name());
            while (scan.hasNextLine()) {
                buf.append(scan.nextLine());
            }

        } catch (IOException ex) {
            Logger.getLogger(SimpleWpsClientTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SimpleWpsClientTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (scan != null) {
                scan.close();
            }
            System.out.println(System.getProperty("user.dir"));
        }

        rawRequest = buf.toString();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        client = new SimpleWpsClientFactory().create();

        if (rawRequest == null || rawRequest.equals("")) {
            fail("Can't load testrequest from file");
        }

        try {
            info = new WpsProcessInfo(new URI(WPS_URI), rawRequest);
        } catch (URISyntaxException ex) {
            Logger.getLogger(SimpleWpsClientTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Invalid URI");
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class SimpleWpsClient.
     */
    @Test
    public void testValidExecute() {
        WpsResponse response = doDefaultRequest();
        Assert.assertTrue(!response.isException() && response.getResponseBody() != null && !response.getResponseBody().equals(""));
    }
    
    private WpsResponse doDefaultRequest() {
        WpsRequest request = new WpsRequest(rawRequest, info);
        
        return client.execute(request);
    }
    
    @Test
    public void testRequestDateIsSetFromClient() {
        WpsRequest request = new WpsRequest(rawRequest, info);
        request.prepareRequest();
        
        Date dateRef = request.getRequestTime();
        
        client.execute(request);
        
        Assert.assertTrue(!request.getRequestTime().equals(dateRef));
    }
    
    @Test 
    public void responseDateIsSet() {
        WpsResponse response = doDefaultRequest();
        
        Assert.assertTrue(response.getResponseTime() != null);
    }
    
    @Test 
    public void testExceptionIdentification() {
        WpsRequest request = new WpsRequest("", info);
        WpsResponse response = client.execute(request);

        System.out.println(response.getExceptionMessage());
        Assert.assertTrue(response.isWpsException());
    }

}
