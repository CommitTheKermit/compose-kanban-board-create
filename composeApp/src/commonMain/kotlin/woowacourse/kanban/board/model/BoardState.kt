package woowacourse.kanban.board.model

import androidx.compose.runtime.mutableStateListOf
import woowacourse.kanban.create.model.TaskStatus

class BoardState {
    val todoCardList: MutableList<KanbanTask> = mutableStateListOf()
    val inProgressCardList: MutableList<KanbanTask> = mutableStateListOf()
    val doneCardList: MutableList<KanbanTask> = mutableStateListOf()

    fun calculateProgress(tasks: List<KanbanTask>): Double {
        return tasks.filter { it.status == TaskStatus.DONE }.size.toDouble() / tasks.size.toDouble()
    }

    fun addCard(task: KanbanTask) {
        when (task.status) {
            TaskStatus.TO_DO -> todoCardList.add(task)
            TaskStatus.IN_PROGRESS -> inProgressCardList.add(task)
            TaskStatus.DONE -> doneCardList.add(task)
        }
    }
}
