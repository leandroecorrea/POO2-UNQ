package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;

public abstract class DescuentoObraSocial extends RetencionSueldo {
	protected DescuentoObraSocial(String tipoEmpleado, float sueldoBruto) {
		super("Obra social empleado " + tipoEmpleado, sueldoBruto);
	}

	protected float descuentoBase() {
		return (float) (sueldoBruto * 0.1);
	}

	protected abstract float descuentoEspecial();

	@Override
	public float getMonto() {
		return descuentoBase() + descuentoEspecial();
	}
}