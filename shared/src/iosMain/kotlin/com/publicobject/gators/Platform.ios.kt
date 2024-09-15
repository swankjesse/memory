package com.publicobject.gators

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class IOSPlatform : Platform {
  override val mainScope: CoroutineScope = MainScope()
}

actual fun getPlatform(): Platform = IOSPlatform()
