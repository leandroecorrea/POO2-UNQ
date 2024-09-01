package ar.edu.unq.clase2.empresa.liquidaciones.conceptos;

public class SueldoBasico extends ConceptoSueldo {
    private final float monto;

    public SueldoBasico(float monto) {
        super("Sueldo basico");
        this.monto = monto;
    }

    @Override
    public float getMonto() {
        return monto;
    }
}