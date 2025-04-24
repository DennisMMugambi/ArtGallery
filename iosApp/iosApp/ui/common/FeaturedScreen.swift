//
//  FeaturedScreen.swift
//  iosApp
//
//  Created by Dennis Mugambi on 24/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct FeaturedScreen: View {
    
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        
        ScrollView {
            
            VStack{
                Image(Constants.Images.mountainBackground)
                    .resizable()
                    .scaledToFill()
                    .frame(maxHeight: 200)
                    .clipShape(RoundedRectangle(cornerRadius: 25.0))
                
                HStack {
                    Text("The Impressionist Exhibition")
                        .font(.custom(Constants.Fonts.poppinsMedium, size: 18))
                    
                    Spacer()
                    
                    Image(systemName: "arrowshape.turn.up.forward")
                    
                    Image(systemName: "heart")
                }
                .padding(.vertical, 20)
                
                Text("Location: Room 13 - 17 \n\nThe impressionist exhibitions explore artworks from contemporary impressionism of the 18th tto 21st century. You'll find the work of great impressionists like Claude Monet and Edouard Monet. Explore the lush, sensual style of Pierre Auguste Renoir, the intimate domestic scenes of Mary Cassatte and so much more here. The exhibition spans 5 room with 20 artworks in total")
                    .foregroundColor(.gray)
                
                
                NormalButton(action: {}, textColor: .black, buttonTitle: "Start tour", fillColor: Constants.Colors.appOrange)
                    .padding(.top, 50)
                
                
            }
            .padding(.horizontal, 20)
            .padding(.vertical, 20)
        }
        .navigationBarBackButtonHidden(true)
        .navigationTitle("Featured")
        .toolbar {
            ToolbarItem(placement: .navigationBarLeading) {
                Button(action: {
                    presentationMode.wrappedValue.dismiss()
                }) {
                    Image(systemName: "chevron.left")
                        .foregroundColor(.black)
                        .font(.system(size: 20, weight: .bold))
                }
            }
        }
        .defaultScrollAnchor(.top)
    }
}

#Preview {
    FeaturedScreen()
}
