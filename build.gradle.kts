import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "Kotlin version of the Ktor Petclinic application"
group = "org.springframework.samples"
version = "1.0.0"

java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    val kotlinVersion = "1.5.31"
    id("io.ktor.plugin") version "3.0.0"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:3.0.0")
    implementation("io.ktor:ktor-server-netty:3.0.0")
    implementation("io.ktor:ktor-serialization:3.0.0")
    implementation("ch.qos.logback:logback-classic:1.2.6")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("io.ktor:ktor-server-tests:3.0.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
