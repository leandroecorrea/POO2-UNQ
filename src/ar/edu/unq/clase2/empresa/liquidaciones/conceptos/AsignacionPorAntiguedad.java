package ar.edu.unq.clase2.empresa.liquidaciones.conceptos;

public class AsignacionPorAntiguedad extends ConceptoSueldo {
    private final int totalAnios;

    public AsignacionPorAntiguedad(int totalAnios) {
        super("Asignacion por antiguedad");
        this.totalAnios = totalAnios;
    }

    @Override
    public float getMonto() {
        return totalAnios * 50;
    }
}