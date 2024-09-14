package com.example.demo.utils;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.PlayerEntity;

public class Mapper {

    public static PlayerEntity convertToPlayerEntity(PlayerDto playerDto) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(playerDto.getId());
        playerEntity.setName(playerDto.getName());
        playerEntity.setTitle(playerDto.getTitle());
        playerEntity.setRace(playerDto.getRace());
        playerEntity.setProfession(playerDto.getProfession());
        playerEntity.setExperience(playerDto.getExperience());
        playerEntity.setLevel(playerDto.getLevel());
        playerEntity.setUntilNextLevel(playerDto.getUntilNextLevel());
        playerEntity.setBirthday(playerDto.getBirthday());
        playerEntity.setBanned(playerDto.getBanned());
        return playerEntity;
    }

    public static PlayerDto convertToPlayerDto(PlayerEntity playerEntity) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(playerEntity.getId());
        playerDto.setName(playerEntity.getName());
        playerDto.setTitle(playerEntity.getTitle());
        playerDto.setRace(playerEntity.getRace());
        playerDto.setProfession(playerEntity.getProfession());
        playerDto.setExperience(playerEntity.getExperience());
        playerDto.setLevel(playerEntity.getLevel());
        playerDto.setUntilNextLevel(playerEntity.getUntilNextLevel());
        playerDto.setBirthday(playerEntity.getBirthday());
        playerDto.setBanned(playerEntity.getBanned());
        return playerDto;
    }

    public static PlayerDto convertToPlayerDto(PlayerRequest playerRequest) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(playerRequest.getId());
        playerDto.setName(playerRequest.getName());
        playerDto.setTitle(playerRequest.getTitle());
        playerDto.setRace(playerRequest.getRace());
        playerDto.setProfession(playerRequest.getProfession());
        playerDto.setExperience(playerRequest.getExperience());
        playerDto.setLevel(playerRequest.getLevel());
        playerDto.setUntilNextLevel(playerRequest.getUntilNextLevel());
        playerDto.setBirthday(playerRequest.getBirthday());
        playerDto.setBanned(playerRequest.getBanned());
        return playerDto;
    }

    public static PlayerResponse convertToResponse(PlayerDto playerDto) {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId(playerDto.getId());
        playerResponse.setName(playerDto.getName());
        playerResponse.setTitle(playerDto.getTitle());
        playerResponse.setRace(playerDto.getRace());
        playerResponse.setProfession(playerDto.getProfession());
        playerResponse.setExperience(playerDto.getExperience());
        playerResponse.setLevel(playerDto.getLevel());
        playerResponse.setUntilNextLevel(playerDto.getUntilNextLevel());
        playerResponse.setBirthday(playerDto.getBirthday());
        playerResponse.setBanned(playerDto.getBanned());
        return playerResponse;
    }
}
