//
//  UIHomePageModel.swift
//  iosApp
//
//  Created by Mattia Picariello on 21/01/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared


class UIHomePageModel: ObservableObject {
    
    @Published var movies: [Movie] = []
    
    @Published var error: Error? = nil
    @Published var occureError: Bool = false
    
    let ratio: Double = 0.66
    private let numberOfColumn: Int = 2
    var movieRow: [GridItem] {
        Array(repeating: .init(.flexible()), count: numberOfColumn)
    }
    
    init() {
        TrendingMovies().getTrendingMovies() { data, error in
            if let movies = data {
                self.movies = movies
            }
            if let errorReal = error {
                self.movies = []
                self.occureError = true
                self.error = errorReal
            }
        }
    }
    
    let imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    func getImageURL(from path: String?) -> URL? {
        guard let path = path else { return nil }
        print("\(imageBaseUrl)\(path)")
        return URL(string: "\(imageBaseUrl)\(path)")
    }
    
}
