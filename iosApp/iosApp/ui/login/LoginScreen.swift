//
//  LoginScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 04/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct LoginScreen: View {
    
    var isLogin = true

    @State private var toHome = false
    @State var login = false
    @Environment(\.presentationMode) var presentationMode
    
    init(isLogin: Bool = true) {
        self.isLogin = isLogin
    }
    
    var body: some View {
        
        GeometryReader { geometry in
            
            ZStack(alignment: .bottom) {
                
                
                Image(Constants.Images.africanPotrait)
                    .resizable()
                    .scaledToFill()
                    .frame(width: geometry.size.width, height: geometry.size.height)
                
                LoginComponent(goHome: $toHome, toggleLogin: $login)
                    .background(Color.white)
                    .clipShape(RoundedRectangle(cornerRadius: 30))
                    .navigationDestination(isPresented: $toHome) {
                        TabScreen()
                    }
                
            }
            .frame(height: geometry.size.height)
            .ignoresSafeArea()
        }
        .navigationBarBackButtonHidden(true)
        .toolbar {
            ToolbarItem(placement: .navigationBarLeading) {
                Button(action: {
                    presentationMode.wrappedValue.dismiss()
                }) {
                    Image(systemName: "chevron.left")
                        .foregroundColor(.white)
                        .font(.system(size: 20, weight: .bold))
                }
            }
        }
        .ignoresSafeArea()
    }
}

#Preview {
    LoginScreen()
}
