package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        stk = new Stack<T>();
        capacite = taille;
    }

    public Pile2(){
        stk = new Stack<T>();
        capacite = 0;
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine()) throw new PilePleineException();
        stk.push(o);
        this.capacite++;
    }

    public T depiler() throws PileVideException{
          if (estVide()) throw new PileVideException();
          this.capacite--;
          return stk.pop();
    }

    public T sommet() throws PileVideException{
        return null;
    }

    public int capacite() {
        if (!estVide())
		{
			int ct = 0;
			for (int i=0; i<stk.size(); i++){
			   ct++;
			  }
			return ct;
		}
		else return 0;
    }

    public int taille() {
	return capacite;
    }

    public boolean estVide() {
        return capacite == 0;
    }

    public boolean estPleine() {
        return capacite == stk.size();
    }

    public boolean equals(Object o) {
        return o.equals(stk);
        
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
        for (int i = capacite - 1; i >= 0; i--) {
            sb.append(" " + stk.get(i));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
} // Pile2