import Shared
import SwiftUI

class NearbyGatorsObservableObject: ObservableObject, GatorsServiceListener {
    @Published var nearbyGators: [NearbyGator] = []

    init(gatorsService: GatorsService) {
        gatorsService.addListener(listener: self)
    }

    func onGators(nearbyGators: [NearbyGator]) {
        self.nearbyGators = nearbyGators
    }
}
