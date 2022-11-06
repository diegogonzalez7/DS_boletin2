package e1;

public class EquipoHumano {
    private final String nombre;
    private final String apellido;
    private final String DNI;
    private final String nacionalidad;
    private final String profesion;
    private final Salaries Sal_roy_Prof;
    private final int horas_trabajadas;
    private int telefono;

    public EquipoHumano(String nombre, String apellido, String DNI, int telefono, String nacionalidad, Salaries Sal_roy_Prof, int horas_trabajadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.Sal_roy_Prof = Sal_roy_Prof;
        if (horas_trabajadas > 0) this.horas_trabajadas = horas_trabajadas;
        else throw new IllegalArgumentException("Error:Numero de hora trabajadas invalido");
        this.profesion = Sal_roy_Prof.getProfesion_name();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
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
        return this.Sal_roy_Prof.getSalario_p_hora() * this.horas_trabajadas;
    }

    public double Royalties() {
        return this.Sal_roy_Prof.getRoyalties();
    }
}


class EquipoTecnico extends EquipoHumano {
    private final boolean guion_original;
    private final int anos_antiguedad;

    public boolean isGuion_original() {
        return guion_original;
    }

    public int getAnos_antiguedad() {
        return anos_antiguedad;
    }

    public EquipoTecnico(String nombre, String apellido, String DNI, int telefono, String nacionalidad, Salaries Sal_roy_Prof, int horas_trabajadas, boolean guion_original, int anos_antiguedad) {
        super(nombre, apellido, DNI, telefono, nacionalidad, Sal_roy_Prof, horas_trabajadas);
        this.guion_original = guion_original;
        if (anos_antiguedad > 0) this.anos_antiguedad = anos_antiguedad;
        else throw new IllegalArgumentException("Error: Numero de anos de antiguedad invalido");
    }
}

class EquipoArtistico extends EquipoHumano {
    private final String rol;
    private final boolean stunt_double;

    public EquipoArtistico(String nombre, String apellido, String DNI, int telefono, String nacionalidad, Salaries Sal_roy_Prof, int horas_trabajadas, String rol, boolean stunt_double) {
        super(nombre, apellido, DNI, telefono, nacionalidad, Sal_roy_Prof, horas_trabajadas);
        if (Sal_roy_Prof.getProfesion_name().equals("Interprete") && (rol.equals("Principal") || rol.equals("Secundario") || rol.equals("Extra")))
            this.rol = rol;
        else this.rol = null;
        this.stunt_double = stunt_double;
    }

    public boolean isStunt_double() {
        return stunt_double;
    }

    public String getRol() {
        return rol;
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