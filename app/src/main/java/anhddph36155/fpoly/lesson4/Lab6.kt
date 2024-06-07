package anhddph36155.fpoly.lesson4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

data class Movie(
    val title: String,
    val year: String,
    val posterUrl: String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie(
                title = "The Shawshank Redemption",
                year = "1994",
                posterUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC_SveBkotEgKlZnx8QK56Zw3zjjAYFb4YzQ&s"
            ),
            Movie(
                title = "The Godfather",
                year = "1972",
                posterUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkEBaIlonPa1AmVY7BJdzCpYlAOjNbP4hxyg&s"
            ),
            Movie(
                title = "The Dark Knight",
                year = "2008",
                posterUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSctpXpGN6vkZGGlD1hZxtqpmTR8hBkzp8pQg&s"
            ),
            Movie(
                title = "Iron man 3",
                year = "2013",
                posterUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlZHII4vjh_XnRVD2LA6CroYaRIaovmMOrGA&s"
            )
        )
    }
}

@Composable
fun Lab6(){
    MovieScreen(Movie.getSampleMovies())
}

@Composable
fun MovieScreen(movies: List<Movie>) {
//    LazyColumn {
//        item{
//            MovieRow(movies = movies)
//        }
//        item{
//            MovieColumn(movies = movies)
//        }
//        item{
//            MovieGrid(movies = movies)
//        }
//    }
    MovieColumn(movies = movies)

}

@Composable
fun MovieItemRow(movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    ) {
        Column(
            Modifier
                .width(175.dp)
                .height(330.dp)
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(255.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topEnd = 8.dp, topStart =
                            8.dp
                        )
                    ),
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = movie.title, style =
                MaterialTheme.typography.titleSmall, maxLines = 2)
                Text(text = "Thời lượng: ${movie.year}", style =
                MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun MovieItemColumn(movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(350.dp)
            .height(160.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(160.dp)
                    .width(110.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 8.dp,
                            bottomStart = 8.dp
                        )
                    ),
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Thời lượng: ${movie.year}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun MovieItemGrid(movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .padding(8.dp)
            .width(175.dp)
            .height(330.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(255.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp
                        )
                    ),
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis // Ensure text doesn't overflow
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Thời lượng: ${movie.year}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun MovieRow(movies: List<Movie>){
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItemRow(movie = movies[index])
        }
    }
}

@Composable
fun MovieColumn(movies: List<Movie>){
    LazyColumn (
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
    ){
        items(movies.size){index ->
            MovieItemColumn(movie = movies[index])
        }
    }
}

@Composable
fun MovieGrid(movies: List<Movie>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(movies.size) { index ->
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                MovieItemGrid(movie = movies[index])
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLab6(){
    Lab6()
}