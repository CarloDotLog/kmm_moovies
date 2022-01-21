//
//  MovieDetailPageView.swift
//  iosApp
//
//  Created by Mattia Picariello on 21/01/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import SDWebImageSwiftUI

struct MovieDetailPageView: View {
    
    @EnvironmentObject var pageModel: UIMovieDetailPageModel
    
    let ratio: CGFloat = 0.66
    let bannerRatio: CGFloat = 1.4
    var imageWidth: CGFloat {
        UIScreen.main.bounds.width
    }
    
    var body: some View {
        Group {
            ScrollView(showsIndicators: false) {
                VStack {
                    WebImage(url: pageModel.getImageURL(from: pageModel.movie?.posterPath))
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                        .frame(width: imageWidth, height: imageWidth/bannerRatio)
                        .clipped()
                    Text(pageModel.movie?.overview ?? "")
                        .font(Font.system(size: 16))
                        .foregroundColor(Color.white)
                        .padding(.horizontal, 25)
                    
                    ScrollView(.horizontal, showsIndicators: false) {
                        LazyHStack(spacing: 20) {
                            Spacer().frame(width: 5, height: 50/ratio)
                            ForEach(pageModel.casts, id: \.name) { cast in
                                if let path = cast.profilePath,
                                   path != "" {
                                    WebImage(url: pageModel.getImageURL(from: path))
                                        .resizable()
                                        .aspectRatio(contentMode: .fill)
                                        .frame(width: 50, height: 50/ratio)
                                        .clipped()
                                }
                            }
                            Spacer().frame(width: 5, height: 50/ratio)
                        }
                    }
                }
            }
            .background(Color("background"))
        }
        .navigationBarTitleDisplayMode(.inline)
        .navigationBarTitle(
            Text(pageModel.movie?.title ?? "")
        )
    }
    
    init() {
        updateNavigationBarColor()
    }
    
    func updateNavigationBarColor() {
        UINavigationBar.appearance().barTintColor = UIColor(named: "background")
        UINavigationBar.appearance().tintColor = UIColor.white
        UINavigationBar.appearance().titleTextAttributes = [
            NSAttributedString.Key.foregroundColor: UIColor.white
        ]
        UINavigationBar.appearance().backgroundColor = UIColor(named: "background")
        }
}

struct MovieDetailPageView_Previews: PreviewProvider {
    static var previews: some View {
        MovieDetailPageView()
    }
}
