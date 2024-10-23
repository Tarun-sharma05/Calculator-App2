// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
val defaultTargetSdkVersion by extra(34)
val buildToolsVersion by extra("34.0.0")
val defaultTargetSdkVersion1 by extra(35)
val buildToolsVersion1 by extra("35.0.0")
