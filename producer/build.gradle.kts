plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("jvm")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(":domain"))
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation ("org.springframework.kafka:spring-kafka:2.6.7")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
