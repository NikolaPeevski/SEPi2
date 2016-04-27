package com.Clerver.domain.model;

import java.io.Serializable;

public class Stats implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// --Base stats
	private int healthPoints;
	private int currentHp;
	private int mana;
	private int abilityPower;
	private int attackDamage;
	private int magicResistance;
	private int armor;
	private int Evasion;
	private int Fumble;
	private int toHit;
	private int criticalChance;
	private int speed;
	private int initiative;
	private int reflection; // -- Added chance to reflect;
	private int block;
	// --- Main change stats;

	private int steamRolliness;
	private int plasticness;
	private int eagerness;
	private int childishness;
	private int injudiciousness;
	private int aluminiumness;
	private int looking;

	// --- SubStats
	private int conductivity;
	private int ignition;
	private int elemental;
	private int ignorence;
	private int greacy;

	public Stats() {
		increaseSteamRolliness(5);
		increasePlasticness(5);
		increaseEagerness(5);
		increaseChildishness(5);
		increaseInjudiciousness(5);
		increaseAluminiumness(5);
		increaseLooking(5);
		currentHp = healthPoints;
	}

	public void increaseSteamRolliness(int n) {
		steamRolliness += n;
		increaseMagicResistance(n * 1);
		increaseHealthPoints(n * 4);
		increaseSpeed(n * 2);
		increaseFumble(n * 2);
	}

	public boolean increasePlasticness(int n) {
		plasticness += n;
		increaseIgnition(n);
		decreaseSpeed(2 * n);
		increaseMagicResistance(n * 2);
		increaseMana(15 * n);
		return true;
	}

	public void increaseEagerness(int n) {
		eagerness += n;
		increaseSpeed(n * 5);
		increaseInitiative(n * 3);
		increaseEvasion(n * 2);
		increaseFumble(n * 3);
	}

	public boolean increaseChildishness(int n) {
		childishness += n;
		increaseArmor(n * 2);
		increaseCrit(n * 2);
		increaseEvasion(n * 2);
		return true;
	}

	public boolean increaseInjudiciousness(int n) {
		injudiciousness += n;
		increaseConductivity(n * 4);
		increaseIgnorence(n * 4);
		increaseMana(15 * n);
		return true;
	}

	public boolean increaseAluminiumness(int n) {
		aluminiumness += n;
		increaseConductivity(n * 2);
		increaseHealthPoints(n * 3);
		increaseElemental(n * 2);
		return true;
	}

	public boolean increaseLooking(int n) {
		looking += n;
		increaseCrit(n * 2);
		increaseToHit(n * 2);
		increaseInitiative(n * 2);
		return true;
	}

	public void decreaseSteamRolliness(int n) {
		steamRolliness -= n;
		decreaseMagicResistance(n * 1);
		decreaseHealthPoints(n * 4);
		decreaseSpeed(n * 2);
		decreaseFumble(n * 2);
	}

	public boolean decreasePlasticness(int n) {
		plasticness -= n;
		decreaseIgnition(n);
		decreaseSpeed(2 * n);
		decreaseMagicResistance(n * 2);
		decreaseMana(15 * n);
		return true;
	}

	public void decreaseEagerness(int n) {
		eagerness -= n;
		decreaseSpeed(n * 5);
		decreaseInitiative(n * 3);
		decreaseEvasion(n * 2);
		decreaseFumble(n * 3);
	}

	public boolean decreaseChildishness(int n) {
		childishness -= n;
		decreaseArmor(n * 2);
		decreaseCrit(n * 2);
		decreaseEvasion(n * 2);
		return true;
	}

	public boolean decreaseInjudiciousness(int n) {
		injudiciousness -= n;
		decreaseConductivity(n * 4);
		decreaseIgnorence(n * 4);
		decreaseMana(15 * n);
		return true;
	}

	public boolean decreaseAluminiumness(int n) {
		aluminiumness -= n;
		decreaseConductivity(n * 2);
		decreaseHealthPoints(n * 3);
		decreaseElemental(n * 2);
		return true;
	}

	public boolean decreaseLooking(int n) {
		looking -= n;
		decreaseCrit(n * 2);
		decreaseToHit(n * 2);
		decreaseInitiative(n * 2);
		return true;
	}

	public boolean increaseConductivity(int n) {
		conductivity += n;
		decreaseMagicResistance(n * 3);
		increaseAbilityPower(n * 5);
		increaseReflection(n * 3);
		return true;
	}

	public boolean increaseIgnorence(int n) {
		ignorence += n;
		decreaseBlock(n);
		decreaseReflection(n);
		return true;
	}

	public boolean increaseIgnition(int n) {
		ignition += n;
		decreaseArmor(n * 2);
		increaseBlock(n);
		increaseAttackDamage(n * 5);
		return true;
	}

	public boolean decreaseConductivity(int n) {
		conductivity -= n;
		increaseMagicResistance(n * 3);
		decreaseAbilityPower(n * 5);
		decreaseReflection(n * 3);
		return true;
	}

	public boolean decreaseIgnorence(int n) {
		ignorence -= n;
		increaseBlock(n);
		increaseReflection(n);
		return true;
	}

	public boolean decreaseIgnition(int n) {
		ignition -= n;
		increaseArmor(n * 2);
		decreaseBlock(n);
		decreaseAttackDamage(n * 5);
		return true;
	}

	public void increaseElemental(int n) {
		elemental += n;
	}

	public boolean decreaseElemental(int n) {
		if (elemental != 0 && ((elemental - n)) >= 0) {
			elemental -= n;
			return true;
		}
		return false;
	}

	public boolean increaseHealthPoints(int n) {
		healthPoints += n;
		return true;
	}

	public boolean decreaseHealthPoints(int n) {
		if (healthPoints != 0 && ((healthPoints - n)) >= 0) {
			healthPoints -= n;
			return true;
		}
		return false;
	}

	public boolean increaseMana(int n) {
		mana += n;
		return true;
	}

	public boolean decreaseMana(int n) {
		if (mana != 0 && ((mana - n)) >= 0) {
			mana -= n;
			return true;
		}
		return false;
	}

	public boolean increaseAbilityPower(int n) {
		abilityPower += n;
		return true;
	}

	public boolean decreaseAbilityPower(int n) {
		if (abilityPower != 0 && ((abilityPower - n)) >= 0) {
			abilityPower -= n;
			return true;
		}
		return false;
	}

	public boolean increaseAttackDamage(int n) {
		attackDamage += n;
		return true;
	}

	public boolean decreaseAttackDamage(int n) {
		if (attackDamage != 0 && ((attackDamage - n)) >= 0) {
			attackDamage -= n;
			return true;
		}
		return false;
	}

	public boolean increaseMagicResistance(int n) {
		if (magicResistance != 100 && ((magicResistance + n)) <= 100) {
			magicResistance += n;
			return true;
		}
		return false;
	}

	public boolean decreaseMagicResistance(int n) {
		if (magicResistance != 0 && ((magicResistance - n)) >= 0) {
			magicResistance -= n;
			return true;
		}
		return false;
	}

	public boolean increaseArmor(int n) {
		armor += n;
		return true;
	}

	public boolean decreaseArmor(int n) {
		if (armor != 0 && ((armor - n)) >= 0) {
			armor -= n;
			return true;
		}
		return false;
	}

	public boolean increaseEvasion(int n) {
		if (Evasion != 100 && ((Evasion + n)) <= 100) {
			Evasion += n;
			return true;
		}
		return false;
	}

	public boolean decreaseEvasion(int n) {
		if (Evasion != 0 && ((Evasion - n)) >= 0) {
			Evasion -= n;
			return true;
		}
		return false;
	}

	public boolean increaseFumble(int n) {
		if (Fumble != 100 && ((Fumble + n)) <= 100) {
			Fumble += n;
			return true;
		}
		return false;
	}

	public boolean decreaseFumble(int n) {
		if (Fumble != 0 && ((Fumble - n)) >= 0) {
			Fumble -= n;
			return true;
		}
		return false;
	}

	public boolean increaseToHit(int n) {
		if (toHit != 100 && ((toHit + n)) <= 100) {
			toHit += n;
			return true;
		}
		return false;
	}

	public boolean decreaseToHit(int n) {
		if (toHit != 0 && ((toHit - n)) >= 0) {
			toHit -= n;
			return true;
		}
		return false;
	}

	public boolean increaseCrit(int n) {
		if (criticalChance != 100 && ((criticalChance + n)) <= 100) {
			criticalChance += n;
			return true;
		}
		return false;
	}

	public boolean decreaseCrit(int n) {
		if (criticalChance != 0 && ((criticalChance - n)) >= 0) {
			criticalChance -= n;
			return true;
		}
		return false;
	}

	public boolean increaseSpeed(int n) {
		if (speed != 340 && ((speed + n)) <= 340) {
			speed += n;
			return true;
		}
		return false;
	}

	public boolean decreaseSpeed(int n) {
		speed -= n;
		return true;
	}

	public boolean increaseInitiative(int n) {
		if (initiative != 1000 && ((initiative + n)) <= 1000) {
			initiative += n;
			return true;
		}
		return false;
	}

	public boolean decreaseInitiative(int n) {
		if (initiative != 100 && ((initiative - n)) >= 100) {
			initiative -= n;
			return true;
		}
		return false;
	}

	public boolean increaseBlock(int n) {
		if (block != 100 && ((block + n)) <= 100) {
			block += n;
			return true;
		}
		return false;
	}

	public boolean decreaseBlock(int n) {
		if (block != 100 && ((block - n)) >= 100) {
			block -= n;
			return true;
		}
		return false;
	}

	public boolean increaseReflection(int n) {
		if (reflection != 1000 && ((reflection + n)) <= 1000) {
			reflection += n;
			return true;
		}
		return false;
	}

	public boolean decreaseReflection(int n) {
		if (reflection != 100 && ((reflection - n)) >= 100) {
			reflection -= n;
			return true;
		}
		return false;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public int getMana() {
		return mana;
	}

	public int getAbilityPower() {
		return abilityPower;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public int getMagicResistance() {
		return magicResistance;
	}

	public int getArmor() {
		return armor;
	}

	public int getEvasion() {
		return Evasion;
	}

	public int getFumble() {
		return Fumble;
	}

	public int getToHit() {
		return toHit;
	}

	public int getCriticalChance() {
		return criticalChance;
	}

	public int getSpeed() {
		return speed;
	}

	public int getInitiative() {
		return initiative;
	}

	public int getReflection() {
		return reflection;
	}

	public int getBlock() {
		return block;
	}

	public int getSteamRolliness() {
		return steamRolliness;
	}

	public int getPlasticness() {
		return plasticness;
	}

	public int getEagerness() {
		return eagerness;
	}

	public int getChildishness() {
		return childishness;
	}

	public int getInjudiciousness() {
		return injudiciousness;
	}

	public int getAluminiumness() {
		return aluminiumness;
	}

	public int getLooking() {
		return looking;
	}

	public int getConductivity() {
		return conductivity;
	}

	public int getIgnition() {
		return ignition;
	}

	public int getElemental() {
		return elemental;
	}

	public int getIgnorence() {
		return ignorence;
	}

	public int getGreacy() {
		return greacy;
	}
	public int getCurrentHP(){
		return this.currentHp;
	}
	public void setCurrentHp(int index){
		currentHp -= index;
	}

	public boolean levelup(int S, int P, int E, int C, int I, int A, int L) {
		increaseSteamRolliness(S);
		increasePlasticness(P);
		increaseEagerness(E);
		increaseChildishness(C);
		increaseInjudiciousness(I);
		increaseAluminiumness(A);
		increaseLooking(L);
		currentHp = healthPoints;
		return true;
	}

	public boolean unLevel(int S, int P, int E, int C, int I, int A, int L) {
		decreaseSteamRolliness(S);
		decreasePlasticness(P);
		decreaseEagerness(E);
		decreaseChildishness(C);
		decreaseInjudiciousness(I);
		decreaseAluminiumness(A);
		decreaseLooking(L);
		return true;
	}
}
