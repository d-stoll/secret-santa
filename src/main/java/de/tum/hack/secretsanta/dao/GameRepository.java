package de.tum.hack.secretsanta.dao;

import de.tum.hack.secretsanta.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {}
