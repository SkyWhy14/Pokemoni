// ElectricPokemon.java
import java.util.Random;

import javax.swing.JOptionPane;

public class UdensP extends Pokemons {
    

	private Random rnd = new Random();

	public UdensP(String nosaukums, int hp, int attack, int defense) {
        super(nosaukums, "Ūdens", hp, attack, defense);
    }

    // speciālais uzbrukums: var paralizēt pretinieku (ar varbūtību)
	@Override
	public void specialAttack(Pokemons target) {
	    if (!specialAvailable) {
	        JOptionPane.showMessageDialog(null, nosaukums + " jau izmantoja speciālo!");
	        return;
	    }

	    specialAvailable = false;

	    int dmg = (int)(uzbrukums * 1.3);
	    target.takeDamage(dmg);

	    int weakAmount = 5;
	    target.uzbrukums -= weakAmount;

	    if (target.uzbrukums < 1) {
	        target.uzbrukums = 1;
	    }

	    JOptionPane.showMessageDialog(null,
	        nosaukums + " aplēja " + target.nosaukums +
	        "! Pretinieka uzbrukums samazināts par " + weakAmount + "!");
	}

	
	
}
