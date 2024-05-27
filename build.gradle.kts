import java.net.URI

plugins {
    kotlin("jvm") version "1.9.23"
    id("maven-publish")
    id("java-library")
}

group = "de.quarkusVoter"
version = "1.0"

java {
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.quarkus:quarkus-arc:3.7.4+")
    implementation("io.quarkus:quarkus-kotlin:3.7.4+")
    testImplementation(kotlin("test"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "quarkus-voter"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name = "Quarkus voter"
                description = "Simple auth voter library for quarkus"
                url = "https://github.com/MathisBurger/quarkus-voter"
                developers {
                    developer {
                        id = "mathisburger"
                        name = "Mathis Burger"
                        email = "kontakt@mathis-burger.de"
                    }
                }
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = URI("https://maven.pkg.github.com/MathisBurger/quarkus-voter")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}