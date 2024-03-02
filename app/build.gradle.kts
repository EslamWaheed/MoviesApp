plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.eslamwaheed.moviesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.eslamwaheed.moviesapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    hilt {
        enableAggregatingTask = true
    }
    kapt { generateStubs = true }
}

dependencies {
    //Core
    implementation("androidx.core:core-ktx:1.12.0")
    //Compose
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    //Junit
    testImplementation("junit:junit:4.13.2")
    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    //Orbit MVI
    implementation("org.orbit-mvi:orbit-core:6.1.1")
    implementation("org.orbit-mvi:orbit-viewmodel:6.1.1")
    implementation("org.orbit-mvi:orbit-compose:6.1.1")
    testImplementation("org.orbit-mvi:orbit-test:6.1.1")
    //Chucker
    debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:4.0.0")
    //Coil
    implementation("io.coil-kt:coil:2.5.0")
    //Fixture
    testImplementation("com.appmattus.fixture:fixture:1.2.0")
    //Mockito
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    //Mockk
    testImplementation("io.mockk:mockk:1.13.5")
    //Domain Module
    implementation(project(path = ":domain"))
    //Data Module
    implementation(project(path = ":data"))
}