//
//  OutlinedButton.swift
//  iosApp
//
//  Created by Dennis Mugambi on 04/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct OutlinedButton: View {
    
    var image: String
    var buttonTitle: String
    var action: () -> Void
    
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
                    .foregroundColor(.white)
                    .font(.custom(Constants.Fonts.poppins, size: 16))
                
                Spacer()
            }.padding(.all, 10)
        })
        .overlay(RoundedRectangle(cornerRadius: 5).stroke(Color.white, lineWidth: 2.0))
    }
}

#Preview {
    OutlinedButton(image: Constants.Images.mail, buttonTitle: "Sign up with Email", action: {
        
    })
}
