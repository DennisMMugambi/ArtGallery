//
//  GetStartedScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 03/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct GetStartedScreen: View {
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
                            
                        })
                        .padding(.horizontal, 20)
                        .padding(.top, 40)
                        
                        FilledButton(image: Constants.Images.google, buttonTitle: "Sign up with Google", action: {
                            
                        }, fillColor: Color.white, textColor: .black)
                        .padding(.horizontal, 20)
                        .padding(.top, 10)
                        
                        FilledButton(image: Constants.Images.facebook, buttonTitle: "Sign up with Facebook", action: {
                            
                        }, fillColor: Color.blue, textColor: .white)
                        .padding(.horizontal, 20)
                        .padding(.top, 10)
                        
                        ExistingAccountComponent(action: {
                            
                        }, textColor: .white, title: "Already have an account?", alternateAction: "Login")

                    Spacer()
                }
            }
        }
            .navigationBarBackButtonHidden(true)
    }
}

#Preview {
    GetStartedScreen()
}

