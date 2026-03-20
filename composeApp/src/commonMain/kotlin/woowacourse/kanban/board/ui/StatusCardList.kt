package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.model.KanbanTask
import woowacourse.kanban.card.component.KanbanCard
import woowacourse.kanban.create.model.TaskStatus

val TaskStatus.displayName: String
    get() = when (this) {
        TaskStatus.TO_DO -> "To Do"
        TaskStatus.IN_PROGRESS -> "In Progress"
        TaskStatus.DONE -> "Done"
    }
val TaskStatus.titleColor: Color
    get() = when (this) {
        TaskStatus.TO_DO -> Color(0xFF155DFC)
        TaskStatus.IN_PROGRESS -> Color(0xFFE17100)
        TaskStatus.DONE -> Color(0xFF00A63E)
    }

val TaskStatus.bgColor: Color
    get() = when (this) {
        TaskStatus.TO_DO -> Color(0xffeff6ff)
        TaskStatus.IN_PROGRESS -> Color(0xfffffbeb)
        TaskStatus.DONE -> Color(0xFFf0fdf4)
    }

@Composable
fun StatusCardList(
    tasks: List<KanbanTask>,
    status: TaskStatus,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.clip(RoundedCornerShape(10.dp)).background(status.bgColor)) {
        Box(
            modifier = Modifier
                .background(status.titleColor)
                .fillMaxWidth(),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
            ) {
                Text(
                    status.displayName,
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(width = 29.dp, height = 24.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White),
                ) {
                    Text(
                        "1",
                        color = Color.Black,
                    )
                }
            }
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(),
        ) {
            items(tasks.size) {
                KanbanCard(tasks[it].data)
            }
        }
    }
}

@Composable
@Preview
fun StatusCardListPreview() {
    StatusCardList(
        tasks = emptyList(),
        status = TaskStatus.TO_DO,
    )
}
