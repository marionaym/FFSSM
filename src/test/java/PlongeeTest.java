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
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
public class PlongeeTest {

    public Plongeur plongeur1, plongeur2;
    public Moniteur mono;
    public Club club;
    public Plongee plongee;
    public Site site;

    @BeforeEach
    public void setUp() {
        plongeur1 = new Plongeur("SR30", "ValJean", "Jean", "LesMiserables", "0604287567", LocalDate.of(2000, Month.APRIL, 1), 8);
        
        mono = new Moniteur("AT90", "Dupeyroux", "Lisa", "Montagne", "0657294164", LocalDate.of(2001, Month.DECEMBER, 11), 0, 0);
        
        club = new Club(mono, "AirClub", "0437829303");

        site = new Site("LesAventures", "FantastiquesDeTintin");

        plongee = new Plongee(site, mono, LocalDate.of(2021, Month.DECEMBER, 8), 400, 3);
    }

    @Test
    public void testEstConforme1() {
        club.organisePlongee(plongee);
        assertFalse(club.lesPlongees.isEmpty(), "Le club a organisé une plongée");
    }

    @Test
    public void tesEstConforme2() {

        plongeur1.ajouterLicence("AT57", LocalDate.now(), club);
        plongee.ajouteParticipant(plongeur1);
        
        assertTrue(plongee.estConforme(), "la plongée est conforme");

    }

}
