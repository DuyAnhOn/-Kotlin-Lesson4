package anhddph36155.fpoly.lesson4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import anhddph36155.fpoly.lesson4.ui.theme.Lesson4Theme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

class Lesson4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lesson4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main(){
    Column {
        CustomText()
        Spacer(modifier = Modifier.height(10.dp))
        FirstButton()
        Spacer(modifier = Modifier.height(10.dp))
        FirstImage()
        Spacer(modifier = Modifier.height(10.dp))
        SimpleColumn()
        Spacer(modifier = Modifier.height(10.dp))
        SimpleRow()
    }
}

@Composable
fun CustomText(){
    SelectionContainer {    //Allow copy
        Text(
            text = "@Preview(showBackground = true): Annotation này cho phép bạn xem trước composable trong Android Studio. showBackground = true thêm một nền mặc định để dễ dàng xem trước hơn.\n" +
                    "GreetingPreview: Một hàm Composable đơn giản gọi Greeting. Hàm này được sử dụng để xem trước Greeting trong môi trường phát triển của bạn.\n" +
                    "Khi bạn thêm hàm Preview này và xây dựng dự án, bạn sẽ thấy một tab Preview trong Android Studio hiển thị kết quả của Greeting. Điều này rất hữu ích để xem nhanh giao diện của Composable mà không cần chạy toàn bộ ứng dụng.",
            modifier = Modifier,
            fontSize = 20.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun FirstButton(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),    //Change background color
//        shape = RectangleShape,  //Change shape
//        shape = RoundedCornerShape(30.dp),   //Change coner shape
        shape = CutCornerShape(30.dp)   //Cut corner shape

    ) {
        Image(painterResource(id = R.drawable.three_rotation) , contentDescription = "3D", modifier = Modifier.size(40.dp))
        Text(text = "Touch ", color = Color.Blue)    //Change text color
        Text(text = "Me", color = Color.Cyan)
    }
}

@Composable
fun FirstImage(){
    Row {
        Image(painterResource(id = R.drawable.durian), contentDescription = "Durian")
        Image(
            painterResource(id = R.drawable.grape),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Yellow),
            modifier = Modifier.
            clip(CircleShape).   //Become a circle
            border(5.dp, Color.Red, CircleShape)    //Boder circle

        )
        Image(
            painterResource(id = R.drawable.litchi),
            contentDescription = null,
            modifier = Modifier.
            clip(RoundedCornerShape(20)).
            border(5.dp, Color.White, RoundedCornerShape(25))
        )
    }

}

@Composable
fun SimpleRow(){
    Row (
        modifier = Modifier
            .padding(5.dp)
    ) {
        Text(text = "Row 1", modifier = Modifier.background(Color.White))
        Text(text = "Row 2", modifier = Modifier.background(Color.Blue))
        Text(text = "Row 3", modifier = Modifier.background(Color.Red))
    }
}

@Composable
fun SimpleColumn(){
    Column (
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Column 1", modifier = Modifier.background(Color.White))
        Text(text = "Column 2", modifier = Modifier.background(Color.Blue))
        Text(text = "Column 3", modifier = Modifier.background(Color.Red))
    }
}


