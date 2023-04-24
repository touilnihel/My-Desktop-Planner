import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

class Periode {

    private Date dateDebut;
    private Date dateFin;
    HashMap<Creneau, Boolean> creneaux;

    public Periode(String dateDebut, String dateFin) throws ParseException {
        creneaux = new HashMap<Creneau, Boolean>();
        this.dateDebut = utility.convertStringToDate(dateDebut);
        this.dateFin = utility.convertStringToDate(dateFin);
        utility.isDateInFuture(dateFin);
    }

    public void ajouterCreneau(Creneau c) {
        creneaux.put(c, true); // la valeur est à true si le créneau est libre

    }

    @Override
    public String toString() {
        return "Periode [dateDebut=" + utility.displayDate(dateDebut) + ", dateFin=" + utility.displayDate(dateFin)
                + "]";
    }

    // write a method to display creneaux
    public void afficherCreneaux() {
        for (Creneau c : creneaux.keySet()) {
            utility.displayMessage(c.toString());
        }
    }

}
