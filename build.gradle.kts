plugins {
    id ("java")
    id ("application")
    id ("org.openjfx.javafxplugin") version "0.1.0"
}

group = "edu.bsu.cs.wikipedia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.slf4j:slf4j-nop:2.0.11")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("net.minidev:json-smart:2.5.0")
    implementation ("org.openjfx:javafx:11")

}

tasks.test {
    useJUnitPlatform()
}
javafx {
    version = "17"
    modules ("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("edu.bsu.cs.wikipedia.GUI")
}
