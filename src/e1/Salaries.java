package e1;

public enum Salaries {
    GUIONISTA(70, 0.05), MUSICO(60, 0.04), PRODUCTOR(90, 0.02), DIRECTOR(100, 0.02), INTERPRETE(200, 0), ESPCIALISTA(40, 0), DOBLADOR(20, 0);

    private final float salario_p_hora;
    private final double royalties;

    Salaries(float salario_p_hora, double royalties) {
        this.salario_p_hora = salario_p_hora;
        this.royalties = royalties;
    }

    public float getSalario_p_hora() {
        return salario_p_hora;
    }

    public double getRoyalties() {
        return royalties;
    }
}