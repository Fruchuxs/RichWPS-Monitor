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
package de.hsos.ecs.richwps.wpsmonitor.data.entity;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;


/**
 * Entity for WPS.
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class WpsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String identifier;

    private URL route;

    public WpsEntity() {
    }

    public WpsEntity(String identifier, URL route) {
        this.identifier = identifier;
        this.route = route;
    }

    public WpsEntity(String identifier, String route) throws MalformedURLException, URISyntaxException {
        this.identifier = identifier;
        this.setUri(route);
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public URL getUri() {
        return route;
    }

    public void setUri(URL route) {
        this.route = route;
    }

    public final void setUri(String route) throws MalformedURLException, URISyntaxException {
        this.route = new URL(route);;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WpsEntity other = (WpsEntity) obj;
        return Objects.equals(this.id, other.id) || (this.id != null && this.id.equals(other.id));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WpsEntity{" + "identifier=" + identifier + ", route=" + route + '}';
    }
}
