package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;

public class AportesJubilatoriosEmpleadoTemporario extends AportesJubilatorios {
    private final int horasExtra;

    public AportesJubilatoriosEmpleadoTemporario(float sueldoBruto, int horasExtra) {
        super(sueldoBruto, "temporario");
        this.horasExtra = horasExtra;
    }

    @Override
    public float getMonto() {
        return super.getMonto() + horasExtra * 5;
    }

    @Override
    protected int tasaDescuento() {
        return 10;
    }
}