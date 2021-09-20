package pl.edu.uj.mczyz.auth.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.lang.Nullable
import pl.edu.uj.mczyz.auth.models.User

interface UserRepository : CrudRepository<User, Int> {
    @Nullable
    fun findByNicknameAndPassword(nickname: String, password: String): User

    @Nullable
    fun findByNickname(nickname: String): User
}