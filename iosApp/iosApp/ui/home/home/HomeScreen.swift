//
//  HomeScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 10/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct HomeScreen: View {
    
    @State private var searchText = ""
    @State private var searchIsActive = true
    
    var body: some View {
        

            NavigationStack {
                VStack(alignment: .leading) {
                    
                    Text("testing searchbar")
                        .foregroundColor(.black)
                        .font(.custom(Constants.Fonts.poppinsMedium, size: 22))
                        .bold()
                        .padding(.leading, 20)
                    
                    VStack() {
                        
                    }
                }
                .searchable(text: $searchText, isPresented: $searchIsActive)
            }
    }
}

#Preview {
    HomeScreen()
}
