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
package de.hsosnabrueck.ecs.richwps.wpsmonitor.boundary.restful.strategies;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.boundary.restful.PresentateStrategy;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class XmlPresentateStategy implements PresentateStrategy {

    @Override
    public String presentate(Object presentate) {
        XStream xStream = new XStream(new DomDriver());

        return xStream.toXML(presentate);
    }

    @Override
    public String getMimeType() {
        return "application/xml";
    }

}
