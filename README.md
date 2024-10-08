# GC You Later, Allocator

Code and resources from my 2024 tech talk on memory.

## Reference Materials

### Apple and iOS

 * [Automatic Reference Counting], The Swift language documentation
 * [Reducing your app’s memory use], Apple’s doc on memory efficiency
 * [Preventing memory-use regressions], Apple’s doc on using XCTest for testing
 * [iOS Memory Deep Dive], Talk from WWDC 2018
 * [RefCount.h]: Swift’s implementation of reference counting
 * [Swift 4 Weak References]: Mike Ash blog post on Swift’s implementation of weak references
 * [LeakDetector]: Steve Dao’s runtime memory leak detector for iOS

### Kotlin/Native

 * [ObjCBackRef.hpp]: Bridges a reference counted object to a garbage collected object
 * [SpecialRefRegistry.hpp]: Root references and weak references

### JVM

 * [2024 Valhalla Talk]: Talk from Brian Goetz on ‘Java’s Epic Refactor’
 * [YourKit]: My favorite profiler

### Sample Code

 * [LeakDetector.kt]: Redwood's runtime leak detector
 * [LeakWatcher.kt]: Redwood's leak tester for the JVM

## Running This Sample

### Android

```
./gradlew installDebug
```

### iOS

Open the project in Xcode and launch it.



[2024 Valhalla Talk]: https://www.reddit.com/r/java/comments/1ezc6ns/jvmls_valhalla_talk/
[Automatic Reference Counting]: https://docs.swift.org/swift-book/documentation/the-swift-programming-language/automaticreferencecounting/
[LeakDetector]: https://github.com/duyquang91/leakdetector
[LeakDetector.kt]: https://github.com/cashapp/redwood/blob/0.14.0/redwood-leak-detector/src/commonMain/kotlin/app/cash/redwood/leaks/LeakDetector.kt
[LeakWatcher.kt]: https://github.com/cashapp/redwood/blob/0.14.0/redwood-treehouse-host/src/appsJvmTest/kotlin/app/cash/redwood/treehouse/leaks/LeakWatcher.kt
[ObjCBackRef.hpp]: https://github.com/JetBrains/kotlin/blob/master/kotlin-native/runtime/src/mm/cpp/ObjCBackRef.hpp
[Preventing memory-use regressions]: https://developer.apple.com/documentation/xcode/preventing-memory-use-regressions/
[Reducing your app’s memory use]: https://developer.apple.com/documentation/xcode/reducing-your-app-s-memory-use
[RefCount.h]: https://github.com/swiftlang/swift/blob/main/stdlib/public/SwiftShims/swift/shims/RefCount.h
[SpecialRefRegistry.hpp]: https://github.com/JetBrains/kotlin/blob/master/kotlin-native/runtime/src/mm/cpp/SpecialRefRegistry.hpp
[Swift 4 Weak References]: https://www.mikeash.com/pyblog/friday-qa-2017-09-22-swift-4-weak-references.html
[YourKit]: https://www.yourkit.com/
[iOS Memory Deep Dive]: https://developer.apple.com/videos/play/wwdc2018/416/
