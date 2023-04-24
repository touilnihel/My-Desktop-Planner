import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Creneau {
    private boolean estLibre;
    private List<Tache> taches;
    private Date heureDebut;
    private Date heureFin;

    private int dureMin;

    public Creneau(int dureMin, Date heureDebut, Date heureFin) {
        taches = new ArrayList<Tache>();
        this.dureMin = dureMin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.estLibre = true;
    }

    @Override
    public String toString() {

        return "Creneau " + ((estLibre) ? "est libre" : "n'est pas libre") + ", heureDebut=" + heureDebut
                + ", heureFin=" + heureFin + "]";
    }

    public void ajouterTache(Tache t) {
        if (estLibre) {
            taches.add(t);
            estLibre = false;
        }
    }
}
