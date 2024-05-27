package emotion.wave.muselyctale.ai

import emotion.wave.muselyctale.ai.request.ChatGptRequest
import emotion.wave.muselyctale.ai.response.ChatGptResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "chatGpt", url = "https://api.openai.com/v1")
interface ChatGptClient {
    @PostMapping("/chat/completions")
    fun chat(
        @RequestHeader("Authorization") authorization: String,
        @RequestHeader("Accept") acceptType: String = "application/json",
        @RequestBody request: ChatGptRequest,
    ): ChatGptResponse
}
