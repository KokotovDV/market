import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version "1.1.0" apply false
    id("org.springframework.boot") version "3.0.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.22" apply false
    id("org.jetbrains.kotlin.plugin.jpa") version "1.7.22" apply false
    id("org.jetbrains.kotlin.plugin.spring") version "1.7.22" apply false
}

subprojects {

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

