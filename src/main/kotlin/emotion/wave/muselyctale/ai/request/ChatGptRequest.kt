package emotion.wave.muselyctale.ai.request

import emotion.wave.muselyctale.ai.Message
import emotion.wave.muselyctale.domain.EmotionType

data class ChatGptRequest(
    val model: String = "gpt-4o",
    val messages: List<Message>,
) {
    constructor(input: String) : this(
        messages =
            listOf(
                Message("system", "You are a helpful assistant."),
                Message(
                    "user",
                    """
                    You are a emotion detection system.
                    Please analyze the emotion of the following text.
                    Text will be korean or english.
                    If text is korean, you have to translate to english and then analyze.
                    Emotion should be one of the following: ${EmotionType.entries.joinToString(", ") { it.name }}
                    Following is the text to analyze:
                    $input

                    Your answer should be in the format of "<emotion>". For example, if the emotion is "HAPPY", your answer should be "HAPPY" ( without quotes ).
                    """.trimIndent(),
                ),
            ),
    )
}
