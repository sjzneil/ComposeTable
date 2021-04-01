package cn.ning.composetable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cn.ning.composetable.ui.theme.ComposeTableTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTableTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    table(
                        row = 200,
                        col = 300,
                        columnHeader = {
                            corner {
                                Text(
                                    text = "corner",
                                    style = TextStyle(color = Color.Black),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .width(50.dp)
                                        .height(30.dp)
                                        .background(Color.Green),
                                )
                            }
                            colHeaders(300) { col ->
                                Text(
                                    text = "colHeader_${col}",
                                    style = TextStyle(color = Color.Black),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .width(80.dp)
                                        .height(30.dp)
                                        .background(Color.Cyan),
                                )
                            }

                        },
                        rowHeader = {
                            Text(
                                text = "row${it}",
                                style = TextStyle(color = Color.Black),
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(30.dp)
                                    .background(Color.Green),
                            )
                        },
                        itemContent = { row, col ->
                            Text(
                                text = "item_${row}_${col}",
                                style = TextStyle(color = Color.Black),
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .width(80.dp)
                                    .height(30.dp)
                                    .background(Color.Cyan),
                            )
                        })
                }

            }
        }
    }
}
