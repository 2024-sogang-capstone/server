package emotion.wave.muselyctale.repository

import emotion.wave.muselyctale.domain.EmotionType
import org.springframework.data.jpa.repository.JpaRepository

interface EmotionRepository : JpaRepository<Emotion, String> {
    fun findByEmotion(emotion: EmotionType): Emotion?
}
