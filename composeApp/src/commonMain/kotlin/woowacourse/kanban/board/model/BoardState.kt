package woowacourse.kanban.board.model

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import woowacourse.kanban.create.model.TaskStatus

class BoardState {
    val todoCardList: MutableList<KanbanTask> = mutableStateListOf()
    val inProgressCardList: MutableList<KanbanTask> = mutableStateListOf()
    val doneCardList: MutableList<KanbanTask> = mutableStateListOf()

    val totalTaskCount by derivedStateOf { todoCardList.size + inProgressCardList.size + doneCardList.size }
    val progress by derivedStateOf {
        if (totalTaskCount == 0) 0.0 else doneCardList.size.toDouble() / totalTaskCount.toDouble()
    }

    fun addCard(task: KanbanTask) {
        when (task.status) {
            TaskStatus.TO_DO -> todoCardList.add(task)
            TaskStatus.IN_PROGRESS -> inProgressCardList.add(task)
            TaskStatus.DONE -> doneCardList.add(task)
        }
    }
}
