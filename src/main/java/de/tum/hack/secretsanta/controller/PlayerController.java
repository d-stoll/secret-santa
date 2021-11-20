package de.tum.hack.secretsanta.controller;

import de.tum.hack.secretsanta.dao.PlayerRepository;
import de.tum.hack.secretsanta.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PlayerController {

    private final PlayerRepository userRepository;

    public PlayerController(PlayerRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/players")
    Iterable<Player> all() {
        return userRepository.findAll();
    }

    @GetMapping("/players/{id}")
    Player one(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/players")
    Player create(@RequestBody Player newUser) {
        return userRepository.save(newUser);
    }

    @DeleteMapping("/players/{id}")
    void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
