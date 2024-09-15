package com.publicobject.gators

import kotlin.native.runtime.GC
import kotlin.native.runtime.NativeRuntimeApi

/**
 * Call this in debug builds to collect Kotlin objects and chains of Kotlin + Swift objects.
 * This isn't necessary for correct application behavior, but it is helpful when doing memory
 * analysis because it removes unreachable objects.
 *
 * This function runs a Kotlin GC on a background thread, which may have the side effect of
 * queueing some Swift objects to be eligible for `deinit()` on the main thread.
 *
 * And running that `deinit()` on the main thread will potentially make some Kotlin objects eligible
 * for collection!
 *
 * We've chosen the number of rounds to be 3 because it seems to be enough in practice.
 *
 * https://kotlinlang.org/docs/native-ios-integration.html
 */
@OptIn(NativeRuntimeApi::class)
object KotlinMemory {
  fun blockingCollect() { GC.collect() }
}
