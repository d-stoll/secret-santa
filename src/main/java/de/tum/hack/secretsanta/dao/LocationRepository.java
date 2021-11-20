package de.tum.hack.secretsanta.dao;

import de.tum.hack.secretsanta.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {}
