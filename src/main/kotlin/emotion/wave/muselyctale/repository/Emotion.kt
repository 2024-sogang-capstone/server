package emotion.wave.muselyctale.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "emotion")
class Emotion(
    @Column(name = "emotion")
    val emotion: String,
) : BaseEntity()
