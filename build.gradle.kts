plugins {
    application
    kotlin("jvm") version "1.3.60"
}

group = "com.johnturkson.website"
version = "1.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("io.ktor:ktor-server-netty:1.2.6")
    compile("io.ktor:ktor-server-cio:1.2.6")
}

application {
    mainClassName = "MainKt"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
