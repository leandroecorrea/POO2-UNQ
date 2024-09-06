package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;

public class ObraSocialEmpleadoPermanente extends DescuentoObraSocial {
    private final int cantHijos;

    public ObraSocialEmpleadoPermanente(float sueldoBruto, int cantHijos) {
        super("permanente", sueldoBruto);
        this.cantHijos = cantHijos;
    }

    @Override
    protected float descuentoEspecial() {
        return cantHijos * 20;
    }
}
