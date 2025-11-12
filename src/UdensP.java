import javax.swing.JOptionPane;

public class UdensP  extends Pokemons {
	private int udensSpiediens;
	//viss ar JOptionPane

	public UdensP(String nosaukums, String string, int uzbrukums, int udensSpiediens) {
		super(nosaukums, string, uzbrukums, udensSpiediens);
		
		this.udensSpiediens = udensSpiediens;
	}

	@Override
	public void uzbrukt() {
	JOptionPane.showMessageDialog(null, nosaukums + " izmanto ūdens uzbrukumu ar spiedienu " + udensSpiediens + "!");
	}
	public void palelinatPretinieku() {
		JOptionPane.showMessageDialog(null, nosaukums + " ir samazinājis pretinieka ātrumu ar ūdens plūsmu!");
		
	}
	public void izvairities() {
		JOptionPane.showMessageDialog(null, nosaukums + " izmanto ūdens aizsardzību, lai izvairītos no uzbrukuma!");
	}
	public void dziedet(int dziedesana) {
		veseliba += dziedesana + 5; // Ūdens pokemoni saņem papildu dziedināšanu
		JOptionPane.showMessageDialog(null, nosaukums + " ir dziedināts par " + (dziedesana + 5) + " punktiem! Pašreizējā veselība: " + veseliba);
	}
	public void attistit(int attistibasLimenis) {
		uzbrukums += attistibasLimenis * 6; // Ūdens pokemoni iegūst lielāku uzbrukuma pieaugumu
		JOptionPane.showMessageDialog(null, nosaukums + " ir attīstījies! Pašreizējais uzbrukuma spēks: " + uzbrukums);
	}

	public void izsmidzinatUdeni(Pokemons pokemons2) {
		JOptionPane.showMessageDialog(null, nosaukums + " izmanto ūdens smidzināšanu pret " + pokemons2.nosaukums + "!");
		
	}
	

}
