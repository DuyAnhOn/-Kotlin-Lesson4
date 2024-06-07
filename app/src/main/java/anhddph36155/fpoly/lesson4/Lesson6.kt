package anhddph36155.fpoly.lesson4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.android.volley.toolbox.ImageRequest

@Composable
fun Lesson6(){
    AsyncImage1()
}

@Composable
fun LazyColumn1(){
    LazyColumn {
        items (3){ index ->
            Text(text = "Header $index")
        }
    }
}

@Composable
fun LazyColumn2(){
    val countryList = mutableListOf("America", "VietNam", "Singapore")
    var listModifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .padding(10.dp)
    var textStyle = TextStyle(fontSize = 20.sp, color = Color.White)

    LazyColumn (modifier = listModifier){
        items(countryList){country ->
            Text(text = country, style = textStyle)
        }
    }
}

@Composable
fun LazyColumn3(){
    val fruitList = mutableListOf<FruitModel>()

    fruitList.add(FruitModel("Durian", R.drawable.durian))
    fruitList.add(FruitModel("Grape", R.drawable.grape))

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(fruitList) { model ->
            ListRow(model = model)
        }
    }
}

@Composable
fun LazyRow1(){
    val fruitList = mutableListOf<FruitModel>()

    fruitList.add(FruitModel("Durian", R.drawable.durian))
    fruitList.add(FruitModel("Grape", R.drawable.grape))
    LazyRow {
        items(fruitList) { item ->
            Column(
                Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = item.image),
                    contentDescription = null
                )
                Text(text = item.name)
            }
        }
    }
}

data class FruitModel(var name: String, var image: Int)
@Composable
fun ListRow(model: FruitModel){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = Color.Gray)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

@Composable
fun VerticalGrid1() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(30) { index ->
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Text("Item $index")
            }
        }
    }
}

@Composable
fun VerticalStaggeredGrid1() {
//    var listImage = R.drawable.durian
//    LazyVerticalStaggeredGrid(
//        columns = StaggeredGridCells.Fixed(3),
//        verticalItemSpacing = 4.dp,
//        horizontalArrangement = Arrangement.spacedBy(4.dp),
//        content = {
//            items(listImage) { photo ->
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSi1cuWfIvJ3Pu8vwc_zYIaoKGkpBNfwly-Ug&s")
//                        .crossfade(true)
//                        .build(),
//                    placeholder = painterResource(R.drawable.durian),
//                    contentDescription = "",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.clip(CircleShape)
//                )
//            }
//        },
//        modifier = Modifier.fillMaxSize()
//    )
}

@Composable
fun AsyncImage1(){
//    AsyncImage(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data("https://example.com/image.jpg")
//            .crossfade(true)
//            .build(),
//        placeholder = painterResource(R.drawable.grape),
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier.clip(CircleShape)
//    )
    Image(
        painter = rememberAsyncImagePainter("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT08dGzIL_uYXCfh4QGXQNKkaKhwlOQVDCAzQ&s"),
        contentDescription = null
    )
}


@Composable
@Preview(showBackground = true)
fun PreviewLesson6(){
    Lesson6()
}