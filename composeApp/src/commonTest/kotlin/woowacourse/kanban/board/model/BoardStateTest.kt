package woowacourse.kanban.board.model

import kotlin.test.assertEquals
import org.junit.Test
import woowacourse.kanban.card.model.BoardData
import woowacourse.kanban.card.model.Nickname
import woowacourse.kanban.card.model.Tags
import woowacourse.kanban.card.model.Title
import woowacourse.kanban.create.model.TaskStatus

class BoardStateTest {
    @Test
    fun `전체 태스크 중 Done 상태의 비율로 완료율을 계산해야 한다`() {
        // given : Done 상태 태스크 2개, To Do 상태 태스크 1개, In Progress 상태 태스크 1개
        val tasks = listOf(
            KanbanTask(
                data = BoardData(
                    title = Title("제목"),
                    content = "내용",
                    tags = Tags(),
                    nickname = Nickname("아오"),
                ),
                status = TaskStatus.DONE,
            ),
            KanbanTask(
                data = BoardData(
                    title = Title("제목"),
                    content = "내용",
                    tags = Tags(),
                    nickname = Nickname("아오"),
                ),
                status = TaskStatus.DONE,
            ),
            KanbanTask(
                data = BoardData(
                    title = Title("제목"),
                    content = "내용",
                    tags = Tags(),
                    nickname = Nickname("아오"),
                ),
                status = TaskStatus.TO_DO,
            ),
            KanbanTask(
                data = BoardData(
                    title = Title("제목"),
                    content = "내용",
                    tags = Tags(),
                    nickname = Nickname("아오"),
                ),
                status = TaskStatus.IN_PROGRESS,
            ),
        )

        // when : 완료율을 계산하면
        val result: Double = BoardAction().calculateProgress(tasks)

        // then : 완료율은 50%이어야 한다.
        assertEquals(
            0.5,
            result,
        )
    }
}
