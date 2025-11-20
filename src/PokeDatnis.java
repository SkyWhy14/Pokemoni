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

        // Fona animācija/skaņa (ja eksistē)
        Metodes.paradiPokemonPasauliArSkanu();

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
                "Attīstīties",
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
                if (pokemoni.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Nav izveidots neviens pokemons.",
                            "Pokemoni", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(
                            null,
                            "Nav pieejamu Pokémonu!",
                            "Pokemoni",
                            JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    StringBuilder info = new StringBuilder();

                    info.append("⚡ Elektiskie Pokemoni:\n");
                    for (Pokemons p : pokemoni) {
                        if (p instanceof ElectriskaisP) {
                            info.append("- ").append(p.nosaukums)
                                .append(" | HP: ").append(p.veseliba).append("/").append(p.maxHp)
                                .append(" | ATK: ").append(p.uzbrukums)
                                .append(" | DEF: ").append(p.defense)
                                .append(" | Special: ").append(p.specialAvailable ? "Pieejams" : "Izmantots")
                                .append("\n");
                        }
                    }

                    info.append("\n💧 Ūdens Pokemoni:\n");
                    for (Pokemons p : pokemoni) {
                        if (p instanceof UdensP) {
                            info.append("- ").append(p.nosaukums)
                                .append(" | HP: ").append(p.veseliba).append("/").append(p.maxHp)
                                .append(" | ATK: ").append(p.uzbrukums)
                                .append(" | DEF: ").append(p.defense)
                                .append(" | Special: ").append(p.specialAvailable ? "Pieejams" : "Izmantots")
                                .append("\n");
                        }
                    }

                    info.append("\n⚪ Parastie Pokemoni:\n");
                    for (Pokemons p : pokemoni) {
                        if (!(p instanceof ElectriskaisP) && !(p instanceof UdensP)) {
                            info.append("- ").append(p.nosaukums)
                                .append(" | HP: ").append(p.veseliba).append("/").append(p.maxHp)
                                .append(" | ATK: ").append(p.uzbrukums)
                                .append(" | DEF: ").append(p.defense)
                                .append(" | Special: ").append(p.specialAvailable ? "Pieejams" : "Izmantots")
                                .append("\n");
                        }
                    }

                    JTextArea textArea = new JTextArea(info.toString());
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));

                    JOptionPane.showMessageDialog(null, scrollPane,
                            "Pokémonu Atribūti", JOptionPane.INFORMATION_MESSAGE);
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
                    String[] metodes1 = {
                        "Cīnities ar citu pokemonu",
                        "Dziedēties",
                        "Attīstīties",
                        "Atpakaļ"
                    };

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
                            case "Cīnities ar citu pokemonu":
                                Metodes.CinitiesArCituPokemonu(pokemoni);
                                break;
                            case "Dziedēties":
                           Metodes.Dziedeties(pokemoni);
                                break;
                            case "Attīstīties":
                                Metodes.AttistitLimeni(pokemoni); 
                                break;
                            case "Atpakaļ":
                              
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
            frame.dispose(); // aizver sākuma logu
            PokeDatnis app = new PokeDatnis();
            app.sakums();  // sāk spēli tikai pēc Start pogas
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
    
    
    
    
    
    
    

            
    
