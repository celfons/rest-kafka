plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("jvm")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(":commons"))
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
	implementation ("org.springframework.kafka:spring-kafka:2.6.7")
	implementation ("com.google.code.gson:gson:2.8.5")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
