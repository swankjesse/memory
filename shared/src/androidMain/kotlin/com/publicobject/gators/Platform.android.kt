package com.publicobject.gators

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class AndroidPlatform : Platform {
  override val mainScope: CoroutineScope
    get() = MainScope()
}

actual fun getPlatform(): Platform = AndroidPlatform()
