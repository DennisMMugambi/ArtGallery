//
//  CurvedButton.swift
//  iosApp
//
//  Created by Dennis Mugambi on 04/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct FilledButton: View {
    
    var image: String
    var buttonTitle: String
    var action: () -> Void
    var fillColor: Color
    var textColor: Color
    
    var body: some View {
        
        Button(action: {
            action()
        }, label: {
            
            HStack {
                
                Image(image)
                    .resizable()
                    .scaledToFit()
                    .frame(width: 20, height: 20)
                
                Spacer()
                
                Text(buttonTitle)
                    .foregroundColor(textColor)
                    .font(.custom(Constants.Fonts.poppins, size: 16))
                
                Spacer()
            }.padding(.all, 10)
        })
        .background(fillColor)
        .overlay(RoundedRectangle(cornerRadius: 5).stroke(fillColor, lineWidth: 2.0))
    }
}

#Preview {
    FilledButton(image: Constants.Images.google, buttonTitle: "Sign up with Google", action: {
        
    }, fillColor: Color.white, textColor: .black)
}
