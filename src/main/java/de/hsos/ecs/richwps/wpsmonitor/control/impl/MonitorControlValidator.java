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
package de.hsos.ecs.richwps.wpsmonitor.control.impl;

import de.hsos.ecs.richwps.wpsmonitor.data.entity.WpsEntity;
import de.hsos.ecs.richwps.wpsmonitor.data.entity.WpsProcessEntity;
import de.hsos.ecs.richwps.wpsmonitor.util.Validate;

/**
 * This class uses the static Validate Class to check parameters of the 
 * MonitorControl implementation.
 * 
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class MonitorControlValidator {
    
    private final Long minStringLength;
    private final Long maxStringLength;    

    public MonitorControlValidator(final Long minStringLength, final Long maxStringLength) {
        this.minStringLength = minStringLength;
        this.maxStringLength = maxStringLength;        
    }

    public void validateStringParam(final String... vars) {
        for (String t : vars) {
            Validate.notEmpty(t);
            Validate.max(t, maxStringLength);
            Validate.min(t, minStringLength);
            Validate.matchesRegex(t, "[\\w_\\-!-~'()*]*");
        }
    }

    public void validateProcessEntityFlat(final WpsProcessEntity wpsProcessEntity) {
        Validate.notNull(wpsProcessEntity, "WpsProcessEntity Parameter");
        Validate.notNull(wpsProcessEntity.getWps(), "The WPS Identifier of the inner WpsEntity of the given WpsProcessEntity");
    }

    public void validateProcessEntityDeep(final WpsProcessEntity wpsProcessEntity) {
        validateProcessEntityFlat(wpsProcessEntity);
        validateWpsEntity(wpsProcessEntity.getWps());
    }

    public void validateWpsEntity(final WpsEntity wpsEntity) {
        Validate.notNull(wpsEntity, "wpsEntity");
        Validate.notNull(wpsEntity.getUri(), "The URI instance of the given wpsEntity ");
        Validate.notEmpty(wpsEntity.getIdentifier());

        MonitorControlValidator.this.validateStringParam(wpsEntity.getIdentifier());
    }
}
