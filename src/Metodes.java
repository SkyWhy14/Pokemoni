import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Metodes {
	public static void paradiPokemonPasauli() {
		ImageIcon darbinieksGif = new ImageIcon(".//images//pokemon.gif");
		JOptionPane.showMessageDialog(null, "", "Pokemon pasaule", JOptionPane.INFORMATION_MESSAGE, darbinieksGif);
	}
	//pievieno skanu
	public static  void izvaditPokemonGoSkanu() {
		try {
			File f = new File(".//audio//"+"pokemon-go.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
			Clip c = AudioSystem.getClip();
			c.open(ais);
			c.start();
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			
			e.printStackTrace();
		}
		
	}
	//izveido jaunu pokemona objektu izmantojot tos 3 pokemona tipus
//dod iespeju izveidot jaunu pokemonu no 3 tipiem
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
		 String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies pokemona veidu",
					"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
					,pokemonuVeidi, pokemonuVeidi[0]);
			if (izvele == null) return null;
			
			String nosaukums = virknesParbaude("Ievadi pokemona nosaukumu:", "Pikachu");
			if(nosaukums == null) return null;
			int veseliba = SkaitlaParbaude("Ievadi pokemona veselību (1-500):", 1, 500, "100");
			if(veseliba == -1) return null;
			int uzbrukums = SkaitlaParbaude("Ievadi pokemona uzbrukuma spēku (1-100):", 1, 100, "20");
			if(uzbrukums == -1) return null;
			
			switch(izvele) {
			case "Elektriskais Pokemons":
				return new ElectriskaisP(nosaukums, veseliba, uzbrukums, uzbrukums);
			case "Ūdens Pokemons":
				return new UdensP(nosaukums, veseliba, uzbrukums, uzbrukums);
			case "Parasts Pokemons":
				return new Pokemons(nosaukums, veseliba, uzbrukums);
			default:
				return null;
			}
			
		 
		 
	 }
		
	
	
	
		
	
	public static void izsauktPokemonaMetodi() {
		
		
		
		
		
		
		
	}
	public static void saktPokemonaTurniru() {
		
		
		
		
		
		
		
	}
	
	

}
