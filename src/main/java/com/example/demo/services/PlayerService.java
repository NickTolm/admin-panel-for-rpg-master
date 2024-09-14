package com.example.demo.services;

import com.example.demo.dao.PlayerDao;
import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.PlayerEntity;
import com.example.demo.utils.Mapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerDao playerDao;
    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public int getPlayersCount() {
        return playerDao.getPlayersCount();
    }

    public List<PlayerEntity> getPlayersList() {
        return playerDao.getPlayersList();
    }

    public PlayerDto getPlayer(int playerId){
        return Mapper.convertToPlayerDto(playerDao.getPlayer(playerId));
    }

    public void deletePlayer(int playerId){
        playerDao.deletePlayer(playerId);
    }

    public PlayerDto createPlayer(PlayerDto playerDto) {
        PlayerEntity playerEntity = Mapper.convertToPlayerEntity(playerDto);
        PlayerEntity savedPlayerEntity = playerDao.createPlayer(playerEntity);
        return Mapper.convertToPlayerDto(savedPlayerEntity);
    }

    public PlayerDto updatePlayer(int playerId, PlayerDto playerDto) {
        PlayerEntity playerEntity = Mapper.convertToPlayerEntity(playerDto);
        PlayerEntity updatedPlayerEntity = playerDao.updatePlayer(playerId, playerEntity);
        return Mapper.convertToPlayerDto(updatedPlayerEntity);
    }
}
