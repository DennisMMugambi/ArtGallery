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
    @Binding var goHome: Bool
    
    @Binding var toggleLogin: Bool
    
    var body: some View {
        
        if (toggleLogin) {
            
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
                            toggleLogin.toggle()
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
                    goHome.toggle()
                }) {
                        Text("Login")
                            .foregroundColor(Color.white)
                            .padding(.horizontal, 20)
                            .padding(.vertical, 15)
                            .frame(maxWidth: .infinity)
                            .background(Constants.Colors.appOrange)
                            .cornerRadius(30)
                }.padding(.top, 20)
                
                
            }.padding(.all, 20)
                .clipShape(RoundedRectangle(cornerRadius: 30))
            
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
                            toggleLogin.toggle()
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
                    
                    Text("By clicking signup you agree to our terms and conditions and privacy policy")
                        .font(.custom(Constants.Fonts.poppins, size: 12))
                        .multilineTextAlignment(.center)
                    
                    Spacer()
                }
                
                Button(action: {
                    goHome.toggle()
                }) {
                        Text("Sign up")
                            .foregroundColor(Color.white)
                            .padding(.horizontal, 20)
                            .padding(.vertical, 15)
                            .frame(maxWidth: .infinity)
                            .background(Constants.Colors.appOrange)
                            .cornerRadius(30)
                }
                .padding(.top, 20)
            }
            .padding(.all, 20)
            .clipShape(RoundedRectangle(cornerRadius: 30))
        }
    }
}

#Preview {
    LoginComponent(goHome: .constant(false), toggleLogin: .constant(false))
}
