package woowacourse.kanban.board.model

import woowacourse.kanban.create.model.TaskStatus

class BoardAction {
    fun calculateProgress(tasks: List<KanbanTask>): Double {
        return tasks.filter { it.status == TaskStatus.DONE }.size.toDouble() / tasks.size.toDouble()
    }
}
