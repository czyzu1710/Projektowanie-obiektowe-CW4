package pl.edu.uj.mczyz.auth.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pl.edu.uj.mczyz.auth.models.User
import pl.edu.uj.mczyz.auth.services.AuthorizationService
import java.lang.RuntimeException

@RestController
@RequestMapping("/auth")
class UserController @Autowired constructor(val authorizationService: AuthorizationService) {
    @PostMapping("/register")
    fun register(@RequestBody user: User): User {
        return authorizationService.register(user)
    }

    @GetMapping("/login")
    fun login(@RequestParam("nickname") nickname: String, @RequestParam("password") password: String): User {
        return authorizationService.login(nickname, password) ?: throw RuntimeException("User not found")
    }

    @GetMapping("/logout")
    fun logout(@RequestParam("nickname") nickname: String): User {
        return authorizationService.logout(nickname) ?: throw RuntimeException("User not found")
    }
}
