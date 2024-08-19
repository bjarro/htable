plugins {
  id("java")
  id("org.jetbrains.kotlin.jvm") version "1.9.23"
  id("org.jetbrains.intellij") version "1.17.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

sourceSets {
  named("main") {
    java {
      srcDirs("src/main/java", "gen/htable")
//        srcDirs("src/main/java", "gen")
//        srcDirs("src/main/java", "gen", "gen/htable/psi", "gen/htable/parser")
//      srcDirs("src/main/java", "gen/htable/parser", "gen/htable/psi", "gen/htable")
//      exclude("src/main/java/org/intellij/grammar")
      exclude("**/org/intellij/grammar/**")
    }
  }

    named("test") {
      java {
        srcDirs("src/test/java")
      }
    }
  }

dependencies{
  implementation("de.jflex:jflex:1.7.0")
  implementation("org.jetbrains:grammar-kit:2023.1")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
  version.set("2023.2.6")
  type.set("IC") // Target IDE Platform

  plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
  // Set the JVM compatibility versions
  withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
  }
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
  }

  patchPluginXml {
    sinceBuild.set("232")
    untilBuild.set("242.*")
  }

  signPlugin {
    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
    privateKey.set(System.getenv("PRIVATE_KEY"))
    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
  }

  publishPlugin {
    token.set(System.getenv("PUBLISH_TOKEN"))
  }

  named("classpathIndexCleanup") {
    dependsOn(named("compileTestJava"))
  }

  named("classpathIndexCleanup") {
    dependsOn(named("processTestResources"))
  }
}

tasks.test {
  useJUnitPlatform()
}

