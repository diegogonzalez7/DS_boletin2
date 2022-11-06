package e1;

public class EquipoHumano {
    private final String nombre;
    private final String apellido;
    private final int DNI;
    private final String nacionalidad;
    private final String profesion;
    private final Salaries salario_p_h;
    private final int horas_trabajadas;
    private int telefono;

    public EquipoHumano(String nombre, String apellido, int DNI, int telefono, String nacionalidad, String profesion, Salaries salario_p_h, int horas_trabajadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.salario_p_h = salario_p_h;
        this.horas_trabajadas = horas_trabajadas;
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

    public String getprofesion() {
        return profesion;
    }

    public float Salario_base() {
        return this.salario_p_h.getSalario_p_hora() * this.horas_trabajadas;
    }

    public double Royalties(){
        return this.salario_p_h.getRoyalties();
    }
}


class EquipoTecnico extends EquipoHumano {
    boolean guion_original = false;
    int anos_antiguedad = 0;

    public EquipoTecnico(String nombre, String apellido, int DNI, int telefono, String nacionalidad, String profesion, Salaries salario_p_h, int horas_trabajadas, boolean guion_original, int anos_antiguedad) {
        super(nombre, apellido, DNI, telefono, nacionalidad, profesion, salario_p_h, horas_trabajadas);
        this.guion_original = guion_original;
        this.anos_antiguedad = anos_antiguedad;
    }
}

class EquipoArtistico extends EquipoHumano {
    String rol = "\0";
    boolean stunt_double = false;

    public EquipoArtistico(String nombre, String apellido, int DNI, int telefono, String nacionalidad, String profesion, Salaries salario_p_h, int horas_trabajadas, String rol, boolean stunt_double) {
        super(nombre, apellido, DNI, telefono, nacionalidad, profesion, salario_p_h, horas_trabajadas);
        if (profesion.equals("Interprete") && (rol.equals("Principal") || rol.equals("Secundario") || rol.equals("Extra")))
            this.rol = rol;
        this.stunt_double = stunt_double;
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