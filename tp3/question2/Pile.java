package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if (taille <= 0) { /* do nothing */ }
        else {
            zone = new Object[taille];
            ptr = 0;
        }
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
       if (estPleine()) throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
         if (estVide()) throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        return zone[0];
    }

    public int capacite() {
        if (!estVide())
		{
			int ct = 0;
			for (int i=0; i<zone.length; i++){
			   ct++;
			  }
			return ct;
		}
		else return 0;
    }

    public int taille() {
	return ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        return o.equals(zone);
        
    //    for (int i=0; i<zone.length; i++){
    //    if (zone[i] == o[i]) { continue; } 
    //    else { return false; }
    //    }
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(" " + zone[i]);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}