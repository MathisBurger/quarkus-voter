plugins {
    kotlin("jvm") version "1.9.23"
}

group = "de.mathisburger"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.quarkus:quarkus-arc:3.7.4+")
    implementation("io.quarkus:quarkus-kotlin:3.7.4+")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}