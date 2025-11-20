import javax.swing.JOptionPane;

public class NormalaisPokemons extends Pokemons {

	public NormalaisPokemons(String nosaukums, int hp, int attack, int defense) { //Parasto pokemonu atrabūtu noteikšana
        super(nosaukums, "Parastais", hp, attack, defense);
    }

    @Override
    public void specialAttack(Pokemons target) { //Īpašo uzbrukumu metodes izsaukšana un pārbaude
        if (!specialAvailable) {
            JOptionPane.showMessageDialog(null, nosaukums + " īpašā uzbrukuma izmantošana nav pieejama!");
            return;
        }
        
        
        
        int dmg = uzbrukums * 2;
        JOptionPane.showMessageDialog(null, nosaukums + " izmantoja ĪPAŠO UZBRUKUMU un nodara " + dmg + " zaudējumu!");
        target.takeDamage(dmg);
        
        specialAvailable = false; // reizi cīņā
    }

}
