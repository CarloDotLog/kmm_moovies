//
//  MoviePoster.swift
//  iosApp
//
//  Created by Mattia Picariello on 21/01/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import SDWebImageSwiftUI
import MapKit

struct MoviePoster: View {
    @State var title: String?
    @State var imageURL: URL?
    
    let ratio: CGFloat = 0.66
    var imageWidth: CGFloat {
        ((UIScreen.main.bounds.width - 30)/2 - 10)
    }
    
    var body: some View {
        VStack(spacing: 5) {
            WebImage(url: imageURL)
                .resizable()
                .aspectRatio(contentMode: .fill)
                .frame(width: imageWidth, height: imageWidth/ratio)
                .clipped()
            
            VStack(spacing: 0) {
                Text(title ?? "")
                    .font(Font.system(size: 16))
                    .foregroundColor(Color.white)
                    .lineLimit(2)
                    .multilineTextAlignment(.leading)
                Spacer()
            }
            .frame(width: imageWidth, height: 50)
        }
    }
}

struct MoviePoster_Previews: PreviewProvider {
    static var previews: some View {
        MoviePoster()
    }
}
