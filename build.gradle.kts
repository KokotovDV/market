import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

allprojects {

//    group = "com.siberia"
//    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
    tasks.withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

