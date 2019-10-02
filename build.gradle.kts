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
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}