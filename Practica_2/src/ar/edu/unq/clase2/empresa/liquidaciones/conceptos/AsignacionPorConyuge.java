package ar.edu.unq.clase2.empresa.liquidaciones.conceptos;

public class AsignacionPorConyuge extends ConceptoSueldo {
    private final boolean tieneConyuge;

    public AsignacionPorConyuge(boolean tieneConyuge) {
        super("Asignación por conyuge");
        this.tieneConyuge = tieneConyuge;
    }

    @Override
    public float getMonto() {
        return tieneConyuge ? 100 : 0;
    }
}