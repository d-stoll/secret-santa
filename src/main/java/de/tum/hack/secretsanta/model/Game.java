package de.tum.hack.secretsanta.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Player> participants;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime time;

    private Integer budget;

    protected Game() {}

    public Game(List<Player> participants, LocalDateTime time, Integer budget) {
        this.participants = participants;
        this.time = time;
        this.budget = budget;
    }

    public List<Player> getParticipants() {
        return participants;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Integer getBudget() {
        return budget;
    }
}
