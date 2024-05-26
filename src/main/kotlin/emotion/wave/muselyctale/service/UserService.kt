package emotion.wave.muselyctale.service

import emotion.wave.muselyctale.repository.User
import emotion.wave.muselyctale.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService(
    private val userRepository: UserRepository,
) {
    fun findByEmail(email: String) = userRepository.findByEmail(email)

    @Transactional
    fun crete(email: String) = userRepository.save(User(email = email, username = email.split("@")[0]))
}
