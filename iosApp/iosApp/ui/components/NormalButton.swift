//
//  NormalButton.swift
//  iosApp
//
//  Created by Dennis Mugambi on 18/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct NormalButton: View {
    
    var action : () -> Void
    var textColor : Color
    var buttonTitle : String
    var fillColor: Color
    
    var body: some View {
        
        Button(action: {
            action()
        }) {
            Text(buttonTitle)
                .foregroundColor(textColor)
                .font(.custom(Constants.Fonts.poppinsMedium, size: 12))
                .padding(.horizontal, 5)
                .padding(.vertical, 8)
                .frame(maxWidth: .infinity)
                .background(fillColor)
                .cornerRadius(30)
        }
    }
}

#Preview {
    NormalButton(action: {}, textColor: .black, buttonTitle: "See more", fillColor: Constants.Colors.appOrange)
}
