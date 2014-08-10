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
package de.hsos.ecs.richwps.wpsmonitor.util;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class Validate {

    /**
     * Checks if a Parameter is null.
     *
     * @param <T> Return type
     * @param var Check if null
     * @param name Outputname for exception message
     * @return T
     */
    public static <T> T notNull(T var, String name) {
        if (var == null) {
            throw new IllegalArgumentException(name + " was null.");
        }

        return var;
    }

    /**
     * Checks if t is true.
     *
     * @param t
     * @param name Outputname for exception message
     */
    public static void isTrue(Boolean t, String name) {
        notNull(t, name);

        if (!t) {
            throw new IllegalArgumentException(name + " was not valid.");
        }
    }

    private Validate() {

    }
}