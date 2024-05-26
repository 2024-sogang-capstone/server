package emotion.wave.muselyctale.ai

import emotion.wave.muselyctale.domain.EmotionType
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "ai", url = "\${ai.url}")
interface AiClient {
    @PostMapping("/analyze")
    fun analyzeEmotion(input: String): EmotionType
}
