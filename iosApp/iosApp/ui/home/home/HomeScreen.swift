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
        VStack(alignment: .leading) {
            FeaturedItem()
            
            Text("Exhibitions")
                .font(.custom(Constants.Fonts.poppinsMedium, size: 16))
                .padding(.horizontal, 25)
                .padding(.vertical, 5)
            
            ScrollView(.horizontal) {
                LazyHStack(alignment: .top, spacing: 10) {
                    ForEach(1...10, id: \.self) {_ in 
                        ExhibitionItem(title: "The Tampless Exhibition", description: "In this exhibition we show the life work of some of the greatest realist artists", image: Constants.Images.africanPotrait)
                    }
                }
                .padding(.horizontal, 15)
            }

            
            Spacer()
        }
    }
}

#Preview {
    HomeScreen()
}

