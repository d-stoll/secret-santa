package de.tum.hack.secretsanta.dao;

import de.tum.hack.secretsanta.model.Point;
import org.springframework.data.repository.CrudRepository;

public interface PointRepository extends CrudRepository<Point, Long> {}
