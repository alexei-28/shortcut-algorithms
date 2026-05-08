plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

val log4jVersion = "2.20.0"

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.18"))

    implementation("org.slf4j:slf4j-api")

    runtimeOnly("org.apache.logging.log4j:log4j-slf4j2-impl:$log4jVersion")
    runtimeOnly("org.apache.logging.log4j:log4j-core")

    testImplementation("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter")

}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.12.1")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "com.gmail.alexei28.shortcutalgorithms.App"
}


tasks.test {
    testLogging {
        events("passed", "skipped", "failed")

        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL

        showExceptions = true
        showCauses = true
        showStackTraces = true

        showStandardStreams = true
    }

    afterSuite(KotlinClosure2<TestDescriptor, TestResult, Unit>({ desc, result ->
        if (desc.parent == null) {
            println(
                "\nResults: ${result.successfulTestCount} passed, " +
                        "${result.failedTestCount} failed, " +
                        "${result.skippedTestCount} skipped"
            )
        }
    }))
}
