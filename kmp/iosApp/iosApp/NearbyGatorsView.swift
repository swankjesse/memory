import Shared
import SwiftUI

struct NearbyGatorsView: View {
    @ObservedObject var nearbyGatorsObservableObject: NearbyGatorsObservableObject

    @Binding var showNearbyGators: Bool

    @State private var message: String = ""

    var body: some View {
        VStack(alignment: .center) {
            List(nearbyGatorsObservableObject.nearbyGators, id: \.name) { nearbyGator in
                HStack {
                    Text(nearbyGator.name)
                        .frame(maxWidth: .infinity, alignment: .leading)
                    Text(String(format: "%.2f", nearbyGator.distance))
                }
                .frame(maxWidth: .infinity)
            }

            Button(
                action: {
                    showNearbyGators.toggle()
                },
                label: {
                    Text("Done")
                }
            )
            .padding()
        }
    }
}

