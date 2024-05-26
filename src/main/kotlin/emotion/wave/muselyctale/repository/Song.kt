package emotion.wave.muselyctale.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "song")
class Song(
    @Column(name = "title")
    val title: String,
    @Column(name = "url")
    val url: String,
    @Column(name = "artist")
    val artist: String,
    @Column(name = "ref_emotion_id")
    val emotionId: Long,
) : BaseEntity()
