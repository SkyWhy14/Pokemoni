// WaterPokemon.java
import javax.swing.JOptionPane;

public class UdensP extends Pokemons {

    public UdensP(String nosaukums, int hp, int attack, int defense, String string) {
		super(nosaukums, nosaukums,"Udens");
	}

    // speciālais: ūdens strūklas uzbrukums, var samazināt pretinieka attack laika posmā (šeit vienkāršoti)
    @Override
    public void specialAttack(Pokemons target) {
        if (!specialAvailable) {
            JOptionPane.showMessageDialog(null, nosaukums + " nevar izmantot speciālo — tas jau izmantots.");
            return;
        }
        specialAvailable = false;
        int dmg = (int)(uzbrukums * 1.5);
        JOptionPane.showMessageDialog(null, nosaukums + " izmanto Ūdens strūklas uzbrukumu pret " + target.nosaukums + " un nodara " + dmg + " bojājumus!");
        target.takeDamage(dmg);
        // samazina pretinieka uzbrukumu īslaicīgi (vienkāršo)
        target.uzbrukums = Math.max(1, target.uzbrukums - 2);
        JOptionPane.showMessageDialog(null, target.nosaukums + " uzbrukums īslaicīgi samazināts par 2 punktiem.");
    }
}
