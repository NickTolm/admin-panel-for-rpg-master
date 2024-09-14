package com.example.demo.dao;

import com.example.demo.entity.PlayerEntity;
import com.example.demo.entity.Profession;
import com.example.demo.entity.Race;
import com.example.demo.filter.PlayerOrder;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class PlayerDao implements JpaRepository<PlayerEntity, Long> {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<PlayerEntity> playerMapper = new PlayerMapper();

    public PlayerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getPlayersCount() {
        String SQL = "SELECT count(*) FROM player";

        return jdbcTemplate.queryForObject(SQL, Integer.class);
    }

    public List<PlayerEntity> getPlayersList() {
        String SQL = "SELECT * FROM player";
        return jdbcTemplate.query(SQL, playerMapper);
    }

    public PlayerEntity createPlayer(PlayerEntity playerEntity) {
        String SQL = "INSERT INTO player(name, title, race, profession, birthday, banned, experience, level, untilNextLevel)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(SQL,
                playerEntity.getName(),
                playerEntity.getTitle(),
                playerEntity.getRace(),
                playerEntity.getProfession(),
                playerEntity.getBirthday(),
                playerEntity.getBanned(),
                playerEntity.getExperience(),
                playerEntity.getLevel(),
                playerEntity.getUntilNextLevel());

        return jdbcTemplate.queryForObject("SELECT * FROM players ORDER BY id DESC LIMIT 1", playerMapper);
    }

    public PlayerEntity getPlayer(Integer playerId) {
        String SQL = "SELECT * FROM player WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(SQL, playerMapper, playerId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public PlayerEntity updatePlayer(Integer playerId, PlayerEntity playerEntity) {
        String SQL = "UPDATE player " +
                "SET name = ?, title = ?, race = ?, profession = ?, birthday =  ?, banned = ?, experience = ?, level = ?, untilNextLevel = ? " +
                "WHERE id = ?;";
        return jdbcTemplate.queryForObject(SQL, playerMapper, playerId);
    }

    public void deletePlayer(Integer playerId) {
        String SQL = "DELETE FROM player WHERE id=?";
        jdbcTemplate.update(SQL, playerId);
    }

    public List<PlayerEntity> playersFiltersSearch(PlayerOrder playerOrder) {

        return null;
    }

    public int playersFilterCount(PlayerOrder playerOrder) {

        return 0;
    }

    @Override
    public List<PlayerEntity> findAll() {
        return null;
    }

    @Override
    public List<PlayerEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PlayerEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PlayerEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(PlayerEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends PlayerEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PlayerEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PlayerEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PlayerEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PlayerEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PlayerEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PlayerEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PlayerEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public PlayerEntity getById(Long aLong) {
        return null;
    }

    @Override
    public PlayerEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends PlayerEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PlayerEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PlayerEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PlayerEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PlayerEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PlayerEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PlayerEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
