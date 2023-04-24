import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class Calendrier {
    private List<Periode> periodes;

    public Calendrier() {
        periodes = new ArrayList<Periode>();
    }

    public Tache ajouterTache() throws ParseException {

        String prompt = utility.getInput("Voulez vous que la tache soit simple ou décomposable? (s/d) ");
        String nom = utility.getInput("Donnez le nom de la tache");
        utility.displayMessage("Donnez la priorite de la tache");
        utility.displayEnumMembers(Priorite.class);
        Priorite priorite = utility.getEnumMember(Priorite.class,
                Integer.parseInt(utility.getInput("Donnez la priorite de la tache")));

        Date deadLine = utility.convertStringToDate((utility.getInput("Donnez la deadline de la tache")));
        switch (prompt) {
            case "s":
                TacheSimple tache = new TacheSimple(nom, priorite, deadLine);

                return tache;
            case "d":
                TacheDecompsable t = new TacheDecompsable(nom, priorite, deadLine);

                return t;

            default:
                utility.displayMessage(prompt + " n'est pas une option valide");
                return null;
        }

    }

    // write a method to display the calendar

    public void afficherCalendrier() {

        for (Periode p : periodes) {
            utility.displayMessage(p.toString());
        }

    }

    // write a method to fix periods
    public void fixerPeriodes() throws ParseException {
        String prompt = utility.getInput("Voulez vous fixer une période pour votre planning? (o/n) ");
        // switch statement to handle the user's input
        switch (prompt) {
            case "o":
                // get the start date
                String dateDebut = utility.getInput("Entrez la date de début (jj/mm/aaaa): ");
                // test if it's a valid date (should be in the future)
                // get the current date with Date class
                Date d = new Date();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateDebut);
                if (d.after(date)) {
                    utility.displayMessage("La date doit être dans le futur");
                    return;
                }

                // get the end date
                String dateFin = utility.getInput("Entrez la date de fin (jj/mm/aaaa): ");
                // create a new period
                Periode p = new Periode(dateDebut, dateFin);
                // add the period to the list of periods
                periodes.add(p);
                break;
            case "n":
                utility.displayMessage("Vous avez choisi de ne pas fixer de période");
                break;
            default:
                utility.displayMessage(prompt + " n'est pas une option valide");
                break;
        }

    }

    // write a method to add Creneaux to a period
    public void ajouterCreneau() throws NumberFormatException, ParseException {
        // choisir periode
        Periode p = choisirPeriode();

        // get the start time
        String heureDebut = utility.getInput("Entrez l'heure de début (hh:mm): ");
        // convert from string to date

        // get the end time
        String heureFin = utility.getInput("Entrez l'heure de fin (hh:mm): ");
        // create a new period
        String duree = utility.getInput("Entrez la durée (en minutes): ");
        Creneau c = new Creneau(Integer.parseInt(duree), utility.convertStringToHour(heureDebut),
                utility.convertStringToHour(heureFin));
        // add the period to the list of periods

        p.ajouterCreneau(c);

    }

    // write a method to choose periode
    public Periode choisirPeriode() {
        // display the list of periods
        for (Periode p : periodes) {
            utility.displayMessage(p.toString());
        }
        // get the user's choice
        String choix = utility.getInput("Entrez le numéro de la période que vous voulez choisir: ");
        // get the period from the list
        Periode p = periodes.get(Integer.parseInt(choix) - 1);
        // add the creneau to the period
        return p;
    }

    // write a method to choose creneau

    // write a method to add Tache to a Creneau

    public void planifierTache(Tache t) throws ParseException {
        // choisir periode
        Periode p = choisirPeriode();
        // choisir creneau
        p.afficherCreneaux();
        // get the start time
        String heureDebut = utility.getInput("Entrez l'heure de début (hh:mm): ");
        // convert from string to date

        // get the end time
        String heureFin = utility.getInput("Entrez l'heure de fin (hh:mm): ");
        // create a new period
        String duree = utility.getInput("Entrez la durée (en minutes): ");
        Creneau c = new Creneau(Integer.parseInt(duree), utility.convertStringToHour(heureDebut),
                utility.convertStringToHour(heureFin));
        // add the period to the list of periods
        c.ajouterTache(t);

    }

}
