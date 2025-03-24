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
        
        ScrollView {
            
           VStack(alignment: .leading) {
                
                FeaturedItem()
                
                SectionDescription(text: "Exhibitions")
                
                ScrollView(.horizontal) {
                    LazyHStack(alignment: .top, spacing: 5) {
                        ForEach(1...10, id: \.self) {_ in
                            ExhibitionItem(title: "The Tampless Exhibition", description: "In this exhibition we show the life work of some of the greatest realist artists", image: Constants.Images.africanPotrait)
                        }
                    }
                    .padding(.horizontal, 12)
                }
                .frame(height: 170)
                
                SectionDescription(text: "Galleries")
                
                ScrollView(.horizontal) {
                    LazyHStack(alignment: .top, spacing: 5) {
                        ForEach(1...10, id: \.self) {_ in
                            Image(Constants.Images.africanPotrait)
                                .resizable()
                                .scaledToFill()
                                .frame(width: 100, height: 150)
                                .clipShape(RoundedRectangle(cornerRadius: 10))
                        }
                    }
                    .padding(.horizontal, 20)
                }
                
                Spacer()
            }
        }
        .defaultScrollAnchor(.bottom)
    }
}

#Preview {
    HomeScreen()
}

