// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    //AŞAĞIDAKİ KSP = https://kotlinlang.org/docs/ksp-quickstart.html#1bbe656d
    id("com.google.devtools.ksp") version "2.0.0-1.0.21"
    id("com.google.dagger.hilt.android") version "2.44" apply false
    }