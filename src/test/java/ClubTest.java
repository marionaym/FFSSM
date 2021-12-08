/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class ClubTest {

    public Plongeur plongeur1, plongeur2;
    public Moniteur mono1, mono2;
    public Club club;
    public Plongee plongee1, plongee2;
    public Site site;

    @BeforeEach
    public void setUp() {
        plongeur1 = new Plongeur("SR30", "ValJean", "Jean", "LesMiserables", "0604287567", LocalDate.of(2000, Month.APRIL, 1), 8);
        plongeur2 = new Plongeur("CA09", "IDonTKnow", "Gavroche", "Amsterdam", "0687235641", LocalDate.of(1997, Month.AUGUST, 6), 2);

        mono1 = new Moniteur("AT90", "Dupeyroux", "Lisa", "Montagne", "0657294164", LocalDate.of(2001, Month.DECEMBER,11),0,0);
        mono2 = new Moniteur("AT91", "Bouaboub", "Wiame", "Toulouse", "0657294165", LocalDate.of(2001, Month.SEPTEMBER,14),0,0);
        
        club = new Club(mono1, "AirClub", "0437829303");

        site = new Site("LesAventures", "FantastiquesDeTintin");

        plongee1 = new Plongee(site, mono1, LocalDate.of(2021, Month.DECEMBER, 8), 400, 3);
        plongee1 = new Plongee(site, mono2, LocalDate.of(2022, Month.JANUARY, 8), 400, 3);
    }

    @Test
    public void testPlongeesNonConformes() {

        plongeur1.ajouterLicence("AZ57", LocalDate.now(), club);
        plongee1.ajouteParticipant(plongeur1);
        club.organisePlongee(plongee1);
        
        plongeur2.ajouterLicence("AZ32", LocalDate.of(2010, Month.APRIL, 8), club);
        plongee2.ajouteParticipant(plongeur2);
        club.organisePlongee(plongee2);

        assertTrue(club.plongeesNonConformes().contains(plongee2));
        assertTrue(!club.plongeesNonConformes().contains(plongee1));
    }
}
