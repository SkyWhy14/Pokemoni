import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class PokeDatnis {

    

    public void sakums() {
    	
        JOptionPane.showMessageDialog(
                null,
                "Laipni lūdzam Pokémonu pasaulē!\nSagatavojies aizraujošām cīņām!",
                "Pokemoni",
                JOptionPane.INFORMATION_MESSAGE
        );

       

        String[] darbibas = {
                "Izveidot jaunu Pokemonu",
                "Atributu aplūkošana",
                "Izsaukt Pokemona metodi",
                "Sākt Pokemona turnīru",
                "Aizvērt programmu"
        };
        String[] metodes = {
                "Cīnities ar citu pokemonu",
                "Dziedēties",
                "Attēstēties",
                "Atpakaļ"
        };

        ArrayList<Pokemons> pokemoni = new ArrayList<>();

        String izvele;

        do {
            izvele = (String) JOptionPane.showInputDialog(
                    null,
                    "Izvēlies darbību:",
                    "Izvēlne",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    darbibas,
                    darbibas[0]
            );

            if (izvele == null)
                break;

            switch (izvele) {

                // ------------------------
                // 1. JAUNA POKEMONA IZVEIDE
                // ------------------------
            case "Izveidot jaunu Pokemonu":
                Pokemons jauns = Metodes.izveidotPokemonu();

                if (jauns != null) {
                    pokemoni.add(jauns);
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                                new File("./audio/pokemon-catch.wav"));

                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Veiksmīgi izveidots pokemons: " + jauns.nosaukums,
                            "Pokemoni",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Pokemona izveide atcelta.",
                            "Pokemoni",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
                break;


                // ------------------------
                // 2. ATRIBUTU PARĀDĪŠANA
                // ------------------------
                //vajag lai piemeram elektiriskie pokemoni butu atseviski no normalajiem 
                case "Atributu aplūkošana":
                   if(pokemoni.isEmpty()) {
					   JOptionPane.showMessageDialog(null, "Nav pieejamu Pokémonu!",
							   "Pokemoni",
							   JOptionPane.WARNING_MESSAGE);
				   } else {
					   Pokemons p = (Pokemons) JOptionPane.showInputDialog(null,
							   "Izvēlies pokemona atribūtus:", "Pokemona Atribūti",
							   JOptionPane.QUESTION_MESSAGE, null, pokemoni.toArray(), pokemoni.get(0));

					   if (p != null) {
						   JTextArea textArea = new JTextArea(p.getAtributi());
						   textArea.setEditable(false);
						   JScrollPane scrollPane = new JScrollPane(textArea);
						   scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
						   scrollPane.setPreferredSize(new java.awt.Dimension(300, 200));

						   JOptionPane.showMessageDialog(null, scrollPane, "Pokemona Atribūti", JOptionPane.INFORMATION_MESSAGE);
					   }
					   break;
				   }
                   break;

                // ------------------------
                // 3. METOŽU IZSAUKŠANA
                // ------------------------
                case "Izsaukt Pokemona metodi":
                    if (pokemoni.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Nav pieejamu Pokémonu!",
                                "Pokemoni",
                                JOptionPane.WARNING_MESSAGE
                        );
                    } else {
                        Pokemons p = (Pokemons) JOptionPane.showInputDialog(null,
                                "Izvēlies pokemona metodi:", "Metodes",
                                JOptionPane.QUESTION_MESSAGE, null, pokemoni.toArray(), pokemoni.get(0));

                        if (p != null) {
                            String metode = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Izvēlies metodi:",
                                    "Metodes izvēle",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    metodes,
                                    metodes[0]
                            );

                            if (metode != null) {
                                switch (metode) {

                                    case "Cinities ar citu pokemonu":
                                        Metodes.CinitiesArCituPokemonu(pokemoni);

                                    case "Cīnities ar citu pokemonu":
                                       Metodes.cinities(p, p);

                                        break;
                                    case "Dziedēties":
                                        Metodes.Dziedeties(p);
                                        break;
                                    case "Attīstīties":
                                        Metodes.AttistitLimeni(p);
                                        break;
                                    case "Atpakaļ":
                                        // Nekas netiek darīts, atgriežas izvēlnē
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(
                                                null,
                                                "Nepareiza metodes izvēle!",
                                                "Pokemoni",
                                                JOptionPane.ERROR_MESSAGE
                                        );
                                }
                            }
                        }
                    }
                    break;

                // ------------------------
                // 4. TURNĪRS
                // ------------------------
                case "Sākt Pokemona turnīru":
                    if (pokemoni.size() < 2) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Nepieciešami vismaz 2 Pokémoni, lai sāktu turnīru!",
                                "Pokemoni",
                                JOptionPane.WARNING_MESSAGE
                        );
                    } else {
                       Metodes.saktTurniru(pokemoni);
                    }
                    break;

                // ------------------------
                // 5. IZEJA
                // ------------------------
                case "Aizvērt programmu":
                    JOptionPane.showMessageDialog(
                            null,
                            "Paldies par spēlēšanu! Uz redzēšanos Pokémonu pasaulē!",
                            "Pokemoni",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    try {
                        File soundFile = new File(".//audio//abra.wav");
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();

                       
                        Thread.sleep(clip.getMicrosecondLength() / 1000);

                        clip.close();
                    } catch (Exception e) {
                      
                        e.printStackTrace();
                    }
                    break;
            }
        }while(!izvele.equals("Aizvērt programmu"));
    }
    
    
    
    public static void main(String[] args) {
    	
    	 try {
             AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                     new File(".//audio//pokemon-go.wav"));
             Clip clip = AudioSystem.getClip();
             clip.open(audioInputStream);
             clip.start(); 

             JFrame frame = new JFrame("Pokémon spēle");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(400, 300);
             frame.setLayout(null); // ļauj izmantot setBounds

             // Ieliek GIF fonā
             ImageIcon img = new ImageIcon(".//images//pokeball-shimmer.gif");
             JLabel background = new JLabel(img);
             background.setBounds(0, 0, 400, 300);
             frame.add(background);

             // Sākuma poga
             JButton startButton = new JButton("Sākt spēli");
             startButton.setBounds(50, 200, 120, 40); // x=50, y=200
             background.add(startButton); // pievieno pogu uz fona

             // Iziet poga
             JButton exitButton = new JButton("Iziet");
             exitButton.setBounds(230, 200, 120, 40); // x=230, y=200
             background.add(exitButton); // pievieno pogu uz fona

             exitButton.addActionListener(e -> System.exit(0));

             startButton.addActionListener(e -> {
                 if (clip != null && clip.isRunning()) clip.stop();  // 🔥 stop music here
                 frame.dispose();
                 PokeDatnis app = new PokeDatnis();
                 app.sakums();
             });

             frame.setLocationRelativeTo(null);
             frame.setVisible(true);
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    	

    }
}
    
    
    
    
    
    























































































































//
    

            
    
