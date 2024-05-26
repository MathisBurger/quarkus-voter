plugins {
    kotlin("jvm") version "1.9.23"
}

group = "de.mathisburger"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.quarkus:quarkus-kotlin")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}