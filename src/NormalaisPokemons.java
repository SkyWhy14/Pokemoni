import javax.swing.JOptionPane;

public class NormalaisPokemons extends Pokemons {

    public NormalaisPokemons(String nosaukums, int hp, int attack, int defense, String string) {
    			super(nosaukums, nosaukums,"Parastais");
    			
    }

    @Override
    public void specialAttack(Pokemons target) {
        if (!specialAvailable) {
            JOptionPane.showMessageDialog(null, nosaukums + " īpašā uzbrukuma izmantošana nav pieejama!");
            return;
        }

        int dmg = uzbrukums * 2;
        JOptionPane.showMessageDialog(null, nosaukums + " izmantoja ĪPAŠO UZBRUKUMU un nodara " + dmg + " bojājumus!");
        target.takeDamage(dmg);

        specialAvailable = false; // reizi cīņā
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
