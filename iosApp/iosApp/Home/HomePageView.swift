import SwiftUI
import shared
import SDWebImageSwiftUI

struct HomePageView: View {

    @EnvironmentObject var pageModel: UIHomePageModel
    
    @State var haveError: Bool = false
    
    @State var push: Bool = false
    
    var body: some View {
        NavigationView {
            Group {
                ScrollView(showsIndicators: false) {
                    VStack(spacing: 0) {
                        
                        if (haveError) {
                            Text(pageModel.error?.localizedDescription ?? "ERROR")
                                .font(Font.system(size: 22, weight: .bold))
                                .foregroundColor(Color.white)
                        } else {
                            LazyVGrid(columns: pageModel.movieRow, spacing: 10) {
                                ForEach(pageModel.movies, id: \.id) { movie in
                                    MoviePoster(
                                        title: movie.title,
                                        imageURL: pageModel.getImageURL(from: movie.posterPath)
                                    )
                                        .onTapGesture {
                                            pageModel.openMovie(movie: movie)
                                        }
                                }
                            }
                            .padding(.horizontal, 15)
                        }
                        
                        NavigationLink(isActive: $push) {
                            MovieDetailPageView()
                                .environmentObject(UIMovieDetailPageModel(movie: pageModel.movieSelected))
                        } label: {
                            EmptyView()
                        }
                        
                    }
                }
                .background(Color("background"))
            }
            .onReceive(pageModel.$push, perform: { push in
                self.push = push
            })
            .navigationBarHidden(true)
            .navigationBarTitleDisplayMode(.inline)
        }
	}
}

struct HomePageView_Previews: PreviewProvider {
	static var previews: some View {
        HomePageView()
	}
}
