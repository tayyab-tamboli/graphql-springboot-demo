package com.graphqldemo.graphql_springboot_demo.controller;

import com.graphqldemo.graphql_springboot_demo.model.Player;
import com.graphqldemo.graphql_springboot_demo.model.Team;
import com.graphqldemo.graphql_springboot_demo.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PlayersController {

    @Autowired
    PlayersRepository playersRepository;

    @QueryMapping
    public List<Player> getPlayers() {
        return playersRepository.getPlayers();
    }

    @QueryMapping
    public Optional<Player> getPlayer(@Argument int id) {
        return playersRepository.getPlayer(id);
    }

    @MutationMapping
    public Player addPlayer(@Argument String name, @Argument Team team) {
        return playersRepository.addPlayer(name, team);
    }

    @MutationMapping
    public Player updatePlayer(@Argument int id, @Argument String name, @Argument Team team) {
        return playersRepository.updatePlayer(id, name, team);
    }
}
