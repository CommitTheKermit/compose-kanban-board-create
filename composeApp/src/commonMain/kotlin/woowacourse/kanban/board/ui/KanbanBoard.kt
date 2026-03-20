package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.BoardState
import woowacourse.kanban.create.model.TaskStatus
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
    var state = remember { BoardState() }

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.totalTaskCount) {
        if (state.totalTaskCount > 0) {
            snackbarHostState.showSnackbar(
                message = "생성",
            )
        }
    }

    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState, modifier = Modifier.offset(y = (-50).dp)) { data ->
                KanbanSnackBar(data)
            }
        },
        modifier = modifier,
    ) {
        Column(modifier = Modifier.padding(it)) {
            KanbanBoardHeader(
                progress = state.progress,
                doneTaskCount = state.doneCardList.size,
                totalTaskCount = state.totalTaskCount,
                onClick = { showDialog = true },
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth(0.75f),
            ) {
                StatusCardList(
                    tasks = state.todoCardList,
                    status = TaskStatus.TO_DO,
                    modifier = Modifier.weight(1f),
                )
                StatusCardList(
                    tasks = state.inProgressCardList,
                    status = TaskStatus.IN_PROGRESS,
                    modifier = Modifier.weight(1f),
                )
                StatusCardList(
                    tasks = state.doneCardList,
                    status = TaskStatus.DONE,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }

    if (showDialog) {
        TaskCreateDialog(
            onDismissDialog = { task ->
                showDialog = false

                if (task != null) {
                    state.addCard(task)
                }
            },
            modifier = Modifier,
        )
    }
}
