//
//  UIMovieDetailPageModel.swift
//  iosApp
//
//  Created by Mattia Picariello on 21/01/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared


class UIMovieDetailPageModel: ObservableObject {
    
    var movie: Movie?
    @Published var casts: [Cast] = []
    
    @Published var error: Error? = nil
    @Published var occureError: Bool = false
    
    init(movie: Movie?) {
        guard let movie = movie else { return }
        self.movie = movie
        MovieCast().getMovieCast(movieID: Int32(movie.id)) { data, error in
            if let casts = data {
                self.casts = casts
            }
            if let errorReal = error {
                self.casts = []
                self.occureError = true
                self.error = errorReal
            }
        }
        
    }
    
    let imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
    func getImageURL(from path: String?) -> URL? {
        guard let path = path else { return nil }
        return URL(string: "\(imageBaseUrl)\(path)")
    }
    
}
