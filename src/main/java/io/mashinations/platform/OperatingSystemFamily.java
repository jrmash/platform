/*
 * Copyright 2020 J.R. Mash
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mashinations.platform;

/**
 * * Enum constants for common operating system families.
 *
 * @author J.R. Mash
 * @since 0.1.0
 */
public enum OperatingSystemFamily {
    DARWIN("Darwin"),
    LINUX("Linux"),
    SOLARIS("Solaris"),
    UNIX("Unix"),
    UNKNOWN("Unknown"),
    WINDOWS("Windows");
    
    private final String name;
    
    private OperatingSystemFamily(String name) {
        this.name = name;
    }
    
    /**
     * @return The properly cased name of the {@code OperatingSystemFamily}.
     * @see #getNameLc()
     * @see #getNameUc()
     * @since 0.1.0
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * @return The lower-cased name of the {@code OperatingSystemFamily}.
     * @see #getName()
     * @see #getNameUc()
     * @since 0.1.0
     */
    public String getNameLc() {
        return this.name.toLowerCase();
    }
    
    /**
     * @return The upper-cased name of the {@code OperatingSystemFamily}.
     * @see #getName()
     * @see #getNameLc()
     * @since 0.1.0
     */
    public String getNameUc() {
        return this.name.toUpperCase();
    }
}
