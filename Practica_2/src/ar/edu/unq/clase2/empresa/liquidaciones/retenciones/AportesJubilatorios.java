package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;

public abstract class AportesJubilatorios extends RetencionSueldo {

	public AportesJubilatorios(float sueldoBruto, String tipoEmpleado) {
		super("Aportes jubilatorios empleado " + tipoEmpleado, sueldoBruto);
	}

	@Override
	public float getMonto() {
		return sueldoBruto * (tasaDescuento() / 100.0f);
	}

	protected abstract int tasaDescuento();
}