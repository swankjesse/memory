package com.publicobject.gators

/**
 * Detect nearby Gators by using the device bluetooth radio and the animal's tracking tags.
 */
interface GatorsService: AutoCloseable {

  fun addListener(listener: Listener)

  fun removeListener(listener: Listener)

  interface Listener {
    fun onGators(nearbyGators: List<NearbyGator>)
  }
}
