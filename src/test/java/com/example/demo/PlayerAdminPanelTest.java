package com.example.demo;

import com.example.demo.entity.PlayerEntity;
import com.example.demo.entity.Profession;
import com.example.demo.entity.Race;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PlayerAdminPanelTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getPlayersCountTest() throws Exception {
        mockMvc.perform(get("/rest/players/count"))
                .andExpect(jsonPath().v ;

        )

    }

    @Test
    void getPlayerListTest() throws Exception {

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

        mockMvc.perform(get("rest/players"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(playerEntity1))));
    }


}
