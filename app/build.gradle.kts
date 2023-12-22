plugins {
    kotlin("android")
    id("com.android.application")
}

android {
    compileSdkVersion(34)
    namespace = "com.example.jessschristmasstory";

    defaultConfig {
        applicationId = "com.example.jessschristmasstory" // Specify your package name here
        minSdkVersion(25)
        targetSdkVersion(34)
        versionCode = 1
        versionName = "1.0"

        // Add the following line to set the namespace
        resConfigs("en") // You can change "en" to your desired resource configuration

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // Enable Jetpack Compose
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1" // Use the latest version compatible with your Kotlin version
    }

    // View Binding enabled for your project
    viewBinding.isEnabled = true
}
dependencies {
    implementation(kotlin("stdlib-jdk8", "1.6.10")) // Updated Kotlin version

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.6.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    // Jetpack Compose dependencies
    implementation("androidx.compose.ui:ui:1.2.0")
    implementation("androidx.compose.material:material:1.2.0")
    implementation("androidx.activity:activity-compose:1.3.1") // For integrating with activities

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Debugging tools for Compose
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.0")
}