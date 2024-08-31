package com.publicobject.gators

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
  override val platform: String =
    UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

  override val mainScope: CoroutineScope = MainScope()
}

actual fun getPlatform(): Platform = IOSPlatform()
