package emotion.wave.muselyctale.service

import emotion.wave.muselyctale.ai.AiApi
import emotion.wave.muselyctale.domain.ChatResult
import emotion.wave.muselyctale.domain.SongInfo
import emotion.wave.muselyctale.repository.Emotion
import emotion.wave.muselyctale.repository.EmotionRepository
import emotion.wave.muselyctale.repository.Song
import emotion.wave.muselyctale.repository.SongRepository
import emotion.wave.muselyctale.repository.User
import emotion.wave.muselyctale.repository.UserInput
import emotion.wave.muselyctale.repository.UserInputEmotion
import emotion.wave.muselyctale.repository.UserInputEmotionRepository
import emotion.wave.muselyctale.repository.UserInputRepository
import emotion.wave.muselyctale.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChatService(
    private val aiApi: AiApi,
    private val userRepository: UserRepository,
    private val emotionRepository: EmotionRepository,
    private val songRepository: SongRepository,
    private val userInputRepository: UserInputRepository,
    private val userInputEmotionRepository: UserInputEmotionRepository,
) {
    @Transactional
    fun chat(
        userId: Long,
        input: String,
    ): ChatResult {
        val user =
            userRepository.findByIdOrNull(userId)
                ?: throw RuntimeException("User not found")
        val analyzedEmotion = aiApi.analyzeEmotion(input)
        val emotionEntity =
            emotionRepository.findByEmotion(analyzedEmotion)
                ?: throw RuntimeException("Emotion not found")
        saveUserInput(input, user, emotionEntity)
        val songs = findSongByEmotion(emotionEntity)

        return ChatResult(
            emotion = emotionEntity.emotion,
            songs =
                songs.map {
                    SongInfo(
                        title = it.title,
                        artist = it.artist,
                        url = it.url,
                    )
                },
        )
    }

    private fun saveUserInput(
        input: String,
        user: User,
        emotionEntity: Emotion,
    ) {
        userInputRepository.save(UserInput(userId = user.id, content = input)).also {
            userInputEmotionRepository.save(
                UserInputEmotion(
                    userInputId = it.id,
                    emotionId = emotionEntity.id,
                ),
            )
        }
    }

    private fun findSongByEmotion(emotion: Emotion): List<Song> {
        return songRepository.findAllByEmotionId(emotion.id).shuffled().take(3)
    }
}
