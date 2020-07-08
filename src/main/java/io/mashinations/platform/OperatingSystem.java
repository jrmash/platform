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

import java.util.regex.Pattern;

/**
 * Enum constants for many common operating systems.
 *
 * @author J.R. Mash
 * @since 0.1.0
 */
public enum OperatingSystem {
    AIX(OperatingSystemFamily.UNIX, "^AIX$"),
    BSD(OperatingSystemFamily.UNIX, "^(Free|Net|Open)BSD$"),
    DARWIN(OperatingSystemFamily.DARWIN, "^(Darwin|(Mac)?(\\s*OS\\s*X)?)$"),
    HPUX(OperatingSystemFamily.UNIX, "^HP-UX$"),
    LINUX(OperatingSystemFamily.LINUX, "^Linux$"),
    SOLARIS(OperatingSystemFamily.SOLARIS, "^S(olaris|unOS)$"),
    WINDOWS(OperatingSystemFamily.WINDOWS, "^Windows(\\s+Server)?.+$"),
    UNKNOWN(OperatingSystemFamily.UNKNOWN, "^$");
    
    public static final OperatingSystem CURRENT = forName(System.getProperty("os.name"));
    
    private final OperatingSystemFamily family;
    private final Pattern pattern;

    OperatingSystem(OperatingSystemFamily family, String regex) {
        this.family = family;
        this.pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }

    /**
     * @param name The name of the OS to look up, typically obtained
     *             from the 'os.name' property.
     *             <pre>
     *              {@code
     *              OperatingSystem.forName( System.getProperty("os.name") );
     *              }
     *             </pre>
     * @return {@link OperatingSystem}
     * @since 0.1.0
     */
    public static OperatingSystem forName(String name) {
        for (OperatingSystem os : OperatingSystem.values()) {
            if (os.pattern.matcher(name).matches()) {
                return os;
            }
        }
        return UNKNOWN;
    }

    /**
     * Returns {@code true} if {@link OperatingSystem} is the current.
     *
     * <pre>
     * {@code
     * if (OperatingSystem.DARWIN.isCurrent()) {
     *     ...
     * }
     * }
     * </pre>
     *
     * @return {@link Boolean}
     * @since 0.1.0
     */
    public Boolean isCurrent() {
        return OperatingSystem.CURRENT.equals(this);
    }
    
    /**
     * Returns {@code true} if {@link OperatingSystem} is Darwin based.
     *
     * @return {@link Boolean}
     * @since 0.1.0
     */
    public Boolean isDarwin() {
        return OperatingSystemFamily.DARWIN.equals(this.family);
    }

    /**
     * Returns {@code true} if {@link OperatingSystem} is Linux based.
     *
     * @return {@link Boolean}
     * @since 0.1.0
     */
    public Boolean isLinux() {
        return OperatingSystemFamily.LINUX.equals(this.family);
    }

    /**
     * Returns {@code true} if {@link OperatingSystem} is Solaris based.
     *
     * @return {@link Boolean}
     * @since 0.1.0
     */
    public Boolean isSolaris() {
        return OperatingSystemFamily.SOLARIS.equals(this.family);
    }

    /**
     * Returns {@code true} if {@link OperatingSystem} is Unix based.
     *
     * @return {@link Boolean}
     * @since 0.1.0
     */
    public Boolean isUnix() {
        return OperatingSystemFamily.UNIX.equals(this.family) || this.isDarwin() || this.isLinux();
    }

    /**
     * Returns {@code true} if {@link OperatingSystem} is Windows based.
     *
     * @return {@link Boolean}
     * @since 0.1.0
     */
    public Boolean isWindows() {
        return OperatingSystemFamily.WINDOWS.equals(this.family);
    }
}
