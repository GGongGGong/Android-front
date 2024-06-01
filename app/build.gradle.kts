plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.ridingbud"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ridingbud"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit2 Dependency
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.converter.scalars)

    // OkHttp3 Dependency
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // ViewModel Dependency
    implementation(libs.lifecycle.viewmodel.ktx)
    // Lifecycles only (without ViewModel or LiveData)
    implementation(libs.lifecycle.runtime.ktx)

    // 카카오 로그인 API 모듈
    implementation(libs.v2.all)

    // 카카오 맵 API 모듈
    implementation(libs.kakao.maps.android)

    // Fremework KTX Dependency
    implementation(libs.fragment.ktx)
    implementation(libs.activity.ktx)

    // Google Location Service
    implementation(libs.play.services.location)
}