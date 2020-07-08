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
import io.kotest.matchers.shouldBe

class OperatingSystemFamilyTest : ExpectSpec({
    context("Verify 'OperatingSystemFamily' Support") {
        forAll(
            row(OperatingSystemFamily.DARWIN, "Darwin", "darwin", "DARWIN"),
            row(OperatingSystemFamily.LINUX, "Linux", "linux", "LINUX"),
            row(OperatingSystemFamily.SOLARIS, "Solaris", "solaris", "SOLARIS"),
            row(OperatingSystemFamily.UNIX, "Unix", "unix", "UNIX"),
            row(OperatingSystemFamily.UNKNOWN, "Unknown", "unknown", "UNKNOWN"),
            row(OperatingSystemFamily.WINDOWS, "Windows", "windows", "WINDOWS")
        ) { f, fName, fNameLc, fNameUc ->
            expect("The '${f}.getName()' method to return '$fName'") {
                f.getName().shouldBe(fName)
            }
            expect("The '${f}.getNameLc()' method to return '$fNameLc'") {
                f.nameLc.shouldBe(fNameLc)
            }
            expect("The '${f}.getNameUc()' method to return '$fNameUc'") {
                f.nameUc.shouldBe(fNameUc)
            }
        }
    }
})
