import org.jetbrains.intellij.tasks.PatchPluginXmlTask

plugins {
  java
  id("org.jetbrains.intellij") version "0.4.15"
  kotlin("jvm") version "1.3.61"
}

group = "com.github.lppedd"
version = "0.2.2"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-jdk8", "1.3.61"))
  implementation("com.google.code.gson", "gson", "2.8.6")
  testCompile("junit:junit:4.12")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
  compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }

  compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
}

intellij {
  version = "IU-2019.2"
  downloadSources = true
  pluginName = "Conventional Commit"
  setPlugins("java")
}

tasks.getByName<PatchPluginXmlTask>("patchPluginXml") {
  version(project.version)
  sinceBuild("192")
  untilBuild("201.*")
  pluginDescription(File("plugin-description.html").readText(Charsets.UTF_8))
  changeNotes(File("change-notes/${version.replace('.', '_')}.html").readText(Charsets.UTF_8))
}
