package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//TODO: Hablar con Diego para buscar mas vulnerabilidades

class PeliculaTest {
    Pelicula P1 = new Pelicula("Pulp Fiction", 300000);
    Pelicula P2 = new Pelicula("Alien", 150000);
    Pelicula P3 = new Pelicula("Inside the Labyrinth", -10000);

    EquipoTecnico t1 = new EquipoTecnico("Jose", "Garcia", "27893422S", 981453267, "Española", Salaries.GUIONISTA, 30, false, 3);
    EquipoTecnico t2 = new EquipoTecnico("Luis", "Garcia", "91823422D", 981475967, "Argentina", Salaries.MUSICO, 30, false, 2);

    EquipoTecnico t3 = new EquipoTecnico("Antonio", "Lopez", "19412839W", 617745321, "Española", Salaries.PRODUCTOR, 60, false, 4);
    EquipoTecnico t4 = new EquipoTecnico("Juan", "Rodriguez", "89573922E", 666352413, "Mexicana", Salaries.DIRECTOR, 120, true, 10);

    EquipoArtistico a1 = new EquipoArtistico("Africa", "Da Silva", "70304335M", 656468206, "Brasilena", Salaries.INTERPRETE, 90, "Principal", false);
    EquipoArtistico a2 = new EquipoArtistico("Pedro Luis", "Rincon", "58073100D", 611869372, "Española", Salaries.INTERPRETE, 90, "Secundario", false);
    EquipoArtistico a3 = new EquipoArtistico("Alfredo", "Pascual", "48784848P", 736416453, "Canadiense", Salaries.INTERPRETE, 90, "Extra", false);
    EquipoArtistico a4 = new EquipoArtistico("Antonia", "Salazar", "87206839Q", 660587744, "Cubana", Salaries.ESPECIALISTA, 90, "Rol1", true);
    EquipoArtistico a5 = new EquipoArtistico("Jorge", "Medina", "57087429A", 649779790, "Boliviana", Salaries.ESPECIALISTA, 90, "Rol2", false);
    EquipoArtistico a6 = new EquipoArtistico("Adela", "Olivares", "94624423P", 733232605, "Española", Salaries.DOBLADOR, 90, "Rol3", false);

    @Test
    void ConstructorEH() {
        assertThrows(IllegalArgumentException.class, () -> new EquipoTecnico("Luis", "Garcia", "91823422D", 981475967, "Argentina", Salaries.MUSICO, -30, false, 2));
        assertThrows(IllegalArgumentException.class, () -> new EquipoTecnico("Luis", "Garcia", "91823422D", 981475967, "Argentina", Salaries.MUSICO, 30, false, -2));
        assertNull(a4.getRol());
        assertNull(a5.getRol());
        assertNull(a6.getRol());
    }

    @Test
    void getTitulo() {
        assertEquals(P1.getTitulo(), "Pulp Fiction");
        assertEquals(P2.getTitulo(), "Alien");
        assertEquals(P3.getTitulo(), "Inside the Labyrinth");
    }

    @Test
    void getRecaudacion() {
        assertEquals(P1.getRecaudacion(), 300000);
        assertEquals(P2.getRecaudacion(), 150000);
        assertEquals(P3.getRecaudacion(), -10000);
    }

    @Test
    void print() {
        P1.InsertEquipo(t1);
        P1.InsertEquipo(t2);
        P1.InsertEquipo(t3);
        P1.InsertEquipo(t4);
        P1.InsertEquipo(a1);
        P1.InsertEquipo(a2);
        P1.InsertEquipo(a3);
        P1.InsertEquipo(a4);
        P1.InsertEquipo(a5);
        P1.InsertEquipo(a6);

        P1.printSalaries();
        P1.printRoyalties();

        P2.InsertEquipo(t1);
        P2.InsertEquipo(t2);
        P2.InsertEquipo(t3);
        P2.InsertEquipo(t4);
        P2.InsertEquipo(a1);
        P2.InsertEquipo(a2);
        P2.InsertEquipo(a3);
        P2.InsertEquipo(a4);
        P2.InsertEquipo(a5);
        P2.InsertEquipo(a6);

        P2.printSalaries();
        P2.printRoyalties();

        P3.InsertEquipo(t1);
        P3.InsertEquipo(t2);
        P3.InsertEquipo(t3);
        P3.InsertEquipo(t4);
        P3.InsertEquipo(a1);
        P3.InsertEquipo(a2);
        P3.InsertEquipo(a3);
        P3.InsertEquipo(a4);
        P3.InsertEquipo(a5);
        P3.InsertEquipo(a6);

        P3.printSalaries();
        P3.printRoyalties();
    }

    @Test
    void InsertEquipo() {
        P1.InsertEquipo(t1);
        P1.InsertEquipo(t2);
        P1.InsertEquipo(a1);
        P1.InsertEquipo(a2);
        assertEquals(P1.Lista_Equipo.size(), 4);
        for (int i = 0; i < P1.Lista_Equipo.size(); i++) {
            assertNotNull(P1.Lista_Equipo.get(i));
        }
    }
}