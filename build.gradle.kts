plugins {
    kotlin("jvm") version "1.2.60"
    `java-gradle-plugin`
    `kotlin-dsl`
    java

    `maven-publish`
    id("com.gradle.plugin-publish") version "0.10.0"
}

group = "org.intellij.l10n"
version = "0.0.1"

repositories {
    jcenter()
}


val spekVersion = "1.1.5"

dependencies {
    compile(gradleApi())
    implementation(kotlin("stdlib-jdk8"))

    compile(kotlin("reflect"))
    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))

    compile("org.apache.commons", "commons-configuration2", "2.3")
    compile("org.jacoco", "org.jacoco.report", "0.8.2")
    compile("commons-beanutils", "commons-beanutils", "1.9.3")
    compile("org.apache.commons", "commons-lang3", "3.7")

    testCompile("junit", "junit", "4.12")
//    testCompile("org.jetbrains.kotlin", "kotlin-test-junit")
}


gradlePlugin {
    plugins {
        create("ijl10ncov") {
            id = "org.intellij.l10n.coverage"
            displayName = "Gradle IntelliJ Localization Coverage Plugin"
            implementationClass = "org.intellij.l10n.LocalizationCoveragePlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/IntelliJ-Localization/intellij-l10-coverage"
    vcsUrl = "https://github.com/IntelliJ-Localization/intellij-l10-coverage"
    description = "Gradle plugin to generate coverage report for localization of IntelliJ .properties"

    (plugins) {
        "ijl10ncov" {
            tags = listOf("IntelliJ", "PyCharm", "coverage", "l10n", "localization")
            version = version
        }
    }

}



publishing {

    repositories {
        mavenLocal()
    }
}


