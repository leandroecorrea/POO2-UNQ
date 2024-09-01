package ar.edu.unq.clase2.empresa.liquidaciones.conceptos;

public class HorasExtra extends ConceptoSueldo {
    private int totalHoras;

    public HorasExtra(int totalHoras) {
        super("Horas extra");
        this.totalHoras = totalHoras;
    }

    @Override
    public float getMonto() {
        return totalHoras * 40;
    }
}