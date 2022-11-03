package e1;

public class EquipoHumano {
    private final String nombre;
    private final String apellido;
    private final int DNI;
    private int telefono;
    private final String nacionalidad;
    private final String profesion;

    public EquipoHumano(String nombre, String apellido, int DNI, int telefono, String nacionalidad, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        if (profesion.equals("Guionista") || profesion.equals("Musico") || profesion.equals("Productor") || profesion.equals("Director") || profesion.equals("Interprete") || profesion.equals("Especialista") || profesion.equals("Doblador")) {
            this.profesion = profesion;
        } else throw new IllegalArgumentException("Profesion no valida");
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String nombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getprofesion(){
        return profesion;
    }
}


class EquipoTecnico extends EquipoHumano {
    String profesion;
    boolean guion_original = false, stunt_double = false;

    public EquipoTecnico(String nombre, String apellido, int DNI, int telefono, String nacionalidad, String profesion) {
        super(nombre, apellido, DNI, telefono, nacionalidad, profesion);
        if (profesion.equals("guionista") || profesion.equals("musico") || profesion.equals("productor") || profesion.equals("director"))
            this.profesion = profesion;
        else throw new IllegalArgumentException("Profesion no valida para equipo tecnico");
    }
}

class EquipoArtistico extends EquipoHumano {

    String profesion;
    String rol;

    public EquipoArtistico(String nombre, String apellido, int DNI, int telefono, String nacionalidad, String profesion, String rol) {
        super(nombre, apellido, DNI, telefono, nacionalidad, profesion);
        if (profesion.equals("interprete") || profesion.equals("especialista") || profesion.equals("doblador")) {
            this.profesion = profesion;
            if (profesion.equals("interprete") && (rol.equals("principal") || rol.equals("secundario") || rol.equals("extra")))
                this.rol = rol;
            else this.rol = "\0";
        } else throw new IllegalArgumentException("Profesion no valida para equipo artistico");

    }
}


/*
Equipo técnico {
Guionista: 70€ + 5% derechos autor + 4000 € si el guion original
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
	secundario:
	extra:
Especialista: 40€ (extra de +1000€ si han rodado escenas muy peligrosas)
Dobladores: 20€
}
 */