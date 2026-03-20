package woowacourse.kanban.model.extension

import androidx.compose.ui.graphics.Color
import woowacourse.kanban.STATUS_BG_DONE
import woowacourse.kanban.STATUS_BG_IN_PROGRESS
import woowacourse.kanban.STATUS_BG_TO_DO
import woowacourse.kanban.STATUS_LIST_BG_DONE
import woowacourse.kanban.STATUS_LIST_BG_IN_PROGRESS
import woowacourse.kanban.STATUS_LIST_BG_TO_DO
import woowacourse.kanban.STATUS_LIST_BORDER_DONE
import woowacourse.kanban.STATUS_LIST_BORDER_IN_PROGRESS
import woowacourse.kanban.STATUS_LIST_BORDER_TO_DO
import woowacourse.kanban.model.TaskStatus

val TaskStatus.displayName: String
    get() = when (this) {
        TaskStatus.TO_DO -> "To Do"
        TaskStatus.IN_PROGRESS -> "In Progress"
        TaskStatus.DONE -> "Done"
    }

val TaskStatus.titleColor: Color
    get() = when (this) {
        TaskStatus.TO_DO -> Color(STATUS_BG_TO_DO)
        TaskStatus.IN_PROGRESS -> Color(STATUS_BG_IN_PROGRESS)
        TaskStatus.DONE -> Color(STATUS_BG_DONE)
    }

val TaskStatus.bgColor: Color
    get() = when (this) {
        TaskStatus.TO_DO -> Color(STATUS_LIST_BG_TO_DO)
        TaskStatus.IN_PROGRESS -> Color(STATUS_LIST_BG_IN_PROGRESS)
        TaskStatus.DONE -> Color(STATUS_LIST_BG_DONE)
    }

val TaskStatus.borderColor: Color
    get() = when (this) {
        TaskStatus.TO_DO -> Color(STATUS_LIST_BORDER_TO_DO)
        TaskStatus.IN_PROGRESS -> Color(STATUS_LIST_BORDER_IN_PROGRESS)
        TaskStatus.DONE -> Color(STATUS_LIST_BORDER_DONE)
    }
