package e1;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    String titulo;
    float recaudacion;

    List<Object> Lista_Equipo = new ArrayList();

    public void InsertEquipo(Object Integrante) {
        this.Lista_Equipo.add((EquipoHumano) Integrante);
    }


    public Pelicula(String titulo, float recaudacion) {
        this.titulo = titulo;
        this.recaudacion = recaudacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getRecaudacion() {
        return recaudacion;
    }


    public void printSalaries() {
        float suma_salarios = 0;
        int i = 0, size = this.Lista_Equipo.size();
        EquipoHumano aux_h;
        EquipoTecnico aux_t;
        EquipoArtistico aux_a;
        if (!this.Lista_Equipo.isEmpty()) {
            for (; i < size; i++) {
                aux_h = (EquipoHumano) this.Lista_Equipo.get(i);
                System.out.print(aux_h.nombreCompleto() + " (" + aux_h.getprofesion());
                if (aux_h.getprofesion().equals("Especialista")) {
                    aux_t = (EquipoTecnico) aux_h;
                    if (aux_t.stunt_double) System.out.println("con extra por peligro )");
                }
            }
        }
    }
}


/*
Equipo técnico {
Guionista: 70€ + 5% derechos autor + 4000 € si el guion es original
Músico: 60€ + 4% derechos autor
Productor: 90€ + 2% derechos autor
Director: 100€ (+1000€ por año de antigüedad) + 5% derechos autor
}
*Los derechos de autor se calculan sobre la recaudación de la película en taquilla*
 */

/*
Equipo artístico {
Intérprete: 200€
	protagonista: sueldo * 3
	secundario: -
	extra: -
Especialista: 40€ (extra de +1000€ si han rodado escenas muy peligrosas)
Dobladores: 20€
}
 */
