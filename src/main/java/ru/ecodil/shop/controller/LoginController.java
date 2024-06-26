package ru.ecodil.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/login/")
public class LoginController {

    // Метод для авторизации и аутентификации
    @PostMapping()
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Здесь можно добавить логику для проверки пользовательских данных и генерации токена авторизации
        // В данном примере просто возвращаем успешное сообщение
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }
}
