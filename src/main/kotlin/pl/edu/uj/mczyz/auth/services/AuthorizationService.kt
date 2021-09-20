package pl.edu.uj.mczyz.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.uj.mczyz.auth.models.User
import pl.edu.uj.mczyz.auth.repositories.UserRepository

@Service
class AuthorizationService @Autowired constructor(val userRepository: UserRepository) {


    fun register (user: User):User {
        return userRepository.save(user)
    }

    fun login (nickname:String, password:String):User ? {
        return userRepository.findByNicknameAndPassword(nickname, password)
    }

    fun logout (nickname:String):User ? {
        return userRepository.findByNickname(nickname)
    }

}
