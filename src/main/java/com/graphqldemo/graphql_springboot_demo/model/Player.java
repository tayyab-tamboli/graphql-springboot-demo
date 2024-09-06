package com.graphqldemo.graphql_springboot_demo.model;

public class Player {
    private int id;

    public Player(int id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    private String name;
    private Team team;

}


