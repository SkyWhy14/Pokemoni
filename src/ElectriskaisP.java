import javax.swing.JOptionPane;

public class ElectriskaisP extends Pokemons {
	private int elektroStiprums;

	public ElectriskaisP(String nosaukums, int veseliba, int uzbrukums, int elektroStiprums) {
		super(nosaukums, veseliba, uzbrukums);
		this.elektroStiprums = elektroStiprums;
	}

	@Override
	public void uzbrukt() {
		JOptionPane.showMessageDialog(null, nosaukums + " izmanto elektrisko uzbrukumu ar stiprumu " + elektroStiprums + "!");
	}
	public void paralizetPretinieku() {
		JOptionPane.showMessageDialog(null, nosaukums + " ir paralizējis pretinieku ar elektrisko šoku!");
		
	}
	public void izvairities() {
		JOptionPane.showMessageDialog(null, nosaukums + " izmanto elektrisko lauku, lai izvairītos no uzbrukuma!");
	}
	public void dziedet(int dziedesana) {
		veseliba += dziedesana + 3; // Elektriskie pokemoni saņem papildu dziedināšanu
		JOptionPane.showMessageDialog(null, nosaukums + " ir dziedināts par " + (dziedesana + 3) + " punktiem! Pašreizējā veselība: " + veseliba);
	}
	public void attistit(int attistibasLimenis) {
		uzbrukums += attistibasLimenis * 4; // Elektriskie pokemoni iegūst vidēju uzbrukuma pieaugumu
		JOptionPane.showMessageDialog(null, nosaukums + " ir attīstījies! Pašreizējais uzbrukuma spēks: " + uzbrukums);
	}
}
