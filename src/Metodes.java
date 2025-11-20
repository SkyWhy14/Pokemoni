import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Metodes {
	    
    public static void paradiPokemonPasauliArSkanu() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File(".//audio//pokemon-go.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            ImageIcon img = new ImageIcon(".//images//pokemon.gif");

            JOptionPane.showMessageDialog(null, "", "Pokemon pasaule",
                    JOptionPane.INFORMATION_MESSAGE, img);

            clip.stop();
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String virknesParbaude(String zinojums, String noklusejums) {
        String virkne;
        do {
            virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
            if (virkne == null) return null;
        } while (!Pattern.matches("^[\\p{L} .'-]{1,40}$", virkne));
        return virkne;
    }

    public static int SkaitlaParbaude(String zinojums, String noklusejums, int max, int min) {
        while (true) {
            String ievade = JOptionPane.showInputDialog(zinojums, noklusejums);
            if (ievade == null) return -1;
            try {
                int sk = Integer.parseInt(ievade);
                if (sk < min || sk > max)
                    JOptionPane.showMessageDialog(null,
                            "Skaitlim jābūt no " + min + " līdz " + max);
                else return sk;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ievadi skaitli!");
            }
        }
    }

    // IZVEIDO POKEMONU AR BASIC VĒRTĪBĀM
    public static Pokemons izveidotPokemonu() {

        ArrayList<String> tipi = new ArrayList<>();
        tipi.add("Elektriskais");
        tipi.add("Ūdens");
        tipi.add("Parastais");

        String nosaukums = virknesParbaude("Ievadi Pokemona nosaukumu:", "Pikachu");
        if (nosaukums == null || nosaukums.isEmpty()) return null;

        String tips = (String) JOptionPane.showInputDialog(
                null,
                "Izvēlies Pokemona tipu:",
                "Pokemona tips",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipi.toArray(new String[0]),
                tipi.get(0)
        );
        if (tips == null) return null;

        Pokemons p = switch (tips) {
            case "Elektriskais" -> new ElectriskaisP(
                    nosaukums,
                    Pokemons.BASIC_HP,
                    Pokemons.BASIC_ATTACK,
                    Pokemons.BASIC_DEFENSE
            );
            case "Ūdens" -> new UdensP(
                    nosaukums,
                    Pokemons.BASIC_HP,
                    Pokemons.BASIC_ATTACK,
                    Pokemons.BASIC_DEFENSE
            );
            case "Parastais" -> new NormalaisPokemons(
                    nosaukums,
                    Pokemons.BASIC_HP,
                    Pokemons.BASIC_ATTACK,
                    Pokemons.BASIC_DEFENSE
            );
            default -> null;
        };

        return p;
    }

    

    private static void doAction(Pokemons actor, Pokemons target, String act) {
        switch (act) {
        case "Uzbrukt":

            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                        new File("./audio/abra.wav"));

                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

            } catch (Exception e) {
                e.printStackTrace();
            }

            target.takeDamage(actor.basicAttack());
            break;
            
            case "Speciālais":
                actor.specialAttack(target);
                break;
            case "Aizsardzība +":
                actor.boostDefense(3);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Nezināma darbība.");
        }
    }

    public static void Dziedeties(Pokemons p) {
        int healAmount = SkaitlaParbaude(
                "Cik HP atgūt (1–" + (p.getMaxHp() - p.getVeseliba()) + ")?",
                "10", p.getMaxHp() - p.getVeseliba(), 1
        );
        if (healAmount != -1) {
        	
        	try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                        new File("./audio/pokemon-heal.wav"));

                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        	
        	p.heal(healAmount);
        }
    }

    public static void AttistitLimeni(Pokemons p) {
    	
        int healAmount = p.getMaxHp() - p.getVeseliba();
        p.heal(healAmount);
        p.uzbrukums += 5;
        p.defense += 2;
        p.limenis += 1;
        p.veseliba+= 10;

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File("./audio/pokemon-evolve.wav"));

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(null,
        		
                p.getNosaukums() + " līmenis paaugstināts!\n"
                        + "HP pilns.\n"
                        + "Uzbrukums +5\n"
                        + "Aizsardzība +2");
    }
    public static void cinities(Pokemons p1, Pokemons p2) {
        while (p1.isAlive() && p2.isAlive()) {
            String[] actions = {"Uzbrukt", "Speciālais", "Aizsardzība +", "Beigt cīņu"};
            String act = (String) JOptionPane.showInputDialog(null,
                    p1.getNosaukums() + " (" + p1.getTips() + ") VS " +
                    p2.getNosaukums() + " (" + p2.getTips() + ")\nIzvēlies gājienu:",
                    "Cīņa", JOptionPane.QUESTION_MESSAGE,
                    null, actions, actions[0]);

            if (act == null || act.equals("Beigt cīņu")) return;

            doAction(p1, p2, act);

            if (!p2.isAlive()) break;

            // Pretinieka gājiens (vienkāršs AI)
            double r = Math.random();
            if (p2.isSpecialAvailable() && r < 0.3)
                doAction(p2, p1, "Speciālais");
            else
                doAction(p2, p1, "Uzbrukt");
        }
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File("./audio/pokemon-catch.wav"));

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,
                "Uzvarētājs: " + (p1.isAlive() ? p1.getNosaukums() : p2.getNosaukums()));
    }

    public static void saktTurniru(ArrayList<Pokemons> pokemoni) {
        // Validācijas pārbaudes
        if (pokemoni.size() < 2) {
            JOptionPane.showMessageDialog(null, "Turnīram nepieciešami vismaz 2 pokemoni!");
            return;
        } else if (pokemoni.size() % 2 != 0) {
            JOptionPane.showMessageDialog(null, "Turnīram nepieciešams pāra skaits pokemonu!");
            return;
        } else if (pokemoni.size() > 8) {
            JOptionPane.showMessageDialog(null, "Turnīram var piedalīties ne vairāk kā 8 pokemoni!");
            return;
        }

        JOptionPane.showMessageDialog(null, "Turnīrs sākas! Kopā " + pokemoni.size() + " pokemoni.");

        // Cīņu pāri
        for (int i = 0; i < pokemoni.size(); i += 2) {
            Pokemons p1 = pokemoni.get(i);
            Pokemons p2 = pokemoni.get(i + 1);
            
            ImageIcon img = new ImageIcon(".//images//pokemon-img.gif");
            String pairInfo = "Cīņa starp:\n" +
                              p1.getNosaukums() + " (" + p1.getTips() + ") VS " +
                              p2.getNosaukums() + " (" + p2.getTips() + ")";
            
            
            
            JOptionPane.showMessageDialog(null, pairInfo, "Turnīra Cīņa", JOptionPane.INFORMATION_MESSAGE);

            // Lietotājs cīnās ar pirmajiem pokemoniem
           cinities(p1, p2); // Šeit tiek izmantota Tava interaktīvā cīņas metode
        }

        JOptionPane.showMessageDialog(null, "Turnīrs ir noslēdzies!");
    }


	
	
}
	
