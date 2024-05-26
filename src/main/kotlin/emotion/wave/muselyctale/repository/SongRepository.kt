package emotion.wave.muselyctale.repository

import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository : JpaRepository<Song, Long> {
    fun findAllByEmotionId(emotionId: Long): List<Song>
}
