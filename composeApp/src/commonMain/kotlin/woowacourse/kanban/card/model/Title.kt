package woowacourse.kanban.card.model

import woowacourse.kanban.card.constant.ERROR_TAG

@JvmInline
value class Title(val content: String) {
    init {
        require(content.isNotBlank()) { "$ERROR_TAG 제목의 내용이 존재해야 합니다." }
    }
}
