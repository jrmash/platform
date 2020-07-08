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
package io.mashinations.platform

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class OperatingSystemTest : ExpectSpec({
    context("Current Tests") {
        val osName = System.getProperty("os.name")

        expect("OperatingSystem.forName(osName).isCurrent() to return true") {
            OperatingSystem.forName(osName).isCurrent.shouldBeTrue()
        }
        expect("(OperatingSystem.forName(osName) == OperatingSystem.CURRENT) to return true") {
            (OperatingSystem.forName(osName) == OperatingSystem.CURRENT).shouldBeTrue()
        }
    }
    context("Enum Tests") {
        forAll(
            row(OperatingSystem.AIX, b = false, c = false, d = false, e = true, f = false),
            row(OperatingSystem.BSD, b = false, c = false, d = false, e = true, f = false),
            row(OperatingSystem.DARWIN, b = true, c = false, d = false, e = true, f = false),
            row(OperatingSystem.HPUX, b = false, c = false, d = false, e = true, f = false),
            row(OperatingSystem.LINUX, b = false, c = true, d = false, e = true, f = false),
            row(OperatingSystem.SOLARIS, b = false, c = false, d = true, e = false, f = false),
            row(OperatingSystem.UNKNOWN, b = false, c = false, d = false, e = false, f = false),
            row(OperatingSystem.WINDOWS, b = false, c = false, d = false, e = false, f = true)
        ) { os, isDarwin, isLinux, isSolaris, isUnix, isWindows ->
            expect("OperatingSystem.${os.name}.isDarwin() to return $isDarwin") {
                os.isDarwin.shouldBe(isDarwin)
            }
            expect("OperatingSystem.${os.name}.isLinux() to return $isLinux") {
                os.isLinux.shouldBe(isLinux)
            }
            expect("OperatingSystem.${os.name}.isSolaris() to return $isSolaris") {
                os.isSolaris.shouldBe(isSolaris)
            }
            expect("OperatingSystem.${os.name}.isUnix() to return $isUnix") {
                os.isUnix.shouldBe(isUnix)
            }
            expect("OperatingSystem.${os.name}.isWindows() to return $isWindows") {
                os.isWindows.shouldBe(isWindows)
            }
        }
    }
    context("ForName Tests") {
        forAll(
            row("AIX", b = false, c = false, d = false, e = true, f = false),
            row("FreeBSD", b = false, c = false, d = false, e = true, f = false),
            row("NetBSD", b = false, c = false, d = false, e = true, f = false),
            row("OpenBSD", b = false, c = false, d = false, e = true, f = false),
            row("Darwin", b = true, c = false, d = false, e = true, f = false),
            row("Mac", b = true, c = false, d = false, e = true, f = false),
            row("Mac OS X", b = true, c = false, d = false, e = true, f = false),
            row("OSX", b = true, c = false, d = false, e = true, f = false),
            row("HP-UX", b = false, c = false, d = false, e = true, f = false),
            row("Linux", b = false, c = true, d = false, e = true, f = false),
            row("Solaris", b = false, c = false, d = true, e = false, f = false),
            row("SunOS", b = false, c = false, d = true, e = false, f = false),
            row("Windows 95", b = false, c = false, d = false, e = false, f = true),
            row("Windows 98", b = false, c = false, d = false, e = false, f = true),
            row("Windows ME", b = false, c = false, d = false, e = false, f = true),
            row("Windows XP", b = false, c = false, d = false, e = false, f = true),
            row("Windows Vista", b = false, c = false, d = false, e = false, f = true),
            row("Windows 7", b = false, c = false, d = false, e = false, f = true),
            row("Windows 8.1", b = false, c = false, d = false, e = false, f = true),
            row("Windows 8", b = false, c = false, d = false, e = false, f = true),
            row("Windows 10", b = false, c = false, d = false, e = false, f = true),
            row("Windows NT", b = false, c = false, d = false, e = false, f = true),
            row("Windows 2000", b = false, c = false, d = false, e = false, f = true),
            row("Windows 2003", b = false, c = false, d = false, e = false, f = true),
            row("Windows Server 2008 R2", b = false, c = false, d = false, e = false, f = true),
            row("Windows Server 2008", b = false, c = false, d = false, e = false, f = true),
            row("Windows Server 2012 R2", b = false, c = false, d = false, e = false, f = true),
            row("Windows Server 2012", b = false, c = false, d = false, e = false, f = true),
            row("Windows Server 2016", b = false, c = false, d = false, e = false, f = true),
            row("Windows Server 2019", b = false, c = false, d = false, e = false, f = true),
            row("Windows (unknown)", b = false, c = false, d = false, e = false, f = true),
            row("Windows 9X (unknown)", b = false, c = false, d = false, e = false, f = true),
            row("Windows NT (unknown)", b = false, c = false, d = false, e = false, f = true),
            row("Unknown", b = false, c = false, d = false, e = false, f = false)
        ) { osName, isDarwin, isLinux, isSolaris, isUnix, isWindows ->
            val os = OperatingSystem.forName(osName)

            expect("OperatingSystem.forName(${osName}).isDarwin() to return $isDarwin") {
                os.isDarwin.shouldBe(isDarwin)
            }
            expect("OperatingSystem.forName(${osName}).isLinux() to return $isLinux") {
                os.isLinux.shouldBe(isLinux)
            }
            expect("OperatingSystem.forName(${osName}).isSolaris() to return $isSolaris") {
                os.isSolaris.shouldBe(isSolaris)
            }
            expect("OperatingSystem.forName(${osName}).isUnix() to return $isUnix") {
                os.isUnix.shouldBe(isUnix)
            }
            expect("OperatingSystem.forName(${osName}).isWindows() to return $isWindows") {
                os.isWindows.shouldBe(isWindows)
            }
        }
    }
})
