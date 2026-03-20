package woowacourse.kanban.board.model

import woowacourse.kanban.create.model.TaskStatus

class BoardState {
    val todoCardList: MutableList<KanbanTask> = mutableListOf()
    val inProgressCardList: MutableList<KanbanTask> = mutableListOf()
    val doneCardList: MutableList<KanbanTask> = mutableListOf()

    fun addCard(task: KanbanTask) {
        when (task.status) {
            TaskStatus.TO_DO -> todoCardList.add(task)
            TaskStatus.IN_PROGRESS -> inProgressCardList.add(task)
            TaskStatus.DONE -> doneCardList.add(task)
        }
    }
}
