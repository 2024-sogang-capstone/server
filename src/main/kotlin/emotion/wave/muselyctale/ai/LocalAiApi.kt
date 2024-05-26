package emotion.wave.muselyctale.ai

import emotion.wave.muselyctale.domain.EmotionType
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("local")
class LocalAiApi : AiApi {
    override fun analyzeEmotion(input: String): EmotionType {
        return EmotionType.entries.random()
    }
}
