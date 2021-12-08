/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongeur;
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
public class LicenceTest {
    public Plongeur plongeur1, plongeur2;
    public Moniteur mono;
    public Club club;
    public Licence licence1, licence2;

    @BeforeEach
    public void setUp() {
        plongeur1 = new Plongeur("SR30", "ValJean", "Jean", "LesMiserables", "0604287567", LocalDate.of(2000, Month.APRIL, 1), 8);
        plongeur2 = new Plongeur("CA09", "IDonTKnow", "Gavroche", "Amsterdam", "0687235641", LocalDate.of(1997, Month.AUGUST, 6), 2);

        mono = new Moniteur("AT90", "Dupeyroux", "Lisa", "Montagne", "0657294164", LocalDate.of(2001, Month.DECEMBER,11),0,0);
        club = new Club(mono, "AirClub", "0437829303");

        licence1 = new Licence(plongeur1, "TG09", LocalDate.of(2003, Month.FEBRUARY, 8), club);
        licence2 = new Licence(plongeur2, "TG06", LocalDate.of(2021, Month.DECEMBER, 1), club);
    }
    
@Test
    public void testEstValideTrue() {
        assertFalse(licence1.estValide(LocalDate.now()),"La licence est périmée");
    }
    
    @Test
    public void testEstValideFalse() {
        assertTrue(licence2.estValide(LocalDate.now()),"La licence est toujours valide");
    }
}
