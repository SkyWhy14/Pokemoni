import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PokeDatnis {
//izstradat objektiorientu programmas risinajumu par temu "Pokemoni".Prasibas ir noetikts ka programma satur vismaz 4 klases ja vajag var pievienot vel,Pokemons,ElektriskaisP,UdensP un PokeDatnis
	//Klase Pokedatnis satur programmas main dalu no tas veic jaunu pokemonu izveidi,atributu aplukosanu metozu izsauksanu cinas uzsaksanu,tiek nodrosinatas darbibas ar jebkura tipa pokemona objektiem .
	//Pokemons ir abstrakta bāzes klase, savukārt klases Elektriskais un UdensP ir apakšklases, kuras interpretē jebkuram Pokemonam raksturīgās metodes.
	//Programmai ir jāatbilst sekojošām prasībām: 
	// klasēs ieviesti vismaz 4 atribūti un 4 metodes (vismaz viena no bāzes klases metodēm ir abstrakta)
	//Pokemons ir abstrakta klase un strādājot ar apakškalsēm, tiek ievēroti polimorfisma pamatprincipi
	//tiek nodrošināta funkcionalitāte jauna Pokemona (ElektriskaisP, UdensP) izveidei un uzglabāšanai
	//tiek nodrošināta iespēja izsaukt metodes izvēlētajam pokemona objektam (uzbrukt, izvairīties, dziedēt, attīstīt, utml.)
	//ieviesta funkcionalitāte pokemonu turnīra rīkošanai, nodrošinot iespēju tiem savā starpā sacensties
	//maksimāli novērsta nekorektu datu ievade un iespējamie kļūdu gadījumi.
	//Kā papildus pluss tiks uzskatīta lietotāja grafiskā interfeisa izveide (formas, pogas, skaņas u.tml).
	
	public static void main(String[] args) {
		PokeDatnis pokeDatnis = new PokeDatnis();
		pokeDatnis.sakums();
		
		
		
		
		
	}
	
	public void sakums() {
		//Pievieno grafisko interfeisu ar sveiciena ziņojumu
		JOptionPane.showMessageDialog(null, "Laipni lūdzam Pokemoni pasaulē! Sagatavojieties aizraujošiem piedzīvojumiem un cīņām!",
				"Pokemoni", JOptionPane.INFORMATION_MESSAGE);
		//Pievieno gif ar pokemona tēmu
		Metodes.izvaditPokemonGoSkanu();
		Metodes.paradiPokemonPasauli();
		
		
		
		//Izveido Pokemonu objektus
		ElectriskaisP pikachu = new ElectriskaisP("Pikachu", 100, 50, 20);
		UdensP squirtle = new UdensP("Squirtle", 120, 40, 15);
		Pokemons charmander = new Pokemons("Charmander", 90, 60) {
			@Override
			public void uzbrukt() {
				System.out.println(nosaukums + " izmanto uguns uzbrukumu!");
			}
		};
		
		String izvele;
		izvele = JOptionPane.showInputDialog(null,
				"Izvēlieties pokemona veidu:\n1. Elektriskais Pokemon (Pikachu)\n2. Ūdens Pokemon (Squirtle)\n3. Uguns Pokemon (Charmander)",
				"Pokemona izvēle", JOptionPane.QUESTION_MESSAGE);
		switch (izvele) {
		case "1":
			pikachu.uzbrukt();
			pikachu.stunPretinieku();
			pikachu.izvairities();
			pikachu.dziedet(20);
			pikachu.attistit(2);
			break;
			case "2":
				squirtle.uzbrukt();
				squirtle.izveidotUdensSienu();
				squirtle.izvairities();
				squirtle.dziedet(15);
				squirtle.attistit(3);
				break;
				case "3":
					charmander.uzbrukt();
					charmander.izvairities();
					charmander.dziedet(10);
					charmander.attistit(1);
					break;
					default:
						JOptionPane.showMessageDialog(null, "Nederīga izvēle! Lūdzu, izvēlieties pareizu pokemona veidu.",
								"Kļūda", JOptionPane.ERROR_MESSAGE);
						break;
						
		}
		
	
		
	
		
		
		
		
	}
		

}
