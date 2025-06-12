import SwiftUI
import shared

struct ContentView: View {
    
    let authenticator = GoogleAuthenticator()

	var body: some View {
        
        
        let signInResult: KotlinPair<KotlinBoolean, NSString> = authenticator.isUserSignedIn()
        
        let isSignedIn = signInResult.first?.boolValue ?? false
        
        if(isSignedIn) {
            HomeScreen()
        } else {
            LandingScreen()
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
