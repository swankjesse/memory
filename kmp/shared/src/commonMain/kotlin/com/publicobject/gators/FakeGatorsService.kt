package com.publicobject.gators

import kotlin.math.sin
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * A carefully-tuned fake detector that shows a couple gators after 5 seconds.
 */
class FakeGatorsService(
  scope: CoroutineScope,
) : GatorsService {

  private val job: Job
  private val listenersState = MutableStateFlow(listOf<GatorsService.Listener>())

  init {
    job = scope.launch {
      scanForNearbyGatorsAndNotifyListeners()
    }
  }

  override fun addListener(listener: GatorsService.Listener) {
    listenersState.update { listeners ->
      listeners + listener
    }
  }

  override fun removeListener(listener: GatorsService.Listener) {
    listenersState.update { listeners -> listeners.filter { it == listener } }
  }

  override fun close() {
    job.cancel()
  }

  private suspend fun scanForNearbyGatorsAndNotifyListeners() {
    var time = 0.0
    while (true) {
      val nearbyGators = scanForNearbyGators(time)

      for (listener in listenersState.value) {
        listener.onGators(nearbyGators)
      }

      delay(100.milliseconds)
      time += 0.1
    }
  }

  internal fun scanForNearbyGators(time: Double): List<NearbyGator> {
    val result = mutableListOf<NearbyGator>()

    val chompyDistance = minOf(
      sin(3 + time / 4.5) * 9.0,
      sin(1 + time / 6.3) * 8.0,
      sin(6 + time / 5.3) * 8.0,
    )
    if (chompyDistance >= 0) {
      result += NearbyGator("Chompy", chompyDistance + 8.0)
    }

    val lyleDistance = minOf(
      sin(5 + time / 3.5) * 3.0,
      sin(7 + time / 6.1) * 7.0,
      sin(4 + time / 4.6) * 4.0,
    )
    if (lyleDistance >= 0) {
      result += NearbyGator("Lyle", lyleDistance + 3.0)
    }

    val allyDistance = minOf(
      sin(5 + time / 3.9) * 1.0,
      sin(13 + time / 4.7) * 2.0,
      sin(12 + time / 5.1) * 3.0,
    )
    if (allyDistance >= 0) {
      result += NearbyGator("Ally", allyDistance + 4.0)
    }

    val smileyDistance = minOf(
      sin(8 + time / 4.6) * 6.0,
      sin(5 + time / 5.2) * 4.0,
      sin(0 + time / 7.1) * 3.0,
    )
    if (smileyDistance >= 0) {
      result += NearbyGator("Smiley", smileyDistance + 7.0)
    }

    result.sortBy { it.distance }

    return result
  }
}
