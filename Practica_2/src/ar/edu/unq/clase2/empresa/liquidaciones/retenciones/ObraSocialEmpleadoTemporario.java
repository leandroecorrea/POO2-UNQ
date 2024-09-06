package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;

public class ObraSocialEmpleadoTemporario extends DescuentoObraSocial {
    private final int edad;

    public ObraSocialEmpleadoTemporario(float sueldoBruto, int edad) {
        super("temporario", sueldoBruto);
        this.edad = edad;
    }

    @Override
    protected float descuentoEspecial() {
        return (float) edad > 50 ? 255 : 0;
    }
}