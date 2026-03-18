package woowacourse.kanban.board

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import woowacourse.kanban.create.model.TaskCreateState
import woowacourse.kanban.create.view.TaskCreateDialog

@Composable
fun App() {
    TaskCreateDialog(modifier = Modifier)
}
