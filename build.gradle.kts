plugins {
    kotlin("jvm") version "1.8.10"
    application
}

group = "io.github.ajlettuce"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-Beta")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}