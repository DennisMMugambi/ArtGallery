//
//  ProfileScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 10/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ProfileScreen: View {
    var body: some View {
        VStack {
            
            Image(Constants.Images.africanPotrait)
                .resizable()
                .scaledToFill()
                .frame(width: 120, height: 120)
                .clipShape(Circle())
            
            Text("Dennis Mugambi")
                .foregroundColor(.black)
                .font(.custom(Constants.Fonts.poppinsMedium, size: 18))
            
            Text("dennis.mutwiri.mugambi@gmail.com")
                .foregroundColor(.black)
                .font(.custom(Constants.Fonts.poppinsMedium, size: 16))
            
            Form {
                
                Section (header: Text("Content")) {
                    ProfileItem(actionTitle: "Leave a review", icon: "list.clipboard")
                    
                    ProfileItem(actionTitle: "About", icon: "questionmark.circle")
                    
                    ProfileItem(actionTitle: "Help & Support", icon: "phone.bubble")
                }
                
                
                Section(header: Text("Settings")) {
                    ProfileItem(actionTitle: "Settings", icon: "gear")
                    
                    ProfileItem(actionTitle: "Logout", icon: "door.left.hand.open")
                }
            }
            
        }
    }
}

#Preview {
    ProfileScreen()
}
