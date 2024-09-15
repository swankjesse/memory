package com.publicobject.gators.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.publicobject.gators.FakeGatorsService
import com.publicobject.gators.getPlatform

class HomeActivity : ComponentActivity() {
  private val scope = getPlatform().mainScope
  private var service = FakeGatorsService(scope)
  private var showNearbyGators by mutableStateOf(false)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      if (showNearbyGators) {
        NearbyGatorsScreen(
          content = NearbyGatorsContent(service),
          onDismiss = {
            showNearbyGators = false
          },
        ).Show()
        return@setContent
      }

      Home()
    }
  }

  @Composable
  fun Home() {
    Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
    ) {
      Button(
        onClick = {
          showNearbyGators = true
        },
      ) {
        Text("Show Nearby Gators")
      }
    }
  }
}

