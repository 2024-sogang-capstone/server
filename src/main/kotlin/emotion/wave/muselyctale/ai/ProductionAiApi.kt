package emotion.wave.muselyctale.ai

import emotion.wave.muselyctale.ai.request.ChatGptRequest
import emotion.wave.muselyctale.domain.EmotionType
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ProductionAiApi(
    private val aiClient: AiClient,
    private val chatGptClient: ChatGptClient,
    @Value("\${ai.secret-key}") private val aiSecretKey: String,
) : AiApi {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun analyzeEmotion(input: String): EmotionType {
        return runCatching {
            val response =
                chatGptClient.chat(
                    authorization = "Bearer $aiSecretKey",
                    request = ChatGptRequest(input),
                )
            EmotionType.valueOf(response.getResponse())
        }.onFailure {
            logger.error("Failed to analyze emotion by ChatGPT AI", it)
        }.getOrNull() ?: fallBackApi(input)
    }

    private fun fallBackApi(input: String): EmotionType {
        return runCatching {
            aiClient.analyzeEmotion(input)
        }.onFailure {
            logger.error("Failed to analyze emotion by KoBERT AI", it)
        }.getOrNull() ?: EmotionType.entries.random()
    }
}
