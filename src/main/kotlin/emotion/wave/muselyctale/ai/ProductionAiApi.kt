package emotion.wave.muselyctale.ai

import emotion.wave.muselyctale.domain.EmotionType
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("!local")
class ProductionAiApi(
    private val aiClient: AiClient,
) : AiApi {
    override fun analyzeEmotion(input: String): EmotionType {
        return aiClient.analyzeEmotion(input)
    }
}
