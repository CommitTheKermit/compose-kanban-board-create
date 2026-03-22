package woowacourse.kanban.model.extension

import androidx.compose.ui.graphics.Color
import woowacourse.kanban.Colors
import woowacourse.kanban.model.TaskStatus

val TaskStatus.displayName: String
    get() = when (this) {
        TaskStatus.TO_DO -> "To Do"
        TaskStatus.IN_PROGRESS -> "In Progress"
        TaskStatus.DONE -> "Done"
    }

val TaskStatus.titleColor: Color
    get() = when (this) {
        TaskStatus.TO_DO -> Colors.StatusBgToDo
        TaskStatus.IN_PROGRESS -> Colors.StatusBgInProgress
        TaskStatus.DONE -> Colors.StatusBgDone
    }

val TaskStatus.bgColor: Color
    get() = when (this) {
        TaskStatus.TO_DO -> Colors.StatusListBgToDo
        TaskStatus.IN_PROGRESS -> Colors.StatusListBgInProgress
        TaskStatus.DONE -> Colors.StatusListBgDone
    }

val TaskStatus.borderColor: Color
    get() = when (this) {
        TaskStatus.TO_DO -> Colors.StatusListBorderToDo
        TaskStatus.IN_PROGRESS -> Colors.StatusListBorderInProgress
        TaskStatus.DONE -> Colors.StatusListBorderDone
    }
