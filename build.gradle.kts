plugins {
    id("idea")
    id("jacoco")
    id("java")
    kotlin("jvm") version "1.5.0"
}

group = "io.mashinations.platform"
version = "0.0.1"

dependencies {
	testImplementation("io.kotest:kotest-runner-junit5:4.4+")
	testImplementation("io.kotest:kotest-assertions-core:4.5+")
	testImplementation("io.kotest:kotest-property:4.5+")
}

repositories {
   jcenter()
}

tasks.withType<JacocoReport> {
    reports.xml.isEnabled = true
}

tasks.withType<Test> {
	useJUnitPlatform()
}

