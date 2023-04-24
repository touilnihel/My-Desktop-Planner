import java.text.ParseException;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Calendrier calendrier = new Calendrier();

        calendrier.fixerPeriodes();

        calendrier.afficherCalendrier();
        calendrier.ajouterCreneau();

        calendrier.planifierTache(calendrier.ajouterTache());
    }

}