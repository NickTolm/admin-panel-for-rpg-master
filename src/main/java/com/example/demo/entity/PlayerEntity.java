package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
@Setter
@Getter
public class PlayerEntity {
    @Id
    @Column(name = "id_player")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id;
    @Column(name = "name_player")
    private String name;
    @Column(name = "title_player")
    private String title;
    @Column(name = "race_plauer")
    private Race race;
    @Column(name = "profession_player")
    private Profession profession;
    @Column(name = "experience_player")
    private Integer experience;
    @Column(name = "level_player")
    private Integer level;
    @Column(name = "untilNextLevel")
    private Integer untilNextLevel;
    @Column(name = "birthday_player")
    private Date birthday;
    @Column(name = "banned)")
    private Boolean banned;

}
