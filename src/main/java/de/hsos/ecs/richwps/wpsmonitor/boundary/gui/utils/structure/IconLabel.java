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

package de.hsos.ecs.richwps.wpsmonitor.boundary.gui.utils.structure;

import de.hsos.ecs.richwps.wpsmonitor.util.FileUtils;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Florian Vogelpohl <floriantobias@gmail.com>
 */
public class IconLabel extends JLabel {
    
    public IconLabel(final String path, final String text) {
        init(path, text);
    }

    private void init(final String path, final String text) {
        this.setIcon(new ImageIcon(getClass().getResource(path)));
        this.setText(text);
    }
}
