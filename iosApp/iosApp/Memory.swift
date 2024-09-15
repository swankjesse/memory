import Shared

class Memory {
    func aggressiveKotlinGc(count: Int = 3) {
        Task {
            KotlinMemory.shared.blockingCollect()
            if count > 0 {
                Task { @MainActor in
                    aggressiveKotlinGc(count: count - 1)
                }
            }
        }
    }
}
