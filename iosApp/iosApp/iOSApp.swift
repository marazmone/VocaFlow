import SwiftUI
import FirebaseCore
import shared

class AppDelegate: NSObject, UIApplicationDelegate {
  func application(_ application: UIApplication,
                   didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
    FirebaseApp.configure()
    initLogger()
    return true
  }
    
    private func initLogger() {
        #if DEBUG
        FirebaseCrashlyticsLogger().doInitDebugBuild()
        #else
        FirebaseCrashlyticsLogger().doInitReleaseBuild()
        #endif
    }
}

@main
struct iOSApp: App {

    @UIApplicationDelegateAdaptor(AppDelegate.self) var delegate

    init() {
        KoinKt.doInitKoin()
    
    }

	var body: some Scene {
		WindowGroup {
            ContentView()
        }
	}
}
