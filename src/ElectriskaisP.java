// ElectricPokemon.java
import javax.swing.JOptionPane;
import java.util.Random;

public class ElectriskaisP extends Pokemons {
    

	private Random rnd = new Random();

   public ElectriskaisP(String nosaukums, int hp, int attack, int defense, String string) {
		super(nosaukums, nosaukums,"Elektriskais");
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
        // paralīzes iespēja:
        if (target.isAlive() && rnd.nextInt(100) < 30) {
            // 30% paralize: nākamajā raundā ai/lietotājs var netikt aktivs — šis var tikt paplašināts ar statusiem
            JOptionPane.showMessageDialog(null, target.nosaukums + " ir paralizēts (varbūtība 30%)! Nākamajā raundā var palaist gājienu.");
          
        }
    }

	@Override
	public String getAtributi() {
		  return  "Nosaukums: " + nosaukums + "\n" +
	                
	                "HP: " + veseliba + "/" + maxHp + "\n" +
	                "ATK: " + uzbrukums + "\n" +
	                "DEF: " + defense + "\n" +
	                "Special: " + (specialAvailable ? "Pieejams" : "Izmantots") + "\n" +
	                "----------------------------------------";
		
	}
}
