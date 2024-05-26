package emotion.wave.muselyctale.domain

data class ChatResult(
    val emotion: EmotionType,
    val songs: List<SongInfo>,
)
