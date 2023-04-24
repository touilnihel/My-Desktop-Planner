class Utilisateur {
  private String pseudo; 
  private String motDePasse;
  private boolean estConnecte; 
  private Calendrier calendrier; 

public Utilisateur(String pseudo, String motDePasse) {
  this.pseudo = pseudo; 
  this.motDePasse = motDePasse; 
  this.estConnecte = false; 
  this.calendrier = new Calendrier(); 
}

public String getPseudo() {
  
  return this.pseudo;
}

public void setEstConnecte(boolean b) {
}

public String getMotDePasse() {
    return this.motDePasse;
}

public boolean getEstConnecte() {
  return this.estConnecte;
}

public Calendrier getCalendrier() {
    return this.calendrier;
}
}