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
package de.hsosnabrueck.ecs.richwps.wpsmonitor.utils;

import de.hsosnabrueck.ecs.richwps.wpsmonitor.util.Validate;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class ParamTest {

    /**
     * Test of notNull method, of class Validate.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNotNullThrowsException() {
        System.out.println("notNull");

        Validate.notNull(null, "Null test");
    }

    @Test
    public void testNotNullThrowsNoException() {
        System.out.println("notNull");
        String str = "Hello World!";

        try {
            Validate.notNull(str, "Null test");
        } catch (IllegalArgumentException ex) {
            Assert.assertTrue(false);
        }

        Assert.assertTrue(true);
    }

}
