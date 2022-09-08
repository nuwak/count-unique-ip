import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

application {
    mainClass.set("MainKt")
}

group = "i.b"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-simple:2.0.0")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.23")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
}

tasks.test {
    maxHeapSize = "2048m"
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}