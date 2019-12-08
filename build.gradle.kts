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
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-cio:1.2.6")
    implementation("org.slf4j:slf4j-nop:2.0.0-alpha1")
}

application {
    mainClassName = "WebsiteKt"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    
    wrapper {
        gradleVersion = "6.0.1"
        distributionType = Wrapper.DistributionType.ALL
    }
    
    jar {
        from(sourceSets.main.get().output)
        
        dependsOn(configurations.runtimeClasspath)
        
        from({
            configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
        })
        
        manifest {
            attributes["Manifest-Version"] = "1.0"
            attributes["Main-Class"] = "WebsiteKt"
        }
    }
}
