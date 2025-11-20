// ElectricPokemon.java
import javax.swing.JOptionPane;
import java.util.Random;

public class ElectriskaisP extends Pokemons {
    

	private Random rnd = new Random();

	public ElectriskaisP(String nosaukums, int hp, int attack, int defense) {
        super(nosaukums, "Elektriskais", hp, attack, defense);
    }

    // speciālais uzbrukums: var paralizēt pretinieku (ar varbūtību)
	@Override
	public void specialAttack(Pokemons target) {
	    if (!specialAvailable) {
	        JOptionPane.showMessageDialog(null, nosaukums + " nevar izmantot speciālo — tas jau izmantots.");
	        return;
	    }

	    specialAvailable = false;
	    int dmg = (int)(uzbrukums * 1.7);
	    JOptionPane.showMessageDialog(null, nosaukums + " izmanto Elektrisko šoku pret " + target.nosaukums + " un nodara " + dmg + " bojājumus!");
	    target.takeDamage(dmg);

	    // paralīzes iespēja
	    if (target.isAlive() && rnd.nextInt(100) < 30) {
	        target.setParalizets(true);
	        JOptionPane.showMessageDialog(null, target.nosaukums + " ir paralizēts! Nākamajā raundā var izlaist gājienu.");
	    }
	}

	
}
