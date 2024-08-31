package com.publicobject.gators

import kotlinx.coroutines.CoroutineScope

interface Platform {
  val platform: String

  val mainScope: CoroutineScope
}

expect fun getPlatform(): Platform
