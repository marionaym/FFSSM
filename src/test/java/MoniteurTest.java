/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.Moniteur;
import static java.time.Instant.now;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mario
 */
public class MoniteurTest {

    Moniteur mono;
    private Club club;

    @BeforeEach
    public void setUp() {
        mono = new Moniteur("0000", "Valjean", "Jean", "LesMisérables", "0624911057", LocalDate.of(1995, Month.MARCH, 7), 400, 3);
        club = new Club(mono, "club", "02020396802");
    }

    @Test
    public void testEmployeurActuel() {
        mono.nouvelleEmbauche(club, LocalDate.now());
        assertEquals(club, mono.employeurActuel().get(), "Mauvais employeur");
    }

    @Test
    public void testTerminerEmbauche() throws Exception {
        assertThrows(Exception.class, () -> {
            mono.terminerEmbauche(LocalDate.now());
        });
    }
}
