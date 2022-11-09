package e1;

public enum Salaries {
    GUIONISTA(70, 0.05,"Guionista"),
    MUSICO(60, 0.04, "Musico"),
    PRODUCTOR(90, 0.02, "Productor"),
    DIRECTOR(100, 0.05, "Director"),
    INTERPRETE(200, 0, "Interprete"),
    ESPECIALISTA(40, 0, "Especialista"),
    DOBLADOR(20, 0, "Doblador");

    private final float salario_p_hora;
    private final double royalties;
    private final String Profesion_name;
    Salaries(float salario_p_hora, double royalties, String Profesion_name) {
        this.salario_p_hora = salario_p_hora;
        this.royalties = royalties;
        this.Profesion_name=Profesion_name;
    }

    public float getSalario_p_hora() {
        return salario_p_hora;
    }

    public double getRoyalties() {
        return royalties;
    }

    public String getProfesion_name() {
        return Profesion_name;
    }
}