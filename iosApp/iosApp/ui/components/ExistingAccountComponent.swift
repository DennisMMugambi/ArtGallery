//
//  ExistingAccountComponent.swift
//  iosApp
//
//  Created by Dennis Mugambi on 04/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ExistingAccountComponent: View {
    
    var action: () -> Void
    var textColor: Color
    
    var body: some View {
       
        HStack(spacing: 0) {
            
            Spacer()
            
            Text("Already have an account?")
                .foregroundColor(textColor)
                .padding(.all, 0)
            Button(action: {
                action()
            }) {
                Text("Login")
                    .padding(.leading, 3)
                    .foregroundColor(Constants.Colors.appOrange)
                    .underline()
            }
            
            Spacer()

        }
        .padding(.top, 5)
        
    }
}

#Preview {
    ExistingAccountComponent(action: {
        
    }, textColor: .black)
}
