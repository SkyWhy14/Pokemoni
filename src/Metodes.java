import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Metodes {
	
	
	public static void paradiPokemonPasauliArSkanu() {
	    try {
	        // Ielādē audio failu
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
	            new File(".//audio//pokemon-go.wav").getAbsoluteFile()
	        );
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start(); // Sāk atskaņot skaņu

	        // Ielādē attēlu (GIF)
	        ImageIcon darbinieksGif = new ImageIcon(".//images//pokemon.gif");

	        // Parāda JOptionPane ar attēlu
	        JOptionPane.showMessageDialog(
	            null,
	            "", // Ziņojuma teksts (tukšs)
	            "Pokemon pasaule", // Loga virsraksts
	            JOptionPane.INFORMATION_MESSAGE,
	            darbinieksGif // Attēls
	        );

	        // Kad logs ir aizvērts (OK nospiests), apstādina skaņu
	        clip.stop();
	        clip.close();

	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}


	
	public static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}
	public static int SkaitlaParbaude(String zinojums, double min, double max, String noklusejums) {
		String ievade;
		int skaitlis;
		while(true) {
			ievade = (String)JOptionPane.showInputDialog(null, zinojums, 
					"Datu ievade", JOptionPane.INFORMATION_MESSAGE, null, null, noklusejums); 
			if(ievade == null)
				return -1;
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis < min || skaitlis > max) {
					JOptionPane.showMessageDialog(null, 
					"Norādīts nederīgs skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
					"Netika ievadīts pareizs skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
			}
		}
		}
	
	public static Pokemons izveidotJaunuPokemonaObjektu(String[] pokemonuVeidi) {
	    String izvele = (String) JOptionPane.showInputDialog(
	        null,
	        "Izvēlies pokemona veidu",
	        "Izvēlne",
	        JOptionPane.QUESTION_MESSAGE,
	        null,
	        pokemonuVeidi,
	        pokemonuVeidi[0]
	    );

	    if (izvele == null) return null;

	    switch (izvele) {
	        case "Elektriskais Pokemons":
	            String nosaukums = virknesParbaude("Ievadi pokemona nosaukumu:", "Pikachu");
	            if (nosaukums == null) return null;
	            int veseliba = SkaitlaParbaude("Ievadi pokemona veselību (1-500):", 1, 500, "100");
	            if (veseliba == -1) return null;
	            int uzbrukums = SkaitlaParbaude("Ievadi pokemona uzbrukuma spēku (1-100):", 1, 100, "20");
	            if (uzbrukums == -1) return null;
	            return new ElectriskaisP(nosaukums, "Elektriskais", veseliba, uzbrukums);

	        case "Ūdens Pokemons":
	            String nosaukums1 = virknesParbaude("Ievadi pokemona nosaukumu:", "Squirtle");
	            if (nosaukums1 == null) return null;
	            int veseliba1 = SkaitlaParbaude("Ievadi pokemona veselību (1-500):", 1, 500, "100");
	            if (veseliba1 == -1) return null;
	            int uzbrukums1 = SkaitlaParbaude("Ievadi pokemona uzbrukuma spēku (1-100):", 1, 100, "20");
	            if (uzbrukums1 == -1) return null;
	            return new UdensP(nosaukums1, "Ūdens", veseliba1, uzbrukums1);

	        case "Parasts Pokemons":
	            String nosaukums2 = virknesParbaude("Ievadi pokemona nosaukumu:", "Eevee");
	            if (nosaukums2 == null) return null;
	            int veseliba2 = SkaitlaParbaude("Ievadi pokemona veselību (1-500):", 1, 500, "100");
	            if (veseliba2 == -1) return null;
	            int uzbrukums2 = SkaitlaParbaude("Ievadi pokemona uzbrukuma spēku (1-100):", 1, 100, "20");
	            if (uzbrukums2 == -1) return null;
	            return new Pokemons(nosaukums2, "Parasts", veseliba2, uzbrukums2);

	        default:
	            return null;
	    }
	}
	

	 //parada ar kadu pokemona var cinities un izmanto JOptionpane lai izveletos ar kadu pokemona cinities
	 //un ir iespeja izvairities no uzbrukuma vai izmantot specialo uzbrukumu un ir iespeja atcelt cinisanos
	//izmanto jau eskistoso pokemoni sarakstu
	public static void CinitiesArCituPokemonu(ArrayList<Pokemons> pokemoni) {
		
		
	}
		 
		 
	 
	 //izveido metodi pokems uzbruk cits pokemona objektam
	 //un atnemt veselibu atkariba no uzbrukuma speka
		public static void cinities(Pokemons pokemons1, Pokemons pokemons2) {
			pokemons2.veseliba -= pokemons1.uzbrukums;
			if(pokemons2.veseliba < 0) pokemons2.veseliba = 0;
			JOptionPane.showMessageDialog(null, pokemons1.nosaukums + " uzbruka " + pokemons2.nosaukums +
					" un atņēma " + pokemons1.uzbrukums + " veselības punktus! " +
					pokemons2.nosaukums + " pašreizējā veselība: " + pokemons2.veseliba,
					"Cīņa", JOptionPane.INFORMATION_MESSAGE);
			
		}
		//ja ir iespeja izsauc specialo uzbrukumu atkariba no pokemona veida (elektiskais,udens)
		public static void izsauktPokemonaSpecialoUzbrukumu(Pokemons pokemons1, Pokemons pokemons2) {
			if(pokemons1 instanceof ElectriskaisP) {
				((ElectriskaisP) pokemons1).paralizetPretinieku();
			}else if(pokemons1 instanceof UdensP) {
				((UdensP) pokemons1).izsmidzinatUdeni(pokemons2);
			}else {
				JOptionPane.showMessageDialog(null, pokemons1.nosaukums + " nav speciāla uzbrukuma.",
						"Speciālais uzbrukums", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
	public static void izvairitiesNoUzbrukuma(Pokemons pokemons1) {
		if(pokemons1 instanceof ElectriskaisP) {
			((ElectriskaisP) pokemons1).izvairities();
		}else if(pokemons1 instanceof UdensP) {
			((UdensP) pokemons1).izvairities();
		}else {
			JOptionPane.showMessageDialog(null, pokemons1.nosaukums + " nevar izvairīties no uzbrukuma.",
					"Izvairīšanās", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
		
	//ar joptionpane izsauc pokemona metodi kur var cinities ar citu pokemona objektu vai dziedinet vai attistit
	public static void izsauktPokemonaMetodi(ArrayList<Pokemons> pokemoni) {
		String izvele;
		String[] metodes = {"Uzbrukt", "Dziedet", "Attistit", "Atcelt"};
		izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies pokemona metodi",
				"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
				,metodes, metodes[0]);
		if(izvele == null || izvele.equals("Atcelt")) return;
		String izvelesID = java.util.Arrays.asList(metodes).indexOf(izvele)+"";
		switch(izvelesID) {
		case "0":
			CinitiesArCituPokemonu(new ArrayList<Pokemons>());
			break;
			case "1":
				//izsauc dziedet metodi
				break;
				case "2":
					//izsauc attistit metodi
					break;
					default:
		}
	}
	public static void saktPokemonaTurniru() {
	
		
	}
	
	

}
