import Shared
import SwiftUI

struct NearbyGatorsView: View {
    @ObservedObject var nearbyGatorsContent: NearbyGatorsContent

    @Binding var showNearbyGators: Bool

    @State private var message: String = ""

    var body: some View {
        VStack(alignment: .center) {
            List(nearbyGatorsContent.nearbyGators, id: \.name) { nearbyGator in
                HStack {
                    Text(nearbyGator.name)
                        .frame(maxWidth: .infinity, alignment: .leading)
                    Text(String(format: "%.2f m", nearbyGator.distance))
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
