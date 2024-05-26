package emotion.wave.muselyctale.controller

import emotion.wave.muselyctale.common.auth.LoginUser
import emotion.wave.muselyctale.common.response.ApiResponse
import emotion.wave.muselyctale.controller.request.ChatRequest
import emotion.wave.muselyctale.controller.response.ChatResponse
import emotion.wave.muselyctale.service.ChatService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController(
    private val chatService: ChatService,
) {
    @PostMapping("/api/v1/chat")
    fun chat(
        @LoginUser userId: Long,
        @RequestBody request: ChatRequest,
    ): ApiResponse<ChatResponse> {
        val chatResult = chatService.chat(userId, request.input)
        return ApiResponse.success(ChatResponse(chatResult))
    }
}
