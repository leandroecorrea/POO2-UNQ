package ar.edu.unq.clase2.empresa.empleados;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import ar.edu.unq.clase2.empresa.liquidaciones.conceptos.SueldoBasico;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.GastosAdministrativosContractuales;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.ItemLiquidacion;
//Punto 2
public class EmpleadoContratado extends Empleado {
	private String direccion;
	private String medioDePago;
	private int numeroContrato;

	public EmpleadoContratado(String nombre, String estadoCivil, LocalDate fechaDeNacimiento, float sueldoBasico,
			String direccion, int numeroContrato, String medioDePago) {
		super(nombre, estadoCivil, fechaDeNacimiento, sueldoBasico);
		this.direccion = direccion;
		this.numeroContrato = numeroContrato;
		this.medioDePago = medioDePago;
	}

	@Override
	public List<ItemLiquidacion> itemsSueldoBruto() {
		return Arrays.asList(new SueldoBasico(this.sueldoBasico));
	}

	@Override
	public List<ItemLiquidacion> itemsRetenciones() {
		return Arrays.asList(new GastosAdministrativosContractuales());
	}

}
