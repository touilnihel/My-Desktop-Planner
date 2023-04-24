import java.text.ParseException;
import java.util.Date;

abstract class Tache {
    private String nom;
    private Priorite priorite;
    private Date deadLine;

    public Tache(String nom, Priorite priorite, Date deadLine) {
        this.nom = nom;
        this.priorite = priorite;
        this.deadLine = deadLine;

    }

    public Tache() {
    }


}

class TacheSimple extends Tache {
    public TacheSimple(String nom, Priorite priorite, Date deadLine) {
        super(nom, priorite, deadLine);
    }

}

class TacheDecompsable extends Tache {
    private TacheSimple tachesDécomposées[];

    public TacheDecompsable(String nom, Priorite priorite, Date deadLine) {
        super(nom, priorite, deadLine);
    }



}