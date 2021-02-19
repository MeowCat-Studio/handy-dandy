/**
 * Copyright 2020-2021 Itsusinn and contributors.
 *
 * Licensed under the GNU Lesser General Public License version 3,
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://opensource.org/licenses/LGPL-3.0
 */
plugins {
   java
   kotlin("jvm") version "1.4.30"
   id("com.github.johnrengelman.shadow") version "6.1.0"
   `maven-publish` // Jitpack
}

group = "io.itsusinn.forward"
version = "0.0.1"

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"

repositories {
   mavenCentral()
}

dependencies {
   implementation(kotlin("stdlib"))
   compileOnly("io.github.microutils:kotlin-logging-jvm:2.0.2")
   // jackson
   compileOnly(Dependency.Jackson.Core)
   compileOnly(Dependency.Jackson.DataBind)
   compileOnly(Dependency.Jackson.Annotations)
   compileOnly(Dependency.Jackson.KotlinModule)

   compileOnly(Dependency.KotlinX.Coroutine)

   compileOnly(Dependency.Okhttp)
}
object Versions {
   const val Kotlin = "1.4.30"
   const val Okhttp = "4.9.0"
   const val Ktor = "1.5.0"
   const val Coroutine = "1.4.1"
   const val Jackson = "2.12.1"
   const val Slf4j = "1.7.30"
   const val Mirai = "2.3.2"
   const val ShadowJar = "6.1.0"
   const val Vertx = "4.0.0"
}
object Dependency {
   object Kotlin {
      private const val group = "org.jetbrains.kotlin"
      const val StdLib = "$group:kotlin-stdlib:${Versions.Kotlin}"
      const val StbLib7 = "$group:kotlin-stdlib-jdk7:${Versions.Kotlin}"
      const val StbLib8 = "$group:kotlin-stdlib-jdk8:${Versions.Kotlin}"
      const val Reflect = "$group:kotlin-reflect:${Versions.Kotlin}"
   }
   object KotlinX {
      private const val group = "org.jetbrains.kotlinx"
      const val Coroutine = "$group:kotlinx-coroutines-core:${Versions.Coroutine}"
   }
   object Ktor {
      private const val group = "io.ktor"
      const val Core = ""
      object Client {
         const val WebSocket = "$group:ktor-client-websockets:${Versions.Ktor}"
         const val CIO = "$group:ktor-client-cio:${Versions.Ktor}"
      }
   }
   object Jackson {
      private const val group = "com.fasterxml.jackson"
      const val Core = "$group.core:jackson-core:${Versions.Jackson}"
      const val DataBind = "$group.core:jackson-databind:${Versions.Jackson}"
      const val Annotations = "$group.core:jackson-annotations:${Versions.Jackson}"
      const val KotlinModule = "$group.module:jackson-module-kotlin:${Versions.Jackson}"
   }
   const val Okhttp = "com.squareup.okhttp3:okhttp:${Versions.Okhttp}"
   const val Slf4j = "org.slf4j:slf4j-api:${Versions.Slf4j}"
}
