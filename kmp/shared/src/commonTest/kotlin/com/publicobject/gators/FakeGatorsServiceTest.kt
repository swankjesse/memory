package com.publicobject.gators

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.isEmpty
import kotlin.test.Test
import kotlinx.coroutines.test.runTest

class FakeGatorsServiceTest {

  @Test
  fun happyPath() = runTest {
    val service = FakeGatorsService(this)

    assertThat(service.scanForNearbyGators(0.0)).isEmpty()
    assertThat(service.scanForNearbyGators(1.0)).isEmpty()
    assertThat(service.scanForNearbyGators(2.0)).isEmpty()
    assertThat(service.scanForNearbyGators(3.0)).isEmpty()
    assertThat(service.scanForNearbyGators(4.0)).isEmpty()
    assertThat(service.scanForNearbyGators(5.0)).isEmpty()
    assertThat(service.scanForNearbyGators(6.0)).containsExactly(
      NearbyGator("Ally", 4.252512697880013),
    )
    assertThat(service.scanForNearbyGators(7.0)).containsExactly(
      NearbyGator("Ally", 4.489648424809126),
    )
    assertThat(service.scanForNearbyGators(8.0)).containsExactly(
      NearbyGator("Ally", 4.694767610902583),
    )
    assertThat(service.scanForNearbyGators(9.0)).containsExactly(
      NearbyGator("Ally", 4.854458170130908),
    )
    assertThat(service.scanForNearbyGators(10.0)).containsExactly(
      NearbyGator("Ally", 4.958278448745094),
    )
    assertThat(service.scanForNearbyGators(11.0)).containsExactly(
      NearbyGator("Lyle", 3.431634066887972),
      NearbyGator("Ally", 4.718637404133513),
    )
    assertThat(service.scanForNearbyGators(12.0)).containsExactly(
      NearbyGator("Lyle", 4.2791694922331835),
      NearbyGator("Ally", 4.308309219770608),
    )
    assertThat(service.scanForNearbyGators(13.0)).containsExactly(
      NearbyGator("Lyle", 4.956620979004355),
    )
    assertThat(service.scanForNearbyGators(14.0)).containsExactly(
      NearbyGator("Lyle", 3.9053288680022886),
    )
    assertThat(service.scanForNearbyGators(15.0)).isEmpty()
    assertThat(service.scanForNearbyGators(16.0)).isEmpty()
    assertThat(service.scanForNearbyGators(17.0)).isEmpty()

    service.close()
  }
}
