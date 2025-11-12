import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class PokeDatnis {

    public static void main(String[] args) {
        new PokeDatnis().sakums();
    }
    

    public void sakums() {
        // Sveiciens
        JOptionPane.showMessageDialog(null,
                "Laipni lūdzam Pokémonu pasaulē!\nSagatavojies aizraujošām cīņām!",
                "Pokemoni", JOptionPane.INFORMATION_MESSAGE);

        // Parāda Pokémonu pasauli ar skaņu (ja metode eksistē)
        Metodes.paradiPokemonPasauliArSkanu();

        // Izvēlņu saraksti
        String[] pokemonuVeidi = {"Elektriskais Pokemons", "Ūdens Pokemons", "Parasts Pokemons"};
        String[] darbibas = {
                "Izveidot jaunu Pokemonu",
                "Aplūkot Pokemonus",
                "Izsaukt Pokemona metodi",
                "Sākt Pokemona turnīru",
                "Aizvērt programmu"
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

            if (izvele == null) break;

            switch (izvele) {
                case "Izveidot jaunu Pokemonu":
                    Pokemons jauns = Metodes.izveidotJaunuPokemonaObjektu(pokemonuVeidi);
                    if (jauns != null) {
                        pokemoni.add(jauns);
                        JOptionPane.showMessageDialog(null,
                                "Veiksmīgi izveidots pokemons: " + jauns.nosaukums,
                                "Pokemoni", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Pokemona izveide atcelta.",
                                "Pokemoni", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case "Aplūkot Pokemonus":
                    if (pokemoni.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Nav izveidots neviens pokemons.",
                                "Pokemoni", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        StringBuilder info = new StringBuilder();
                        info.append("Elektiskie Pokemoni:\n");
                        for (Pokemons p : pokemoni)
                            if (p instanceof ElectriskaisP)
                                info.append("- ").append(p.nosaukums).append("\n");

                        info.append("\nŪdens Pokemoni:\n");
                        for (Pokemons p : pokemoni)
                            if (p instanceof UdensP)
                                info.append("- ").append(p.nosaukums).append("\n");

                        info.append("\nParastie Pokemoni:\n");
                        for (Pokemons p : pokemoni)
                            if (!(p instanceof ElectriskaisP) && !(p instanceof UdensP))
                                info.append("- ").append(p.nosaukums).append("\n");

                        JTextArea textArea = new JTextArea(info.toString());
                        textArea.setEditable(false);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));

                        JOptionPane.showMessageDialog(null, scrollPane,
                                "Visu Pokémonu saraksts", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case "Izsaukt Pokemona metodi":
                    if (pokemoni.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nav pieejamu Pokémonu!",
                                "Pokemoni", JOptionPane.WARNING_MESSAGE);
                    } else {
                      Metodes.izsauktPokemonaMetodi(pokemoni);
                    }
                    break;

                case "Sākt Pokemona turnīru":
                    if (pokemoni.size() < 2) {
                        JOptionPane.showMessageDialog(null,
                                "Nepieciešami vismaz 2 Pokémoni, lai sāktu turnīru!",
                                "Pokemoni", JOptionPane.WARNING_MESSAGE);
                    } else {
                     //   Metodes.saktPokemonaTurniru(pokemoni);
                    }
                    break;

                case "Aizvērt programmu":
                    JOptionPane.showMessageDialog(null,
                            "Paldies par spēlēšanu! Uz redzēšanos Pokémonu pasaulē!",
                            "Pokemoni", JOptionPane.INFORMATION_MESSAGE);
                    return;
            }
            
        } while (true);
    }
}
