//
//  OutlinedInputField.swift
//  iosApp
//
//  Created by Dennis Mugambi on 07/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI


import SwiftUI

struct OutlinedInputField: View {
    
    var hint: LocalizedStringKey = ""
    @Binding var input: String
    
    var body: some View {
       
        TextField(hint, text: $input)
            .padding(15)
            .overlay(
                RoundedRectangle(cornerRadius: 10)
                    .stroke(.gray, lineWidth: 1)
            )
            .padding(.top, 20)
    }
}

#Preview {
    OutlinedInputField(hint: "Email", input: .constant(""))
}
