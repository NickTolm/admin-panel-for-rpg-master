package com.example.demo.H2;

import com.example.demo.entity.PlayerEntity;
import com.example.demo.entity.Profession;
import com.example.demo.entity.Race;
import com.example.demo.services.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtils {

    private final PlayerService playerService;

    public InitiateUtils(PlayerService playerService) {
        this.playerService = playerService;
    }


    public void run() {
        PlayerEntity playerEntity1 = new PlayerEntity();
        playerEntity1.setName("Нэсс");
        playerEntity1.setTitle("Темновидец");
        playerEntity1.setRace(Race.ELF);
        playerEntity1.setProfession(Profession.WARRIOR);
        playerEntity1.setExperience(144878);
        playerEntity1.setLevel(53);
        playerEntity1.setUntilNextLevel(234);
        playerEntity1.setBirthday(null);
        playerEntity1.setBanned(false);
    }




}
