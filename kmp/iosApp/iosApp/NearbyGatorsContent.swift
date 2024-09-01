import Shared
import SwiftUI

class NearbyGatorsContent: ObservableObject, GatorsServiceListener {
    let gatorsService: GatorsService

    @Published var nearbyGators: [NearbyGator] = []

    init(gatorsService: GatorsService) {
        self.gatorsService = gatorsService
        gatorsService.addListener(listener: self)
    }

    func onGators(nearbyGators: [NearbyGator]) {
        self.nearbyGators = nearbyGators
    }

    func close() {
        gatorsService.removeListener(listener: self)
    }
}
