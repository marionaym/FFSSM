package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plongeur extends Personne {

    protected int niveau;
    private List<Licence> lesLicences = new ArrayList<Licence>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }

    public void ajouterLicence(String numeroINSEE, LocalDate delivrance, Club club) {
        if (this.numeroINSEE.equals(numeroINSEE)) {
            Licence l = new Licence(this, numeroINSEE, delivrance, club);
            lesLicences.add(l);
        }
    }

    public Licence derniereLicence() {
//        if(lesLicences == null) throws Exception{
//            throw new Exception("Le plongeur n'a pas de licence");
//        }
        Licence l = lesLicences.get(lesLicences.size() - 1);
        return l;
    }
}

