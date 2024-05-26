package emotion.wave.muselyctale.controller.response

import emotion.wave.muselyctale.domain.ChatResult

data class ChatResponse(
    val emotion: String,
    val songs: List<SongResponse>,
) {
    constructor(chatResult: ChatResult) : this(
        chatResult.emotion.description,
        chatResult.songs.map { SongResponse(it) },
    )
}
