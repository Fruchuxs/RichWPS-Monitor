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
package de.hsos.ecs.richwps.wpsmonitor.communication.wpsclient;

/**
 * This Exception should be thrown if the XML response of a WPS server describes
 * a WPS-Exception answer.
 *
 * Normally this Exception is never thrown, but used within a WPS Client.
 * Instances of this Class will be created if the WPS-Client detects a WPS
 * Exception answer and stores the instance in the {@link WpsResponse}-Object.
 *
 * Otherwise the specific client implementation can have a method which throws
 * this execption, but the client must catch this exception and must stores this
 * in a {@link WpsResponse}Object.
 *
 * @see WpsResponse
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class WpsException extends Exception {

    public WpsException(String message) {
        super(message);
    }

    public WpsException() {
        super("The Request produced an exception!");
    }
}
