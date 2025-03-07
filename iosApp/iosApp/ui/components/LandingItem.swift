//
//  LandingItem.swift
//  iosApp
//
//  Created by Dennis Mugambi on 26/02/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct LandingItem: View {
    let image: String 
    let title: String
    let description: String
    
    var body: some View {
        VStack() {
            Image(image)
                .resizable()
                .scaledToFit()
                .frame(width: 350, height: 350)
                .accessibilityLabel("Landing image")
            
            Text(title)
                .font(.custom(Constants.Fonts.poppinsMedium, size: 22))
                .foregroundColor(.black)
                .padding(.top, 50)
            
            Text(description)
                .font(.custom(Constants.Fonts.poppins, size: 16))
                .foregroundColor(.gray)
                .multilineTextAlignment(.center)
                .padding(.horizontal, 20)
        }
        .padding(.top, 30)
    }
}

#Preview {
    LandingItem(
        image: Constants.Images.landing1,
        title: "Welcome to the Art Gallery",
        description: "Explore a vast collection of artwork from various artists around the world."
    )
}
