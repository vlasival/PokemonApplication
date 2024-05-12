plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.pokemonapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pokemonapplication"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.converter.gson)
    implementation(libs.compose.bom)
    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.ui)
    implementation(libs.volley)
    implementation(libs.compose)
    implementation(libs.accompanist.coil)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.runtime.android)
    implementation(libs.ui.tooling)
    implementation(libs.androidx.ui.tooling.android)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.material)
    implementation(libs.androidx.material.android)
    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.core.android)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.material.icons.extended.android)
    implementation(libs.activity.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
}