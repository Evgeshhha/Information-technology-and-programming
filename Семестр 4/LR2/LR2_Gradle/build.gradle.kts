import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("org.example.Main")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("org.slf4j:slf4j-api:2.0.13")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    manifest {
        attributes(Pair("Main-Class", "org.example.Main"))
    }
}

abstract class PrintInfoTask : DefaultTask() {
    @TaskAction
    fun print() {
        println("======================================")
        println("Это моя первая пользовательская задача!")
        println("Проект: ${project.name}")
        println("Версия Gradle: ${project.gradle.gradleVersion}")
        println("======================================")
    }
}
tasks.register<PrintInfoTask>("printInfo") {
    group = "Custom"
    description = "Выводит информацию о проект"
}

tasks.register("generateBuildPassport") {
    val outputDir = layout.buildDirectory.dir("resources/main")
    val outputFile = outputDir.map { it.file("build-passport.properties") }

    outputs.file(outputFile)

    doLast {
        val file = outputFile.get().asFile
        file.parentFile.mkdirs()

        val username = System.getenv("USERNAME") ?: System.getenv("USER") ?: "unknown"
        val os = System.getProperty("os.name")
        val javaVersion = System.getProperty("java.version")
        val dateTime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        file.writeText(
            """
            username=$username
            os=$os
            java_version=$javaVersion
            build_time=$dateTime
            message=Hello from Gradle build!
        """.trimIndent()
        )

        println("Build passport generated at: ${file.absolutePath}")
    }
}

tasks.named("processResources") {
    dependsOn("generateBuildPassport")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
