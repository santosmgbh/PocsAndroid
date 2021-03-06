plugins {
    `kotlin-dsl`
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${KtsConstants.buildGradlePlugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${KtsConstants.kotlinVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${KtsConstants.hilt}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clear", Delete::class) {
    delete(rootProject.buildDir)
}