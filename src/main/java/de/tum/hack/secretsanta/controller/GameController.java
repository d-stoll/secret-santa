package de.tum.hack.secretsanta.controller;

import de.tum.hack.secretsanta.dao.GameRepository;
import de.tum.hack.secretsanta.dao.PlayerRepository;
import de.tum.hack.secretsanta.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class GameController {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    public GameController(GameRepository gameRepository,
                          PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/games/{id}")
    Game one(@PathVariable Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/games")
    Game create(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @GetMapping("/open-game")
    Game findOpenGame(@RequestParam String time,
                      @RequestParam Integer budget,
                      @RequestParam Long playerId) {
        for(Game g : gameRepository.findAll()) {
            if (g.getParticipants().size() < 4 &&
                    g.getBudget().equals(budget) &&
                    g.getTime() == LocalDateTime.parse(time)) {
                return g;
            }
        }
        var player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        var newGame = new Game(List.of(player), LocalDateTime.parse(time), budget);
        return gameRepository.save(newGame);
    }
}
