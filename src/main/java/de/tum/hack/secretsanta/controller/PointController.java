package de.tum.hack.secretsanta.controller;

import de.tum.hack.secretsanta.dao.PointRepository;
import de.tum.hack.secretsanta.model.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointController {
    private final PointRepository pointRepository;

    public PointController(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @GetMapping("/points")
    Iterable<Point> all() {
        return pointRepository.findAll();
    }
}
