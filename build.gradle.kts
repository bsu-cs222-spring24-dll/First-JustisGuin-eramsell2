plugins {
    id("java")
    id("application")
}

group = "edu.bsu.cs.wikipedia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    //jsonpath
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    //json
    implementation("net.minidev:json-smart:2.5.0")

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    testImplementation("org.slf4j:slf4j-simple:2.0.12")

}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("edu.bsu.cs.wikipedia.WikipediaConnectionDemo")
}
