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
package de.hsos.ecs.richwps.wpsmonitor.boundary.restful.metric;

import com.google.gson.Gson;
import de.hsos.ecs.richwps.wpsmonitor.boundary.restful.metric.units.MeasureUnit;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class MeasuredValue {
    private final Number value;
    private final MeasureUnit measureUnit;

    public MeasuredValue(final Number value, final MeasureUnit measureUnit) {
        this.value = value;
        this.measureUnit = measureUnit;
    }

    public Number getValue() {
        return value;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }
    
    @Override
    public String toString() {
        return value.toString() + measureUnit.toString();
    }
    
    public static void main(String[] args) {
        MeasureUnit measureUnit = new MeasureUnit(MeasureUnit.Prefix.MILLI, MeasureUnit.Unit.SECOND);
        MeasuredValue value = new MeasuredValue(2.3, measureUnit);
        Gson g = new Gson();
        
        System.out.println(value);
        System.out.println(g.toJson(value));
    }
}
