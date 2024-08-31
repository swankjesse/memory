import Foundation
import Shared
import SwiftUI

struct HomeView: View {
    let gatorsService = FakeGatorsService(scope: IOSPlatform().mainScope)

    @State private var showNearbyGators: Bool = false

    var body: some View {
        if (showNearbyGators) {
            NearbyGatorsView(
                nearbyGatorsObservableObject: NearbyGatorsObservableObject(gatorsService: gatorsService),
                showNearbyGators: $showNearbyGators
            )

        } else {
            Button(
                action: {
                    showNearbyGators.toggle()
                },
                label: {
                    Text("Show Nearby Gators")
                }
            )
        }
    }
}
