import java.text.ParseException;
import java.util.HashMap;

class MyPlanner {
    HashMap<Utilisateur, String> utilisateurs;

    // le constructeur de MyPlanner
    public MyPlanner() {
        this.utilisateurs = new HashMap<Utilisateur, String>();
    }
    
     public boolean signIn(String pseudo, String motDePasse) {
        Utilisateur utilisateur = Utilisateurs.get(pseudo);
        if (utilisateur != null) {
            return utilisateur.authenfication(motDePasse);
        }
        return false;
    }

    public boolean signUp(String pseudo, String motDePasse) {
        if (!Utilisateurs.containsKey(pseudo)) {
            Utilisateur utilisateur = new Utilisateur(pseudo, motDePasse);
            Utilisateurs.put(pseudo, utilisateur);
            return true;
        }
        return false;
    }
}

    // write an authentification method
    public boolean authentification(String pseudo, String motDePasse) {
        for (Utilisateur u : utilisateurs.keySet()) {
            if (u.getPseudo().equals(pseudo) && u.getMotDePasse().equals(motDePasse)) {
                u.setEstConnecte(true);
                return true;
            }
        }
        return false;
    }

    // write a method to add a user
    public void ajouterUtilisateur(Utilisateur u) {
        utilisateurs.put(u, u.getPseudo());
    }

    // write a method to remove a user
    public void supprimerUtilisateur(Utilisateur u) {
        utilisateurs.remove(u);
    }

    // write a method to get the list of users
    public HashMap<Utilisateur, String> getListeUtilisateurs() {
        return utilisateurs;
    }

    // write a method to add a task
    public void ajouterTache(Tache t) throws ParseException {
        for (Utilisateur u : utilisateurs.keySet()) {
            if (u.getEstConnecte()) {
                u.getCalendrier().ajouterTache();
            }
        }
    }

}
