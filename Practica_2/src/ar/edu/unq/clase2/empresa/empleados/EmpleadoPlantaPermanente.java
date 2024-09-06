package ar.edu.unq.clase2.empresa.empleados;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import ar.edu.unq.clase2.empresa.liquidaciones.conceptos.SalarioFamiliar;
import ar.edu.unq.clase2.empresa.liquidaciones.conceptos.SueldoBasico;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.AportesJubilatoriosEmpleadoPermanente;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.ItemLiquidacion;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.ObraSocialEmpleadoPermanente;

public class EmpleadoPlantaPermanente extends Empleado {
	private int cantidadDeHijos;
	private int antiguedad;

	public EmpleadoPlantaPermanente(String nombre, String estadoCivil, LocalDate fechaDeNacimiento, float sueldoBasico,
			int cantidadDeHijos, int antiguedad) {
		super(nombre, estadoCivil, fechaDeNacimiento, sueldoBasico);
		this.cantidadDeHijos = cantidadDeHijos;
		this.antiguedad = antiguedad;
	}

	@Override
	public List<ItemLiquidacion> itemsRetenciones() {
		return Arrays.asList(new ObraSocialEmpleadoPermanente(super.sueldoBruto(), edad()),
						new AportesJubilatoriosEmpleadoPermanente(super.sueldoBruto()));
	}

	@Override
	public List<ItemLiquidacion> itemsSueldoBruto() {
		return Arrays.asList(new SueldoBasico(sueldoBasico),
				new SalarioFamiliar(cantidadDeHijos, super.tieneConyuge(), antiguedad));
	}
}