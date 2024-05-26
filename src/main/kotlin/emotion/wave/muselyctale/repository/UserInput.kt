package emotion.wave.muselyctale.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user_input")
class UserInput(
    @Column(name = "content")
    val content: String,
    @Column(name = "ref_user_id")
    val userId: Long,
) : BaseEntity()
