import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.4" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
	kotlin("jvm") version "1.4.31" apply false
	kotlin("plugin.spring") version "1.4.31" apply false
	kotlin("plugin.jpa") version "1.4.31" apply false
}

allprojects {
	group = "br.com.celfons"
	version = "0.0.1-SNAPSHOT"

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

}

buildscript {
	repositories {
		jcenter()
		mavenCentral()
	}
}

subprojects {
	repositories {
		jcenter()
		mavenCentral()
	}

	apply {
		plugin("io.spring.dependency-management")
	}
}