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
    @State private var searchText = ""
    @State private var isSearchActive = false
    
    var body: some View {
           
        if (tab_selection == 0) {
            VStack {
                TabView(selection: $tab_selection) {
                    
                    HomeScreen()
                        .tabItem {
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
            .navigationBarBackButtonHidden(true)
            .toolbar {
                ToolbarItem(placement: .topBarLeading) {
                        Text("Welcome to Art Gallery")
                        .font(.custom(Constants.Fonts.poppinsMedium, size: 22))
                        .bold()
                    }
            }
           .searchable(text: $searchText, isPresented: $isSearchActive, prompt: "Search exhibitions, artworks")
        } else {
            TabView(selection: $tab_selection) {
                
                HomeScreen()
                    .tabItem {
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
            .navigationBarBackButtonHidden(true)
        }
    }
}

#Preview {
    TabScreen()
}
