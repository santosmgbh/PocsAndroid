plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(KtsConstants.targetSdkVersion)
    buildToolsVersion(KtsConstants.buildGradlePlugin)

    defaultConfig {
        applicationId = "com.boleuti.ocurioso"
        minSdkVersion(KtsConstants.minSdkVersion)
        targetSdkVersion(KtsConstants.targetSdkVersion)
        versionCode = KtsConstants.versionCode
        versionName = KtsConstants.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerVersion = KtsConstants.kotlinVersion
        kotlinCompilerExtensionVersion = KtsConstants.compose
    }
}

dependencies {
    implementation("androidx.compose.ui:ui:${KtsConstants.compose}")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:${KtsConstants.compose}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:${KtsConstants.compose}")
    // Material Design
    implementation("androidx.compose.material:material:${KtsConstants.compose}")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:${KtsConstants.compose}")
    implementation("androidx.compose.material:material-icons-extended:${KtsConstants.compose}")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:${KtsConstants.compose}")
    implementation("androidx.compose.runtime:runtime-rxjava2:${KtsConstants.compose}")
    implementation("androidx.activity:activity-compose:${KtsConstants.activityCompose}")
    implementation("com.google.accompanist:accompanist-coil:${KtsConstants.coilCompose}")
    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${KtsConstants.compose}")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${KtsConstants.kotlinVersion}")
    implementation("androidx.core:core-ktx:${KtsConstants.coreKtx}")
    implementation("androidx.appcompat:appcompat:${KtsConstants.appCompat}")
    implementation("com.google.android.material:material:${KtsConstants.material}")
    implementation("androidx.constraintlayout:constraintlayout:${KtsConstants.constraintLayout}")
    implementation("androidx.navigation:navigation-fragment-ktx:${KtsConstants.navigationFragmentKtx}")
    implementation("androidx.navigation:navigation-ui-ktx:${KtsConstants.navigationUiKtx}")
    implementation("com.google.dagger:hilt-android:${KtsConstants.hilt}")
    kapt("com.google.dagger:hilt-android-compiler:${KtsConstants.hilt}")
    testImplementation("junit:junit:${KtsConstants.junit}")
    androidTestImplementation("androidx.test.ext:junit:${KtsConstants.junitExt}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${KtsConstants.expressoCore}")
}
