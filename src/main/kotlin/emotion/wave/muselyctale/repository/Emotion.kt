package emotion.wave.muselyctale.repository

import emotion.wave.muselyctale.domain.EmotionType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "emotion")
class Emotion(
    @Column(name = "emotion")
    @Enumerated(EnumType.STRING)
    val emotion: EmotionType,
) : BaseEntity()
