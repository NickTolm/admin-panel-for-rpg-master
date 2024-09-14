package com.example.demo.controllers;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.PlayerEntity;
import com.example.demo.services.PlayerService;
import com.example.demo.utils.Mapper;
import com.example.demo.utils.PlayerRequest;
import com.example.demo.utils.PlayerResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.List;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/rest/players/count")
    public int getPlayersCount() {
        return playerService.getPlayersCount();
    }

    @GetMapping("/rest/players")
    public List<PlayerEntity> getPlayersList() {
        return playerService.getPlayersList();
    }

    @GetMapping("/rest/players/{id}")
    public PlayerResponse getPlayer(@PathVariable("id") int id) {
        return Mapper.convertToResponse(playerService.getPlayer(id));
    }

    @DeleteMapping("/rest/players/{id}")
    public void deletePlayer(@PathVariable("id") int id) {
        playerService.deletePlayer(id);
    }

    @PostMapping("/rest/players")
    private PlayerResponse createPlayer(@RequestBody PlayerRequest playerRequest) {
        PlayerDto playerDto = Mapper.convertToPlayerDto(playerRequest);
        PlayerDto newPlayerDto = playerService.createPlayer(playerDto);
        return Mapper.convertToResponse(newPlayerDto);
    }

    @PostMapping("/rest/players/{id}")
    public PlayerResponse updatePlayer(@PathVariable("id") int id, @RequestBody PlayerRequest playerRequest) {
        PlayerDto playerDto = Mapper.convertToPlayerDto(playerRequest);
        PlayerDto updatedPlayerDto = playerService.updatePlayer(id, playerDto);
        return Mapper.convertToResponse(updatedPlayerDto);
    }
}
