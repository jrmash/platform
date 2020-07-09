plugins {
    id("idea")
    id("jacoco")
    id("java")
    kotlin("jvm") version "1.3.72"
}

group = "io.mashinations.platform"
version = "0.0.1"

dependencies {
	testImplementation("io.kotest:kotest-runner-junit5-jvm:4.1+")
	testImplementation("io.kotest:kotest-assertions-core-jvm:4.1+")
	testImplementation("io.kotest:kotest-property-jvm:4.1+")
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

