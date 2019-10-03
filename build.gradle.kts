import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    application
}

group = "io.github.rafaeljpc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

application {
    mainClassName = "io.github.rafaeljpc.tutorial.spark.MainKt"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.sparkjava:spark-core:2.8.+")
    implementation("org.slf4j:slf4j-simple:1.7.+")
    implementation("com.google.code.gson:gson:2.8.+")
    runtime("org.slf4j:slf4j-simple:1.7.+")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}