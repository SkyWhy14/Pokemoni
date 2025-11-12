
public class UdensP  extends Pokemons {
	private int udensSpiediens;

	public UdensP(String nosaukums, int veseliba, int uzbrukums, int udensSpiediens) {
		super(nosaukums, veseliba, uzbrukums);
		this.udensSpiediens = udensSpiediens;
	}

	@Override
	public void uzbrukt() {
		System.out.println(nosaukums + " izmanto ūdens uzbrukumu ar spiedienu " + udensSpiediens + "!");
	}

	public void izveidotUdensSienu() {
		System.out.println(nosaukums + " izveido ūdens sienu!");
	}
	public void izvairities() {
		System.out.println(nosaukums + " izmanto ūdens plūsmu, lai izvairītos no uzbrukuma!");
	}
	public void dziedet(int dziedesana) {
		veseliba += dziedesana + 5; // Ūdens pokemoni saņem papildu dziedināšanu
		System.out.println(nosaukums + " ir dziedināts par " + (dziedesana + 5) + " punktiem! Pašreizējā veselība: " + veseliba);
	}
	public void attistit(int attistibasLimenis) {
		uzbrukums += attistibasLimenis * 6; // Ūdens pokemoni iegūst vidēju uzbrukuma pieaugumu
		System.out.println(nosaukums + " ir attīstījies! Pašreizējais uzbrukuma spēks: " + uzbrukums);
	}
	

}
