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


    testImplementation("org.slf4j:slf4j-simple:2.0.12")
    implementation("org.slf4j:slf4j-simple:1.7.36")
    implementation("org.json:json:20210307")

}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("edu.bsu.cs.wikipedia.WikipediaConnectionDemo")
}
