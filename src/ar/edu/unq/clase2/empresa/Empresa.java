package ar.edu.unq.clase2.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import ar.edu.unq.clase2.empresa.empleados.Empleado;

public class Empresa {
	private final String nombre;
	private final String cuit;
	private final List<Empleado> empleados;

	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.empleados = new ArrayList<>();
	}

	public LiquidacionDeSueldos liquidarSueldos() {
		return new LiquidacionDeSueldos(empleados.stream().map(ReciboDeHaberes::calcular).collect(Collectors.toList()));
	}

	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}

	public String getNombre() {
		return nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public float totalSueldosNetos() {
		return acumular(empleado -> empleado.sueldoNetoRestante());
	}
	
	public float totalSueldosBrutos() {
		return acumular(empleado -> empleado.sueldoBruto());
	}
	
	public float totalRetenciones() {
		return acumular(empleado -> empleado.retencionesAplicadas());
	}
	
	private float acumular(ToDoubleFunction<Empleado> selectorMonto) {
		return (float) empleados.stream().mapToDouble(selectorMonto).sum();
	}
}
