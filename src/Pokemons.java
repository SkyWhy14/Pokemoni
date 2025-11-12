import javax.swing.JOptionPane;

public class Pokemons {
		protected String nosaukums;
	protected int veseliba;
	protected int uzbrukums;

	public Pokemons(String nosaukums, int veseliba, int uzbrukums) {
		this.nosaukums = nosaukums;
		this.veseliba = veseliba;
		this.uzbrukums = uzbrukums;
	}

	public void uzbrukt() {
		JOptionPane.showMessageDialog(null, nosaukums + " izmanto vispārīgo uzbrukumu ar spēku " + uzbrukums + "!");
	}
	public void izvairities() {
		JOptionPane.showMessageDialog(null, nosaukums + " izmanto vispārīgo aizsardzību, lai izvairītos no uzbrukuma!");
	}
	public void dziedet(int dziedesana) {
		veseliba += dziedesana;
		JOptionPane.showMessageDialog(null, nosaukums + " ir dziedināts par " + dziedesana + " punktiem! Pašreizējā veselība: " + veseliba);
	}
	public void attistit(int attistibasLimenis) {
		uzbrukums += attistibasLimenis * 5;
		JOptionPane.showMessageDialog(null, nosaukums + " ir attīstījies! Pašreizējais uzbrukuma spēks: " + uzbrukums);
	}

	public int izvaditInfo() {
		JOptionPane.showMessageDialog(null, "Pokemona nosaukums: " + nosaukums +
				"\nVeselība: " + veseliba +
				"\nUzbrukuma spēks: " + uzbrukums,
				"Pokemona informācija", JOptionPane.INFORMATION_MESSAGE);
		return 0;
	}
	

}
