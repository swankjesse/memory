import Shared
import SwiftUI

struct ComposeView: View {
    var calculator: Calculator.Companion
    var greeting: Greeting

    @Binding var showCompose: Bool

    @State private var message: String = ""

    var body: some View {
        VStack(alignment: .center) {
            TextField("Type your message", text: $message)
                .multilineTextAlignment(.leading)
                .padding()

            Button(
                action: {
                    print(message)
                    showCompose.toggle()
                },
                label: {
                    Text("Send")
                }
            )

            Button(
                action: {
                    showCompose.toggle()
                },
                label: {
                    Text("Cancel")
                }
            )
        }
    }
}
