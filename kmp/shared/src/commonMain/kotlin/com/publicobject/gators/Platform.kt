package com.publicobject.gators

import kotlinx.coroutines.CoroutineScope

interface Platform {
  val mainScope: CoroutineScope
}

expect fun getPlatform(): Platform
