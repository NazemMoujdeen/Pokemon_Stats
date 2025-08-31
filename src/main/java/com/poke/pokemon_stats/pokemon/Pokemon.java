package com.poke.pokemon_stats.pokemon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="gen1_stats")
public class Pokemon {
    @Id // Primary key identifier
    @Column(name = "number",unique = true, nullable = false)
    private Integer number;

    private String name;

    private Integer types;

    private String type1;

    private String type2;

    @Column(name = "height_m")
    private Float heightM;

    @Column(name = "weight_kg")
    private Float weightKg;

    @Column(name = "male_pct")
    private Float malePct;

    @Column(name = "female_pct")
    private Float femalePct;

    @Column(name = "capt_rate")
    private Integer captRate;

    @Column(name = "exp_points")
    private Integer expPoints;

    @Column(name = "exp_speed")
    private String expSpeed;

    @Column(name = "base_total")
    private Integer baseTotal;

    private Integer hp;

    private Integer attack;

    private Integer defense;

    private Integer special;

    private Integer speed;

    @Column(name = "normal_dmg")
    private Float normalDmg;

    @Column(name = "fire_dmg")
    private Float fireDmg;

    @Column(name = "water_dmg")
    private Float waterDmg;

    @Column(name = "electric_dmg")
    private Float electricDmg;

    @Column(name = "grass_dmg")
    private Float grassDmg;

    @Column(name = "ice_dmg")
    private Float iceDmg;

    @Column(name = "fight_dmg")
    private Float fightDmg;

    @Column(name = "poison_dmg")
    private Float poisonDmg;

    @Column(name = "ground_dmg")
    private Float groundDmg;

    @Column(name = "flying_dmg")
    private Float flyingDmg;

    @Column(name = "psychic_dmg")
    private Float psychicDmg;

    @Column(name = "bug_dmg")
    private Float bugDmg;

    @Column(name = "rock_dmg")
    private Float rockDmg;

    @Column(name = "ghost_dmg")
    private Float ghostDmg;

    @Column(name = "dragon_dmg")
    private Float dragonDmg;

    private Integer evolutions;

    private Integer legendary;

    // --- Getters and Setters ---
    // JPA requires a no-argument constructor and getters/setters for all fields.

    public Pokemon() {
        // Default constructor
    }

    public Pokemon(Integer number, String name, Integer types, String type1, String type2, Float heightM, Float weightKg, Float malePct, Float femalePct, Integer captRate, Integer expPoints, String expSpeed, Integer baseTotal, Integer hp, Integer attack, Integer defense, Integer special, Integer speed, Float normalDmg, Float fireDmg, Float waterDmg, Float electricDmg, Float grassDmg, Float iceDmg, Float fightDmg, Float poisonDmg, Float groundDmg, Float flyingDmg, Float psychicDmg, Float bugDmg, Float rockDmg, Float ghostDmg, Float dragonDmg, Integer evolutions, Integer legendary) {
        this.number = number;
        this.name = name;
        this.types = types;
        this.type1 = type1;
        this.type2 = type2;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.malePct = malePct;
        this.femalePct = femalePct;
        this.captRate = captRate;
        this.expPoints = expPoints;
        this.expSpeed = expSpeed;
        this.baseTotal = baseTotal;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.special = special;
        this.speed = speed;
        this.normalDmg = normalDmg;
        this.fireDmg = fireDmg;
        this.waterDmg = waterDmg;
        this.electricDmg = electricDmg;
        this.grassDmg = grassDmg;
        this.iceDmg = iceDmg;
        this.fightDmg = fightDmg;
        this.poisonDmg = poisonDmg;
        this.groundDmg = groundDmg;
        this.flyingDmg = flyingDmg;
        this.psychicDmg = psychicDmg;
        this.bugDmg = bugDmg;
        this.rockDmg = rockDmg;
        this.ghostDmg = ghostDmg;
        this.dragonDmg = dragonDmg;
        this.evolutions = evolutions;
        this.legendary = legendary;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2.equals("None") ? null : type2;
    }

    public Float getHeightM() {
        return heightM;
    }

    public void setHeightM(Float heightM) {
        this.heightM = heightM;
    }

    public Float getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Float weightKg) {
        this.weightKg = weightKg;
    }

    public Float getMalePct() {
        return malePct;
    }

    public void setMalePct(Float malePct) {
        this.malePct = malePct;
    }

    public Float getFemalePct() {
        return femalePct;
    }

    public void setFemalePct(Float femalePct) {
        this.femalePct = femalePct;
    }

    public Integer getCaptRate() {
        return captRate;
    }

    public void setCaptRate(Integer captRate) {
        this.captRate = captRate;
    }

    public Integer getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(Integer expPoints) {
        this.expPoints = expPoints;
    }

    public String getExpSpeed() {
        return expSpeed;
    }

    public void setExpSpeed(String expSpeed) {
        this.expSpeed = expSpeed;
    }

    public Integer getBaseTotal() {
        return baseTotal;
    }

    public void setBaseTotal(Integer baseTotal) {
        this.baseTotal = baseTotal;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpecial() {
        return special;
    }

    public void setSpecial(Integer special) {
        this.special = special;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Float getNormalDmg() {
        return normalDmg;
    }

    public void setNormalDmg(Float normalDmg) {
        this.normalDmg = normalDmg;
    }

    public Float getFireDmg() {
        return fireDmg;
    }

    public void setFireDmg(Float fireDmg) {
        this.fireDmg = fireDmg;
    }

    public Float getWaterDmg() {
        return waterDmg;
    }

    public void setWaterDmg(Float waterDmg) {
        this.waterDmg = waterDmg;
    }

    public Float getElectricDmg() {
        return electricDmg;
    }

    public void setElectricDmg(Float electricDmg) {
        this.electricDmg = electricDmg;
    }

    public Float getGrassDmg() {
        return grassDmg;
    }

    public void setGrassDmg(Float grassDmg) {
        this.grassDmg = grassDmg;
    }

    public Float getIceDmg() {
        return iceDmg;
    }

    public void setIceDmg(Float iceDmg) {
        this.iceDmg = iceDmg;
    }

    public Float getFightDmg() {
        return fightDmg;
    }

    public void setFightDmg(Float fightDmg) {
        this.fightDmg = fightDmg;
    }

    public Float getPoisonDmg() {
        return poisonDmg;
    }

    public void setPoisonDmg(Float poisonDmg) {
        this.poisonDmg = poisonDmg;
    }

    public Float getGroundDmg() {
        return groundDmg;
    }

    public void setGroundDmg(Float groundDmg) {
        this.groundDmg = groundDmg;
    }

    public Float getFlyingDmg() {
        return flyingDmg;
    }

    public void setFlyingDmg(Float flyingDmg) {
        this.flyingDmg = flyingDmg;
    }

    public Float getPsychicDmg() {
        return psychicDmg;
    }

    public void setPsychicDmg(Float psychicDmg) {
        this.psychicDmg = psychicDmg;
    }

    public Float getBugDmg() {
        return bugDmg;
    }

    public void setBugDmg(Float bugDmg) {
        this.bugDmg = bugDmg;
    }

    public Float getRockDmg() {
        return rockDmg;
    }

    public void setRockDmg(Float rockDmg) {
        this.rockDmg = rockDmg;
    }

    public Float getGhostDmg() {
        return ghostDmg;
    }

    public void setGhostDmg(Float ghostDmg) {
        this.ghostDmg = ghostDmg;
    }

    public Float getDragonDmg() {
        return dragonDmg;
    }

    public void setDragonDmg(Float dragonDmg) {
        this.dragonDmg = dragonDmg;
    }

    public Integer getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(Integer evolutions) {
        this.evolutions = evolutions;
    }

    public Integer getLegendary() {
        return legendary;
    }

    public void setLegendary(Integer legendary) {
        this.legendary = legendary;
    }
}
