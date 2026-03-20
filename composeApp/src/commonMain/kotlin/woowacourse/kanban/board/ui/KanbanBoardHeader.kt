package woowacourse.kanban.board.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KanbanBoardHeader(
    doneTaskCount: Int,
    totalTaskCount: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val progress: Int = ((doneTaskCount.toDouble() / totalTaskCount.toDouble()) * 100).toInt()
    Column(modifier = modifier.padding(horizontal = 24.dp, vertical = 16.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column {
                Text(
                    "Compose Desktop 칸반 보드",
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(4.5.dp))
                Text(
                    "완료율 $progress% ($doneTaskCount/$totalTaskCount)",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    color = Color(0xff6a7282),
                )
            }
            Button(
                onClick = {
                    onClick()
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    containerColor = Color(0xff4f39f6),
                    contentColor = ButtonDefaults.buttonColors().contentColor,
                    disabledContainerColor = ButtonDefaults.buttonColors().disabledContainerColor,
                    disabledContentColor = ButtonDefaults.buttonColors().disabledContentColor,
                ),
            ) {
                Row {
                    Icon(Icons.Default.Add, contentDescription = "태스크 생성 버튼")
                    Text(
                        "새 태스크 생성",
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(16.dp))
        LinearProgressIndicator(
            progress = { progress.toFloat() },
            modifier = Modifier.fillMaxWidth().height(8.dp),
            color = Color(0xff4f39f6),
            trackColor = Color(0xffe5e7eb),
        )
    }
}

@Preview(backgroundColor = 0xfff9fafb)
@Composable
fun KanbanBoardHeaderPreview() {
    KanbanBoardHeader(

        doneTaskCount = 3,
        totalTaskCount = 7,
        onClick = { },
    )
}
