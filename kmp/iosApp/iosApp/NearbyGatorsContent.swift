import Shared
import SwiftUI

class NearbyGatorsContent: ObservableObject {
    private let gatorsService: GatorsService

    private let listener: Listener

    @Published var nearbyGators: [NearbyGator] = []

    init(gatorsService: GatorsService) {
        self.gatorsService = gatorsService
        self.listener = Listener()
        self.listener.content = self
        gatorsService.addListener(listener: listener)
    }

    deinit {
        gatorsService.removeListener(listener: listener)
    }

    private class Listener : GatorsServiceListener {
        weak var content: NearbyGatorsContent? = nil

        func onGators(nearbyGators: [NearbyGator]) {
            content?.nearbyGators = nearbyGators
        }
    }
}
