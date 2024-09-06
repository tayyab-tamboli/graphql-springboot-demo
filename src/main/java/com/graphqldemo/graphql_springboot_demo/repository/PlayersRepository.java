package com.graphqldemo.graphql_springboot_demo.repository;

import com.graphqldemo.graphql_springboot_demo.model.Player;
import com.graphqldemo.graphql_springboot_demo.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlayersRepository {

    List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayers() {
        return playerList;
    }

    public Optional<Player> getPlayer(int id) {
        return playerList.stream().filter(player -> player.getId() == id).findFirst();
    }

    public Player addPlayer(String name, Team team) {
        var newPlayer = new Player(playerList.size(), name, team);
        playerList.add(newPlayer);
        return newPlayer;
    }

    public Player updatePlayer(int id, String name, Team team) {
        for (Player player : playerList) {
            if (player.getId() == id) {
                player.setName(name);
                player.setTeam(team);
                return player;
            }
        }
        throw new RuntimeException("NOT FOUND");
    }

    @PostConstruct
    void postConstruct() {
        playerList.add(new Player(45, "ROHIT", Team.MI));
        playerList.add(new Player(10, "SACHIN", Team.MI));
        playerList.add(new Player(7, "Dhoni", Team.CSK));
        playerList.add(new Player(17, "Pant", Team.DD));
    }
}
