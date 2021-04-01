package cn.ning.composetable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

/**
 * 通过多个横向row联动, 实现table的纵横滚动
 */
@ExperimentalFoundationApi
@Composable
fun table(
    row: Int = 0,
    col: Int = 0,
    columnHeader: @Composable (() -> Any)? = null,
    rowHeader: @Composable ((Int) -> Any)? = null,
    itemContent: @Composable ((Int, Int) -> Any)? = null,
) {
    val scroll = remember {
        mutableStateOf(0)
    }
    val item = remember {
        mutableStateOf(0)
    }
    val scrollState = rememberLazyListState(0, 0)
    scroll.value = scrollState.firstVisibleItemScrollOffset
    item.value = scrollState.firstVisibleItemIndex
    val coroutineScope = rememberCoroutineScope()
    LazyColumn {
        stickyHeader {
            columnHeader?.invoke()
        }
        items(row) { row ->
            LazyRow(state = scrollState) {
                stickyHeader() {
                    rowHeader?.invoke(row)
                }
                items(col) { col ->
                    itemContent?.invoke(row, col)
                }

                coroutineScope.launch {
                    scrollState.scrollToItem(item.value, scroll.value)
                }
            }
        }
    }

}