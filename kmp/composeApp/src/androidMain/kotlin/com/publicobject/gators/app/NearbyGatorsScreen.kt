package com.publicobject.gators.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

class NearbyGatorsScreen(
  private val content: NearbyGatorsContent,
  private val onDismiss: () -> Unit,
) {
  @Composable
  fun Show() {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      Column {
        for (nearbyGator in content.list) {
          Row(
            modifier = Modifier
              .padding(16.dp)
              .background(Color.White, shape = RoundedCornerShape(20.dp))
              .padding(16.dp)
              .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
          ) {
            Text(
              fontSize = TextUnit(30f, TextUnitType.Sp),
              text = nearbyGator.name,
            )
            Text(
              fontSize = TextUnit(30f, TextUnitType.Sp),
              text = "%.2f m".format(nearbyGator.distance),
            )
          }
        }
      }

      Button(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        onClick = onDismiss,
      ) {
        Text("Done")
      }
    }
  }
}
