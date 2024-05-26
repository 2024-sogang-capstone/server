package emotion.wave.muselyctale.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user_input_emotion")
class UserInputEmotion(
    @Column(name = "ref_user_input_id")
    val userInputId: Long,
    @Column(name = "ref_emotion_id")
    val emotionId: Long,
) : BaseEntity()
