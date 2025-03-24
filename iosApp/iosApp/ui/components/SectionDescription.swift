//
//  SectionDescription.swift
//  iosApp
//
//  Created by Dennis Mugambi on 20/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct SectionDescription: View {
    
    var text: String
    
    var body: some View {
        Text(text)
            .font(.custom(Constants.Fonts.poppinsMedium, size: 16))
            .padding(.horizontal, 25)
    }
}

#Preview {
    SectionDescription(text: "Exhibitions")
}
