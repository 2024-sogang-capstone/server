package emotion.wave.muselyctale.ai

import emotion.wave.muselyctale.domain.EmotionType

interface AiApi {
    fun analyzeEmotion(input: String): EmotionType
}
