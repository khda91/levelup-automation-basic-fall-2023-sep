plugins {
    `java-library`
    checkstyle
}

checkstyle {
    toolVersion = "10.3.3"
}

dependencies {
    api("commons-io:commons-io:2.13.0")

    api("io.github.openfeign:feign-jackson:11.8")
    api("com.squareup.retrofit2:converter-jackson:2.6.3")

    implementation("com.fasterxml.jackson.core:jackson-databind") {
        constraints {
            implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
        }
    }
}

group = "ru.levelp.at"
version = "1.0-SNAPSHOT"
description = "levelup-automation-basic-fall-2023-sep"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

configurations.compileClasspath {
    resolutionStrategy.deactivateDependencyLocking()
}

