
enum Priorite {
    HIGH, MEDIUM, LOW
}

enum Categorie {
    STUDIES("Bleu"), WORK("Vert"), HOBBY("Rouge"), SPORT("Violet"), HEALTH("Indigo");

    private String couleur;

    Categorie(String couleur) {
        this.couleur = couleur;
    }
}

enum Etat {
    NotREALIZED, COMPLETED, InPROGRESS, CANCELLED, DELAYED
}

enum Badge {
    GOOD, VeryGood, EXCELLENT
}
