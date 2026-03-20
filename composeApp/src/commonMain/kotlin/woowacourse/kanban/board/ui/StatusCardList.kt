package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import woowacourse.kanban.card.component.KanbanCard
import woowacourse.kanban.model.KanbanTask
import woowacourse.kanban.model.TaskStatus
import woowacourse.kanban.model.extension.bgColor
import woowacourse.kanban.model.extension.borderColor
import woowacourse.kanban.model.extension.displayName
import woowacourse.kanban.model.extension.titleColor

@Composable
fun StatusCardList(
    tasks: List<KanbanTask>,
    status: TaskStatus,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(status.bgColor)
            .border(
                color = status.borderColor,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
            ),
    ) {
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
                        tasks.size.toString(),
                        color = Color.Black,
                    )
                }
            }
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(vertical = 12.dp)
                .fillMaxHeight()
                .fillMaxWidth(),

        ) {
            items(tasks.size) {
                KanbanCard(tasks[it].data)
            }
        }
    }
}

@Composable
@Preview
private fun StatusCardListPreview() {
    StatusCardList(
        tasks = emptyList(),
        status = TaskStatus.TO_DO,
    )
}
