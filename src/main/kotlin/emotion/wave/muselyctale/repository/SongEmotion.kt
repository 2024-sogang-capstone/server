package emotion.wave.muselyctale.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "song_emotion")
class SongEmotion(
    @Column(name = "ref_song_id")
    val songId: Long,
    @Column(name = "ref_emotion_id")
    val emotionId: Long,
) : BaseEntity()
