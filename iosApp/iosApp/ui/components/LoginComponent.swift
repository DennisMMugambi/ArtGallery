//
//  LoginComponent.swift
//  iosApp
//
//  Created by Dennis Mugambi on 04/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct LoginComponent: View {
    
    @State private var email: String = ""
    @State private var password: String = ""
    @State private var confirmPassword: String = ""
    
    var isLogin = false
    
    var body: some View {
        
        if (isLogin) {
            
            VStack(alignment: .leading) {
                
                VStack(alignment: .leading) {
                    
                    Text("Log in with Email")
                        .font(.custom(Constants.Fonts.poppinsMedium, size: 22))
                    
                    HStack(spacing: 0) {
                        
                        Text("Don't have an account?")
                            .foregroundColor(.black)
                            .font(.custom(Constants.Fonts.poppins, size: 14))
                            .padding(.all, 0)
                        Button(action: {
                            
                        }) {
                            Text("Sign up")
                                .padding(.leading, 3)
                                .font(.custom(Constants.Fonts.poppins, size: 14))
                                .foregroundColor(Constants.Colors.appOrange)
                                .underline()
                        }
                        
                        Spacer()
                        
                    }
                }
                
            
                OutlinedInputField(hint: "Email", input: $email)
                
                OutlinedInputField(hint: "Password", input: $password)
                
                HStack {
                    
                    Spacer()
                    
                    Text("Forgot password?")
                        .foregroundColor(Constants.Colors.appOrange)
                        .font(.custom(Constants.Fonts.poppins, size: 14))
                }
                
                
                Button(action: {
                    // Navigate to login
                }) {
                    NavigationLink(destination: GetStartedScreen()) {
                        Text("Login")
                            .foregroundColor(Color.white)
                            .padding(.all, 20)
                            .frame(maxWidth: .infinity)
                            .background(Constants.Colors.appOrange)
                            .cornerRadius(30)
                    }
                }.padding(.top, 20)
                
                
            }.padding(.all, 20)
            
        } else {
            
            VStack(alignment: .leading) {
                
                VStack(alignment: .leading) {
                    Text("Sign up with Email")
                        .font(.custom(Constants.Fonts.poppins, size: 22))
                    
                    HStack(spacing: 0) {
                        
                        Text("Already have an account?")
                            .font(.custom(Constants.Fonts.poppins, size: 14))
                            .foregroundColor(.black)
                            .padding(.all, 0)
                        Button(action: {
                            
                        }) {
                            Text("Login")
                                .padding(.leading, 3)
                                .foregroundColor(Constants.Colors.appOrange)
                                .underline()
                        }
                        
                        Spacer()
                        
                    }
                }
                
                OutlinedInputField(hint: "Email", input: $email)
                
                OutlinedInputField(hint: "Password", input: $password)
                
                OutlinedInputField(hint: "Confirm Password", input: $confirmPassword)
                
                HStack {
                    
                    Spacer()
                    
                    Text("By clicking signup youu agree to our terms and conditions and privacy policy")
                        .font(.custom(Constants.Fonts.poppins, size: 12))
                        .multilineTextAlignment(.center)
                    
                    Spacer()
                }
                
                Button(action: {
                    // Navigate to login
                }) {
                    NavigationLink(destination: GetStartedScreen()) {
                        Text("Sign up")
                            .foregroundColor(Color.white)
                            .padding(.all, 20)
                            .frame(maxWidth: .infinity)
                            .background(Constants.Colors.appOrange)
                            .cornerRadius(30)
                    }
                }
                .padding(.top, 20)
            }
            .padding(.all, 20)
        }
    }
}

#Preview {
    LoginComponent(isLogin: false)
}
