import SwiftUI
import shared
import SDWebImageSwiftUI

struct HomePageView: View {

    @EnvironmentObject var pageModel: UIHomePageModel
    
    @State var haveError: Bool = false
    
    var body: some View {
        ScrollView {
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
                        }
                    }
                    .padding(.horizontal, 15)
                }
            }
        }
        .background(Color("background"))
        
	}
}

struct HomePageView_Previews: PreviewProvider {
	static var previews: some View {
        HomePageView()
	}
}
