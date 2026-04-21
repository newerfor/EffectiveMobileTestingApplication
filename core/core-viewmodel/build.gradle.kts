plugins {
    alias(libs.plugins.android.library)  // ← library, не application
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.core_viewmodel"
    compileSdk = 36  // ← исправлено (было compileSdk { version = release(36) })

    defaultConfig {
        minSdk = 24  // ← удалены applicationId, targetSdk, versionCode, versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core:core-domain"))
    implementation(libs.koin.core)
     implementation(libs.koin.android)  // ← удалить (не нужно в library без Activity/Context)
    implementation(libs.androidx.core.ktx)
    // implementation(libs.androidx.appcompat)  // ← удалить (не нужно)
    // implementation(libs.material)  // ← удалить (не нужно)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}