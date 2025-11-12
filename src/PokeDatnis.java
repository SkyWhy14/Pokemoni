import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

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
		
		String izvele;
		
		
		String [] pokemonuVeidi = {"Elektriskais Pokemons", "Ūdens Pokemons", "Parasts Pokemons"};
		String[] darbibas = {"Izveidot jaunu pokemonu", 
				 "Aplūkot pokemonus",
				"Izsaukt pokemona metodi",
				"Sākt pokemona turnīru", "Aizvērt programmu"};
		
		ArrayList<Pokemons> pokemoni = new ArrayList<>();
		ArrayList<Pokemons> turniraPokemoni = new ArrayList<>();
		
		String izvelesID;
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību",
					"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
					,darbibas, darbibas[0]);
			if(izvele == null) break;
			izvelesID = java.util.Arrays.asList(darbibas).indexOf(izvele)+"";
			switch(izvelesID) {
			
			case "0":
				Pokemons jaunsPokemons = Metodes.izveidotJaunuPokemonaObjektu(pokemonuVeidi);
				if(jaunsPokemons != null) {
					pokemoni.add(jaunsPokemons);
					JOptionPane.showMessageDialog(null, "Veiksmīgi izveidots pokemons: " + jaunsPokemons.nosaukums,
							"Pokemoni", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Pokemona izveide atcelta",
								"Pokemoni", JOptionPane.INFORMATION_MESSAGE);
						
					}
				break;
				//izvada pokemona sarakstu ar scrollable text area
			case "1":
			 if(pokemoni.size() == 0) {
					JOptionPane.showMessageDialog(null, "Nav izveidots neviens pokemons, ko aplūkot.",
							"Pokemoni", JOptionPane.INFORMATION_MESSAGE);
				} else {
					StringBuilder pokemoniInfo = new StringBuilder();
					pokemoniInfo.append("Elektiskais pokemons:\n");
					for(Pokemons p : pokemoni) {
						if(p instanceof ElectriskaisP) {
							pokemoniInfo.append("- ").append(p.nosaukums).append("\n");
						}
					}
					pokemoniInfo.append("\nŪdens pokemons:\n");
					for(Pokemons p : pokemoni) {
						if(p instanceof UdensP) {
							pokemoniInfo.append("- ").append(p.nosaukums).append("\n");
						}
					}
					pokemoniInfo.append("\nParasts pokemons:\n");
					for(Pokemons p : pokemoni) {
						if(!(p instanceof ElectriskaisP) && !(p instanceof UdensP)) {
							pokemoniInfo.append("- ").append(p.nosaukums).append("\n");
						}
					}
					JTextArea textArea = new JTextArea(pokemoniInfo.toString());
					textArea.setEditable(false);
					JScrollPane scrollPane = new JScrollPane(textArea);
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
					JOptionPane.showMessageDialog(null, scrollPane, "Visu pokemonu saraksts",
							JOptionPane.INFORMATION_MESSAGE);
				}
			break;
			case "2":
			//	Metodes.izsauktPokemonaMetodi(pokemoni);
				break;
			case "3":
			//	Metodes.saktPokemonaTurniru(pokemoni, turniraPokemoni);
				break;
			}
			
			
			
		}while(izvele != null && !izvele.equals("Aizvērt programmu"));
		JOptionPane.showMessageDialog(null, "Paldies par spēlēšanu! Uz redzēšanos Pokemon pasaulē!",
				"Pokemoni", JOptionPane.INFORMATION_MESSAGE);
		
	}
		

}
