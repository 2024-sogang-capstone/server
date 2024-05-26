package emotion.wave.muselyctale.controller.response

import emotion.wave.muselyctale.domain.SongInfo

data class SongResponse(
    val title: String,
    val singer: String,
    val link: String,
) {
    constructor(songInfo: SongInfo) : this(
        songInfo.title,
        songInfo.artist,
        songInfo.url,
    )
}
