import Foundation
import Shared
import SwiftUI

struct HomeView: View {

    @State private var showCompose: Bool = false

    var body: some View {
        if (showCompose) {
            ComposeView(
                calculator: Calculator.Companion(),
                greeting: Greeting(),
                showCompose: $showCompose
            )

        } else {
            Button(
                action: {
                    showCompose.toggle()
                },
                label: {
                    Text("Compose")
                }
            )
        }
    }
}
