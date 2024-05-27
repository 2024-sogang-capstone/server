package emotion.wave.muselyctale.ai.response

import emotion.wave.muselyctale.ai.Message

data class ChatGptResponse(
    val choices: List<Choice>,
) {
    fun getResponse(): String {
        return choices.firstOrNull {
            it.message.role == "assistant"
        }?.message?.content ?: ""
    }
}

data class Choice(
    val message: Message,
    val index: Int,
    val finish: Boolean,
)
