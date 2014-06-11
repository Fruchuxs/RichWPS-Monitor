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

package de.hsosnabrueck.ecs.richwps.wpsmonitor.data.dataaccess.impl;

import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.dataaccess.WpsDataAccess;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.data.entity.WpsEntity;
import de.hsosnabrueck.ecs.richwps.wpsmonitor.utils.Param;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class WpsDao extends AbstractDataAccess<WpsEntity> implements WpsDataAccess {

    public WpsDao(EntityManager em) {
        super(em);
    }

    @Override
    public WpsEntity find(Object primaryKey) {
        return em.find(WpsEntity.class, Param.notNull(primaryKey, "primaryKey"));
    }

    @Override
    public List<WpsEntity> get(Integer start, Integer count) {
        return getBy("wps.getAll", WpsEntity.class, count, count);
    }

    @Override
    public List<WpsEntity> getAll() {
        return get(null, null);
    }
    
}
