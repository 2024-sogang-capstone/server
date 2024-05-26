package emotion.wave.muselyctale.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Column(name = "email")
    val email: String,
    @Column(name = "username")
    val username: String,
) : BaseEntity()
