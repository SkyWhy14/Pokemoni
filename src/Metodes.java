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
		
		public static String virknesParbaude(String zinojums, String noklusejums) {
			String virkne;
			do {
				virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
				if(virkne == null)
					return null;
			}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
			return virkne;
		}
			public static Double skaitlaParbaude(String zinojums, double min, double max, String noklusejums) {
				String ievade;
				Double skaitlis;
				while(true) {
					ievade = (String)JOptionPane.showInputDialog(null, zinojums, 
							"Datu ievade", JOptionPane.INFORMATION_MESSAGE, null, null, noklusejums); 
					if(ievade == null)
						return -1.0;
					try {
						skaitlis = Double.parseDouble(ievade);
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
	

}
