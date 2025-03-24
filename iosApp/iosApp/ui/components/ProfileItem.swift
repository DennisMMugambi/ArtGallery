//
//  ProfileItem.swift
//  iosApp
//
//  Created by Dennis Mugambi on 24/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ProfileItem: View {
    
    var actionTitle : String
    var icon : String
    
    var body: some View {
        
        HStack {
            
            Image(systemName: icon)
                .resizable()
                .scaledToFit()
                .foregroundColor(.gray)
                .frame(width: 20, height: 20)
            
            Spacer()
            
            Text(actionTitle)
                .font(.custom(Constants.Fonts.poppinsMedium, size: 18))
            
            Spacer()
            
            Image(Constants.Images.next)
                .resizable()
                .scaledToFit()
                .frame(width: 20, height: 15)
        }
        .frame(height: 40)
        .clipShape(RoundedRectangle(cornerRadius: 25))
        //.padding(.vertical, 10)
    }
}

#Preview {
    ProfileItem(actionTitle: "Leave a review", icon: "list.clipboard")
}
