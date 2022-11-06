package e1;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    String titulo;
    float recaudacion;

    List<Object> Lista_Equipo = new ArrayList();

    public Pelicula(String titulo, float recaudacion) {
        this.titulo = titulo;
        this.recaudacion = recaudacion;
    }

    public void InsertEquipo(Object Integrante) {
        this.Lista_Equipo.add(Integrante);
    }

    public String getTitulo() {
        return titulo;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public void printSalaries() {
        float extra = 0, salario = 0, suma_salarios = 0;
        int i = 0, size = this.Lista_Equipo.size();
        EquipoHumano aux_h;
        EquipoTecnico aux_t;
        EquipoArtistico aux_a;
        if (!this.Lista_Equipo.isEmpty()) {
            for (; i < size; i++) {
                aux_h = (EquipoHumano) this.Lista_Equipo.get(i);
                System.out.print(aux_h.nombreCompleto() + " (" + aux_h.getprofesion());
                salario = aux_h.Salario_base();
                if (aux_h.getprofesion().equals("Especialista")) {
                    aux_a = (EquipoArtistico) aux_h;
                    if (aux_a.stunt_double) {
                        System.out.println("con extra por peligro )");
                        extra = 1000;
                    }
                } else if (aux_h.getprofesion().equals("Director")) {
                    System.out.print(" ) :");
                    aux_t = (EquipoTecnico) aux_h;
                    extra = 1000 * aux_t.anos_antiguedad;
                } else if (aux_h.getprofesion().equals("Guionista")) {
                    System.out.print(" ) :");
                    aux_t = (EquipoTecnico) aux_h;
                    if (aux_t.guion_original) {
                        System.out.print(",guion original ) :");
                        extra = 4000;
                    }
                } else if (aux_h.getprofesion().equals("Interprete")) {
                    aux_a = (EquipoArtistico) aux_h;
                    System.out.print(aux_a.rol.toLowerCase() + " ) :");
                    if (aux_a.rol.equals("Principal")) {
                        salario *= 3;
                    }
                } else System.out.print(" ) :");
                salario += extra;
                suma_salarios += salario;
                System.out.print(salario + "€");
            }
        }
        System.out.print("El pagamiento total de salarios de " + this.getTitulo() + " es " + suma_salarios + "€");
    }

    public void printRoyalties() {
        int i = 0, size = this.Lista_Equipo.size();
        double royalties = 0;
        EquipoHumano aux_h;
        if (!this.Lista_Equipo.isEmpty()) {
            for (; i < size; i++) {
                aux_h = (EquipoHumano) this.Lista_Equipo.get(i);
                royalties = aux_h.Royalties() * this.getRecaudacion();
                if (royalties != 0) {
                    System.out.print(aux_h.nombreCompleto() + " (" + aux_h.getprofesion() + " ) :" + royalties + "€");
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
