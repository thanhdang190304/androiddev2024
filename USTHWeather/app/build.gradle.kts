plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "vn.edu.usth.weather"
    compileSdk = 34

    defaultConfig {
        applicationId = "vn.edu.usth.weather"
        minSdk = 22
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
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.fragment:fragment:1.3.1")
    implementation("androidx.viewpager:viewpager:1.0.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("androidx.viewpager:viewpager:1.0.0")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.3.0")
    }
