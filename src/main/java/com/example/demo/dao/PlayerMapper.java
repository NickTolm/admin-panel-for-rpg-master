package com.example.demo.dao;

import com.example.demo.entity.PlayerEntity;
import com.example.demo.entity.Profession;
import com.example.demo.entity.Race;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<PlayerEntity> {
    @Override
    public PlayerEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        PlayerEntity playerEntity = new PlayerEntity();

        playerEntity.setId(resultSet.getLong("id"));
        playerEntity.setName(resultSet.getString("name"));
        playerEntity.setTitle(resultSet.getString("title"));
        playerEntity.setRace(Race.valueOf((resultSet.getString("race"))));
        playerEntity.setProfession(Profession.valueOf(resultSet.getString("profession")));
        playerEntity.setExperience(resultSet.getInt("experience"));
        playerEntity.setLevel(resultSet.getInt("level"));
        playerEntity.setUntilNextLevel(resultSet.getInt("untilNextLevel"));
        playerEntity.setBirthday(resultSet.getDate("birthday"));
        playerEntity.setBanned(resultSet.getBoolean("banned"));

        return playerEntity;
    }
}
