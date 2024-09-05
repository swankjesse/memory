package com.publicobject.gators.app

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.publicobject.gators.GatorsService
import com.publicobject.gators.NearbyGator

class NearbyGatorsContent(
  gatorsService: GatorsService,
) : GatorsService.Listener {
  val list: SnapshotStateList<NearbyGator> = mutableStateListOf()

  init {
    gatorsService.addListener(this)
  }

  override fun onGators(nearbyGators: List<NearbyGator>) {
    list.clear()
    list.addAll(nearbyGators)
  }
}
