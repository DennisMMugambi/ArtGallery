//
//  FeaturedItem.swift
//  iosApp
//
//  Created by Dennis Mugambi on 18/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct FeaturedItem: View {
    var body: some View {
            ZStack(alignment: .bottomLeading) {
                
                Image(Constants.Images.mountainBackground)
                    .resizable()
                    .scaledToFill()
                    .frame(maxHeight: 150)
                
                Text("Featured: The Impressionist \nExhibition")
                    .font(.custom(Constants.Fonts.poppinsMedium, size: 18))
                    .padding()
            }
            //.frame(height: 200)
            .clipShape(RoundedRectangle(cornerRadius: 25.0))
            .padding(.horizontal, 20)
            .padding(.vertical, 10)
    }
}

#Preview {
    FeaturedItem()
}
