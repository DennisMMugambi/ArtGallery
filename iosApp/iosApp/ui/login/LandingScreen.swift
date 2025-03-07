//
//  LandingScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 26/02/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct LandingScreen: View {
    @State private var currentPage = 0
    let pages = [
        (Constants.Images.landing1, "Discover Art", "Explore a vast collection of artwork from around the world."),
        (Constants.Images.landing2, "Connect with Artists", "Engage with artists and learn about their inspirations."),
        (Constants.Images.landing3, "Create Your Collection", "Save and curate your favorite pieces in your own collection.")
    ]
    
    var body: some View {
        
        NavigationStack {
            
            
            VStack() {
                TabView(selection: $currentPage) {
                    ForEach(0..<pages.count, id: \ .self) { index in
                        LandingItem(
                            image: pages[index].0,
                            title: pages[index].1,
                            description: pages[index].2
                        )
                        .tag(index)
                    }
                }
                .tabViewStyle(PageTabViewStyle(indexDisplayMode: .always))
                
                
                //Spacer()
                
                HStack(spacing: 8) {
                    ForEach(0..<pages.count, id: \.self) { index in
                        RoundedRectangle(cornerRadius: 10)
                            .fill(index == currentPage ? Constants.Colors.appOrange : Color.gray)
                            .frame(width: index == currentPage ? 40 : 15, height: 8)
                    }
                }
                .padding(.bottom, 50)
                
               // Spacer()
                
                HStack {
                    if currentPage < pages.count - 1 {
                        Button(action: {
                            currentPage = pages.count - 1
                        }) {
                            Text("Skip")
                                .foregroundColor(.black)
                                .padding(.horizontal, 20)
                                .padding(.vertical, 10)
                                .font(.custom(Constants.Fonts.poppins, size: 14))
                                .overlay(
                                    RoundedRectangle(cornerRadius: 20)
                                        .stroke(Constants.Colors.appOrange, lineWidth: 1)
                                )
                        }
                        Spacer()
                        Button(action: {
                            withAnimation {
                                currentPage += 1
                            }
                        }) {
                            Text("Next")
                                .foregroundColor(Color.white)
                                .padding(.horizontal, 20)
                                .padding(.vertical, 10)
                                .font(.custom(Constants.Fonts.poppins, size: 14))
                                .background(Constants.Colors.appOrange)
                                .cornerRadius(20)
                        }
                    } else {
                        VStack {
                            Button(action: {
                                // Navigate to login
                            }) {
                                NavigationLink(destination: GetStartedScreen()) {
                                    Text("Get Started")
                                        .foregroundColor(Color.white)
                                        .padding(.horizontal, 20)
                                        .padding(.vertical, 10)
                                        .frame(maxWidth: .infinity)
                                        .background(Constants.Colors.appOrange)
                                        .cornerRadius(30)
                                }
                            }
                            
                            ExistingAccountComponent(action: {
                                
                            }, textColor: .black, title: "Already have an account?", alternateAction: "Login")
                        }
                    }
                }
                .padding(.horizontal, 20)
                .padding(.bottom, 30)
            }
            .background(Color.white)
        }
    }
}

#Preview {
    LandingScreen()
}
