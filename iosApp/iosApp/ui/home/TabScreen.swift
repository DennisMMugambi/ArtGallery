//
//  TabScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 10/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct TabScreen: View {
    
    @State private var tab_selection = 0
    
    var body: some View {
        
        VStack {
            
            TabView(selection: $tab_selection) {
                
                HomeScreen().tabItem {
                    Image(systemName: "house")
                }.tag(0)
                
                FavoriteScreen().tabItem {
                    Image(systemName: "star.circle")
                }.tag(1)
                
                ShopScreen().tabItem {
                    Image(systemName: "tray")
                }.tag(2)
                
                ProfileScreen().tabItem {
                    Image(systemName: "person.circle")
                }.tag(3)
            }
        }
        //.navigationBarBackButtonHidden(true)
    }
}

#Preview {
    TabScreen()
}
