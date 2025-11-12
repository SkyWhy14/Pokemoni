
public class ElectriskaisP extends Pokemons {
	private int elektroStiprums;

	public ElectriskaisP(String nosaukums, int veseliba, int uzbrukums, int elektroStiprums) {
		super(nosaukums, veseliba, uzbrukums);
		this.elektroStiprums = elektroStiprums;
	}

	@Override
	public void uzbrukt() {
		System.out.println(nosaukums + " izmanto elektrisko uzbrukumu ar stiprumu " + elektroStiprums + "!");
	}
	// Elektriskā pokemona specifiskā metode kad vins stun pretinieku
	public void stunPretinieku() {
		System.out.println(nosaukums + " ir satricinājis pretinieku ar elektrisko šoku!");
	}
	
	public void izvairities() {
		System.out.println(nosaukums + " izmanto elektro aizsardzību, lai izvairītos no uzbrukuma!");
	}
	public void dziedet(int dziedesana) {
		veseliba += dziedesana + 10; // Elektriskie pokemoni saņem papildu dziedināšanu
		System.out.println(nosaukums + " ir dziedināts par " + (dziedesana + 10) + " punktiem! Pašreizējā veselība: " + veseliba);
	}
	public void attistit(int attistibasLimenis) {
		uzbrukums += attistibasLimenis * 7; // Elektriskie pokemoni iegūst lielāku uzbrukuma pieaugumu
		System.out.println(nosaukums + " ir attīstījies! Pašreizējais uzbrukuma spēks: " + uzbrukums);
	}
	
	
	
	

}
