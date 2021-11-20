package de.tum.hack.secretsanta.dao;

import de.tum.hack.secretsanta.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {}
