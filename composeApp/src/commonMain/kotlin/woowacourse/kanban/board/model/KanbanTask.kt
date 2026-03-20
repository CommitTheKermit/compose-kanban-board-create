package woowacourse.kanban.board.model

import woowacourse.kanban.card.model.BoardData
import woowacourse.kanban.create.model.TaskStatus

data class KanbanTask(val data: BoardData, val status: TaskStatus)
