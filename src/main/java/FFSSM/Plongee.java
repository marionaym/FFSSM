/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public LocalDate date;

    public int profondeur;

    public int duree;

    private List<Plongeur> lesParticipants = new ArrayList<Plongeur>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        lesParticipants.add(participant);
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Plongeur> getLesParticipants() {
        return lesParticipants;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        boolean ret = false;
        for (Plongeur participant : lesParticipants) {
            if (participant.derniereLicence().estValide(date)) {
                ret = true;
            }
        }
        return ret;
    }

}
