package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;


public class AportesJubilatoriosEmpleadoPermanente extends AportesJubilatorios {
    public AportesJubilatoriosEmpleadoPermanente(float sueldoBruto) {
        super(sueldoBruto, "permanente");
    }

    @Override
    protected int tasaDescuento() {
        return 15;
    }
}

