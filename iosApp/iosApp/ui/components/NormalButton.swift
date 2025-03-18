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
                .padding(.horizontal, 20)
                .padding(.vertical, 10)
                .frame(maxWidth: .infinity)
                .background(fillColor)
                .cornerRadius(30)
        }
        .padding(.top, 20)
    }
}

#Preview {
    NormalButton(action: {}, textColor: .black, buttonTitle: "See more", fillColor: Constants.Colors.appOrange)
}
