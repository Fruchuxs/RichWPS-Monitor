/*
 * Copyright 2015 Florian Vogelpohl <floriantobias@gmail.com>.
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
package de.hsos.ecs.richwps.wpsmonitor.boundary.cli.command.impl;

import de.hsos.ecs.richwps.wpsmonitor.boundary.cli.command.MonitorCommand;
import de.hsos.ecs.richwps.wpsmonitor.boundary.cli.command.exception.CommandException;
import de.hsos.ecs.richwps.wpsmonitor.control.Monitor;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class ResumeCommand extends MonitorCommand {

    public ResumeCommand(final Monitor monitor) {
        super("resume", "Resumes the monitoring of a process.", monitor);
    }

    @Override
    public void execute() throws CommandException {
        if (endpoint != null && wpsId == null) {
            wpsId = monitorControl.getWpsId(endpoint);
        }

        if (wpsId != null && identifier != null) {
            monitorControl.resumeMonitoring(wpsId, identifier);
        } else {
            throw new WpsProcessMissingException();
        }
    }

}
