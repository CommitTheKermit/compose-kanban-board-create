package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.create.view.TaskCreateDialog

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview(heightDp = 800, widthDp = 1300)
fun KanbanBoard(
    modifier: Modifier = Modifier
        .size(
            height = 800.dp, width = 1300.dp,
        )
        .background(Color(0xfff9fafb)),
) {

    var showDialog by remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        Column {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text("Compose Desktop 칸반 보드")
                    Text("진행률 ")
                }
                Button(
                    onClick = {
                        showDialog = true
                    },
                ) {
                    Text("새 태스크 생성")
                }
            }
        }
    }

    if (showDialog) {
        TaskCreateDialog(
            onDismissDialog = { showDialog = false },
            modifier = Modifier,
        )
    }
}
