/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public List<Embauche> lesEmbauches = new ArrayList<Embauche>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel(){
        Optional<Club> employeur = Optional.empty();
        if (!lesEmbauches.isEmpty() && !lesEmbauches.get(lesEmbauches.size() - 1).estTerminee()) {
            employeur = Optional.of(lesEmbauches.get(lesEmbauches.size() - 1).getEmployeur());
        }
        return employeur;
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        Embauche e = new Embauche(debutNouvelle, this, employeur);
        lesEmbauches.add(e);
    }

    public List<Embauche> emplois() {
        return lesEmbauches;
    }

    public void terminerEmbauche(LocalDate fin) throws Exception{
        if(lesEmbauches.isEmpty() || lesEmbauches.get(lesEmbauches.size()-1).estTerminee()){
            throw new Exception("Le moniteur n'a pas d'embauche en cours");
        }
        lesEmbauches.get(lesEmbauches.size() - 1).terminer(fin);
    }

}
