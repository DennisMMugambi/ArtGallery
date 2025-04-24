//
//  FavoriteScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 10/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct FavoriteScreen: View {
    var body: some View {
        
        ScrollView(.vertical) {
            LazyVStack(alignment: .leading, spacing: 5) {
                ForEach(1...20, id: \.self) {_ in
                    ExhibitionItem(title: "The Tampless Exhibition", description: "In this exhibition we show the life work of some of the greatest realist artists", image: Constants.Images.africanPotrait)
                }
            }
            .padding(.horizontal, 12)
        }
    }
}

#Preview {
    FavoriteScreen()
}
