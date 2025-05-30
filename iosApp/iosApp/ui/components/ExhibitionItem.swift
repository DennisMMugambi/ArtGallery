//
//  ExhibitionItem.swift
//  iosApp
//
//  Created by Dennis Mugambi on 18/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ExhibitionItem: View {
    
    var title : String
    var description : String
    var image : String
    
    @State private var toDestination = false
    
    var body: some View {
        
        HStack {
            
            Image(Constants.Images.africanPotrait)
                .resizable()
                .scaledToFill()
                .frame(width: 100, height: 150)
                .clipShape(RoundedRectangle(cornerRadius: 30))
                .padding(.horizontal, 10)
            
            VStack(alignment: .leading) {
                Text(title)
                    .font(.custom(Constants.Fonts.poppinsMedium, size: 15))
                    .multilineTextAlignment(.leading)
                    .bold()
                
                Text(description)
                    .font(.custom(Constants.Fonts.poppins, size: 13))
                
                
                NormalButton(action: {
                    toDestination = true
                }, textColor: .black, buttonTitle: "See more", fillColor: Constants.Colors.appOrange)
                .padding(.trailing, 10)
                .navigationDestination(isPresented: $toDestination) {
                    FeaturedScreen()
                }
            }
        }
        .frame(width: 300, height: 150)
    }
}

#Preview {
    ExhibitionItem(title: "The Tampless Exhibition", description: "In this exhibition we show the life work of some of the greatest realist artists", image: Constants.Images.africanPotrait)
}
