//
//  GetStartedScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 03/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct GetStartedScreen: View {
    
    @State private var toLogin = false
    @State private var toSignup = false
    @State private var toHome = false
    
    @State private var showLoading: Bool = false
    
    let googleAuthenticator = GoogleAuthenticator()
    
    
    var body: some View {
        
        
        ZStack {
            
            GeometryReader { geometry in
                
                Image(Constants.Images.mountainBackground)
                    .resizable()
                    .scaledToFill()
                    .frame(width: geometry.size.width, height: geometry.size.height * 1.08)
                    .clipped()
                    .ignoresSafeArea()
                
                
                VStack(alignment: .leading) {
                    
                    Spacer()
                        .frame(height: geometry.size.height / 3)
                    
                    HStack {
                        VStack(alignment: .leading, spacing: 0) {
                            Text("Get started")
                                .foregroundColor(.white)
                                .font(.custom(Constants.Fonts.poppinsMedium, size: 23))
                                .bold()
                            
                            Text("Sign up with any method of your choice")
                                .foregroundColor(.white)
                                .font(.custom(Constants.Fonts.poppins, size: 16))
                        }
                        
                        Spacer()
                    }
                    .frame(width: geometry.size.width * 0.9)
                    .padding(.horizontal)
                    
                    OutlinedButton(image: Constants.Images.mail, buttonTitle: "Sign up with Email", action: {
                        toSignup = true
                    })
                    .padding(.horizontal, 20)
                    .padding(.top, 40)
                    .navigationDestination(isPresented: $toSignup) {
                        LoginScreen(isLogin: false)
                    }
                    
                    VStack {
                        
                        ZStack {
                            FilledButton(image: Constants.Images.google, buttonTitle: "Sign up with Google", action: {
                                
                                showLoading.toggle()
                                Task {
                                    do {
                                        guard let result = try await googleAuthenticator.login() else {
                                            return
                                        }
                                        
                                        toHome.toggle()
                                        showLoading.toggle()
                                    } catch  {
                                        print("error occured when attempting to sign in with google")
                                        showLoading.toggle()
                                    }
                                }
                            }, fillColor: Color.white, textColor: .black)
                            .navigationDestination(isPresented: $toHome) {
                                TabScreen()
                            }
                            .padding(.horizontal, 20)
                            .padding(.top, 10)
                            
                            if(showLoading) {
                                HStack{
                                    Spacer()
                                    
                                    ProgressView()
                                        .tint(Constants.Colors.appOrange)
                                }
                                .padding(.horizontal, 40)
                                .padding(.top, 10)
                            }
                        }
                    }
                    
                    FilledButton(image: Constants.Images.facebook, buttonTitle: "Sign up with Facebook", action: {
                        
                    }, fillColor: Color.blue, textColor: .white)
                    .padding(.horizontal, 20)
                    .padding(.top, 10)
                    
                    ExistingAccountComponent(action: {
                        toLogin = true
                    }, textColor: .white, title: "Already have an account?", alternateAction: "Login")
                    .navigationDestination(isPresented: $toLogin) {
                        LoginScreen(isLogin: true)
                    }
                    
                }
            }
        }
       .navigationBarBackButtonHidden(true)
    }
}

#Preview {
    GetStartedScreen()
}

