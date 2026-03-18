package woowacourse.kanban.create.model

enum class TaskStatus(val statusDescription: String) {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done")
}