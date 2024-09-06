package ar.edu.unq.clase2.empresa.liquidaciones.conceptos;

public class AsignacionPorHijo extends ConceptoSueldo {
    private final int cantidadDeHijos;
    private final float montoPorHijo;

    public AsignacionPorHijo(int cantidadDeHijos) {
        super("Asignación por hijo");
        this.cantidadDeHijos = cantidadDeHijos;
        this.montoPorHijo = 150;
    }

    @Override
    public float getMonto() {
        return cantidadDeHijos * montoPorHijo;
    }
}