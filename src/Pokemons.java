import javax.swing.JOptionPane;

public abstract class Pokemons {
    protected String nosaukums;
    protected int veseliba;
    protected int maxHp;
    protected int uzbrukums;
    protected int defense;
    protected boolean specialAvailable;
    protected String tips;
    protected int limenis;

    // Basic/default vērtības
    protected static final int BASIC_HP = 100;
    protected static final int BASIC_ATTACK = 20;
    protected static final int BASIC_DEFENSE = 10;
    protected static final int BASIC_LEVEL = 1;

    public Pokemons(String nosaukums, String tips, String string) {
        this.nosaukums = nosaukums;
        this.tips = tips;

        // Uzstāda basic vērtības
        this.maxHp = BASIC_HP;
        this.veseliba = BASIC_HP;
        this.uzbrukums = BASIC_ATTACK;
        this.defense = BASIC_DEFENSE;
        this.limenis = BASIC_LEVEL;

        this.specialAvailable = true;
    }

    public boolean isAlive() {
        return veseliba > 0;
    }

    public String getNosaukums() {
        return nosaukums;
    }

    public String getTips() {
        return tips;
    }

    public int getVeseliba() {
        return veseliba;
    }

    public int getUzbrukums() {
        return uzbrukums;
    }

    public int getDefense() {
        return defense;
    }

    public int getLimenis() {
        return limenis;
    }

    public int getMaxHp() {
        return maxHp;
    }
    public boolean isSpecialAvailable() {
		
		if (specialAvailable) {
			return true;
		} else {
			return false;
		}
	}

    // ======================
    // SAŅEM BOJĀJUMUS
    // ======================
    public void takeDamage(int dmg) {
        int reducedDamage = defense / 4;
        int finalDamage = dmg - reducedDamage;

        if (finalDamage < 1) finalDamage = 1;

        veseliba -= finalDamage;
        if (veseliba < 0) veseliba = 0;

        JOptionPane.showMessageDialog(null,
                nosaukums + " saņēma " + finalDamage + " dmg "
                        + "(aizsardzība -" + reducedDamage + ")\n"
                        + "HP: " + veseliba + "/" + maxHp);
    }

    // ======================
    // PARASTAIS UZBRUKUMS
    // ======================
    public int basicAttack() {
        return uzbrukums;
    }

    // ======================
    // ĀRSTĒŠANA
    // ======================
    public void heal(int amount) {
        veseliba += amount;
        if (veseliba > maxHp) veseliba = maxHp;

        JOptionPane.showMessageDialog(null,
                nosaukums + " atguva " + amount + " HP.\n"
                        + "HP: " + veseliba + "/" + maxHp);
    }

    // ======================
    // AIZSARDZĪBAS PALIELINĀŠANA
    // ======================
    public void boostDefense(int amount) {
        defense += amount;

        JOptionPane.showMessageDialog(null,
                nosaukums + " palielināja aizsardzību par " + amount
                        + ".\nDEF: " + defense);
    }

    // ======================
    // SPECIAL ATTACK
    // ======================
    public abstract void specialAttack(Pokemons target);

    // ======================
    // INFORMĀCIJAS ATTĒLOŠANA
    // ======================
    
    
    
 // Atgriež objekta atribūtus kā formatētu tekstu
    public String getAtributi() {
        return  "Nosaukums: " + nosaukums + "\n" +
                
                "HP: " + veseliba + "/" + maxHp + "\n" +
                "ATK: " + uzbrukums + "\n" +
                "DEF: " + defense + "\n" +
                // Pārbauda, vai speciālais uzbrukums ir pieejams
                "Special: " + (specialAvailable ? "Pieejams" : "Nav pieejams") + "\n" +
                "----------------------------------------";
    }

	
	
}
