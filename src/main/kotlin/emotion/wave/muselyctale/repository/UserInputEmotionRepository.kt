package emotion.wave.muselyctale.repository

import org.springframework.data.jpa.repository.JpaRepository

interface UserInputEmotionRepository : JpaRepository<UserInputEmotion, Long>
