import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
}

kotlin {
  androidTarget {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
      jvmTarget.set(JvmTarget.JVM_11)
    }
  }

  listOf(
      iosX64(),
      iosArm64(),
      iosSimulatorArm64(),
  ).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "Shared"
      isStatic = true
    }
  }

  targets.withType<KotlinNativeTarget>().all {
    compilations.configureEach {
      compileTaskProvider.configure {
        // Fail the build if we use any functions without declaring them. Otherwise, we risk getting
        // IrLinkageError crashes at runtime if we use binary-incompatible library versions for
        // compile and deploy.
        compilerOptions.freeCompilerArgs.add("-Xpartial-linkage-loglevel=ERROR")

        // Get comments into Shared.h
        // https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
        compilerOptions.freeCompilerArgs.add("-Xexport-kdoc")

        // This makes the Xcode memory analyzer graphs easier to understand. Be careful when using
        // this in production; it's not as stable as the default allocator. (See KT-68769)
        compilerOptions.freeCompilerArgs.add("-Xallocator=std")

        // https://slack-chats.kotlinlang.org/t/18860817/trying-to-update-to-kotlin-2-0-0-and-when-i-build-my-ios-app
        compilerOptions.freeCompilerArgs.add("-opt")
      }
    }
  }

  sourceSets {
    commonMain.dependencies {
      implementation(libs.kotlinx.coroutines.core)
    }
    commonTest.dependencies {
      implementation(kotlin("test"))
      implementation(libs.assertk)
      implementation(libs.kotlinx.coroutines.test)
    }
    val androidUnitTest by getting {
      dependencies {
        implementation(libs.junit)
      }
    }
  }
}

android {
  namespace = "com.publicobject.gators.shared"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
}
