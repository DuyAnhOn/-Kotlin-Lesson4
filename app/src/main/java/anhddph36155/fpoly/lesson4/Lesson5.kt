package anhddph36155.fpoly.lesson4

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch

@Composable
fun Lesson5(){
    Column (
        Modifier.padding(10.dp)
    ){
        CardExample()
        ChipExample()
        SwitchExample()
        SnackbarExample()
        DialogExample ()
    }
}

@Composable
fun CardExample(){
    Card {
        Text(
            text = "Hello "
        )
    }

    val padding = Modifier.padding(10.dp)
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = CutCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.Yellow),
        modifier = padding
    ){
        Text(
            text = "Elevation",
            modifier = padding
        )
        Text(
            text = "Second Elevation",
            modifier = padding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipExample(){
    SuggestionChip(
        onClick = { Log.d("Suggestion Chip", "Hello") },
        label = { Text(text = "Suggestion Chip") }
    )

    AssistChip(
        onClick = { /*TODO*/ },
        label = { Text(text = "Assist Chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = null,
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )

    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "Filter Chip") },
        leadingIcon = {
            if (selected){
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = null,
                    Modifier.size(FilterChipDefaults.IconSize)
                )
            } else{
                null
            }
        }
    )

    InputChipExample("Input Chip") {}
}

@OptIn(ExperimentalMaterial3Api:: class)
@Composable
fun InputChipExample(text: String, onDismiss: ()-> Unit){
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return
        InputChip(
            selected = enabled,
            onClick = {
                onDismiss
                enabled = !enabled },
            label = { Text(text) },
            avatar = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = null,
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = null,
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
        )
}

@Composable
fun SwitchExample(){
    var checked by remember { mutableStateOf(true) }
    Switch(
        checked = checked,
        onCheckedChange = {checked = it},
        thumbContent = {
            if (checked){
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    Modifier.size(SwitchDefaults.IconSize)
                )
            } else{
                null
            }
        }
    )
}

@Composable
fun SnackbarExample(){
//    val scope = rememberCoroutineScope()
//    val snackbarHostState = remember { SnackbarHostState() }
//
//    Scaffold (
//        snackbarHost = { SnackbarHost(hostState = snackbarHostState)},
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text(text = "Show Snackbar") },
//                icon = { Icons.Filled.Info },
//                onClick = {
//                    scope.launch {
//                        snackbarHostState.showSnackbar("This is Snackbar")
//                    }
//                }
//            )
//        }
//    ){
//
//    }
}

//@Composable
//fun DialogExampl(onDismissRequest: ()-> Unit){
//    var dialog by remember { mutableStateOf(false) }
//    Dialog(onDismissRequest = { onDismissRequest() }) {
//        Card(
//            Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .padding(20.dp),
//            shape = RoundedCornerShape(16.dp)
//        ){
//            Text(
//                text = "This is a minimal dialog",
//                modifier = Modifier
//                    .fillMaxSize()
//                    .wrapContentSize(Alignment.Center),
//                textAlign = TextAlign.Center,
//            )
//        }
//    }
//    Button(
//        onClick = {
//            dialog = true
//        }
//    ) {
//        Text(text = "Turn on Dialog")
//    }
//
//}

@Composable
fun DialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text(text = "Hiển thị Hộp thoại")
        }

        if (showDialog) {
            SimpleDialog(onDismissRequest = { showDialog = false })
        }
    }
}

@Composable
fun SimpleDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Đây là một hộp thoại đơn giản",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(onClick = onDismissRequest) {
                    Text(text = "Đóng")
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewLesson5(){
    Lesson5()
}
