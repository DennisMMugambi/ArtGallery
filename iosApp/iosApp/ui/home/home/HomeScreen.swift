//
//  HomeScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 10/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct HomeScreen: View {
    
    var body: some View {
        VStack {
            Text("Testing Search Bar")
                .foregroundColor(.black)
                .font(.custom(Constants.Fonts.poppinsMedium, size: 22))
                .bold()
                .padding(.leading, 20)
            
            // Your content here
            VStack {
                
            }
        }
    }
}

#Preview {
    NavigationStack { // Simulates proper navigation in preview
        HomeScreen()
    }
}

