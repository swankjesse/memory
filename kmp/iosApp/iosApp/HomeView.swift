import Foundation
import Shared
import SwiftUI

struct HomeView: View {
    let gatorsService = FakeGatorsService(scope: IOSPlatform().mainScope)

    @State private var showNearbyGators: Bool = false

    var body: some View {
        Button(
            action: {
                showNearbyGators.toggle()
            },
            label: {
                Text("Show Nearby Gators")
            }
        )
        .padding()
        .sheet(isPresented: $showNearbyGators) {
            NearbyGatorsView(
                nearbyGatorsContent: NearbyGatorsContent(gatorsService: gatorsService),
                showNearbyGators: $showNearbyGators
            )
        }

        Button(
            action: {
                Memory().aggressiveKotlinGc()
            },
            label: {
                Text("Force GC")
            }
        )
        .padding()
    }
}
