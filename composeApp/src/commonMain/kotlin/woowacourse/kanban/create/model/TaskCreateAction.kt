package woowacourse.kanban.create.model

class TaskCreateAction(val state: TaskCreateState) {
    fun onTitleChange(input: String) {
        state.titleInputValue = input
        if (state.isTitleError) state.isTitleError = false
    }

    fun onContentChange(input: String) {
        state.contentInputValue = input
    }

    fun onTagChange(input: String) {
        state.tagInputValue = input
        if (state.isTagError) state.isTagError = false
    }

    fun onStatusSelect(index: Int) {
        state.selectedStatusIndex = index
    }

    fun onCoachSelect(index: Int) {
        state.selectedCoachIndex = index
    }

    fun onCardCreate() {
        state.isTitleError = state.titleInputValue.isEmpty()
        val tags = state.tagInputValue.split(",")
        state.isTagError = tags.size > 5 || tags.any { it.length > 5 }

        if (state.isTitleError) state.titleInputValue = ""
        if (state.isTagError) state.tagInputValue = ""
    }
}
