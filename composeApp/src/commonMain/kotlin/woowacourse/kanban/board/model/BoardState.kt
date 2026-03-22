package woowacourse.kanban.board.model

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import woowacourse.kanban.model.KanbanTask
import woowacourse.kanban.model.TaskStatus

class BoardState(val scope: CoroutineScope) {
    private val _todoCardList: MutableList<KanbanTask> = mutableStateListOf()
    val todoCardList: List<KanbanTask> = _todoCardList

    private val _inProgressCardList: MutableList<KanbanTask> = mutableStateListOf()
    val inProgressCardList: List<KanbanTask> = _inProgressCardList

    private val _doneCardList: MutableList<KanbanTask> = mutableStateListOf()
    val doneCardList: List<KanbanTask> = _doneCardList

    val totalTaskCount by derivedStateOf { todoCardList.size + inProgressCardList.size + doneCardList.size }
    val progress by derivedStateOf {
        if (totalTaskCount == 0) 0.0 else doneCardList.size.toDouble() / totalTaskCount.toDouble()
    }

    var showDialog = mutableStateOf(false)
    val snackbarHostState = SnackbarHostState()

    fun addCard(task: KanbanTask) {
        when (task.status) {
            TaskStatus.TO_DO -> _todoCardList.add(task)
            TaskStatus.IN_PROGRESS -> _inProgressCardList.add(task)
            TaskStatus.DONE -> _doneCardList.add(task)
        }

        scope.launch { snackbarHostState.showSnackbar("새로운 태스크가 추가되었습니다.") }
    }
}
