package ar.edu.unq.clase2.empresa.empleados;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import ar.edu.unq.clase2.empresa.liquidaciones.conceptos.HorasExtra;
import ar.edu.unq.clase2.empresa.liquidaciones.conceptos.SueldoBasico;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.AportesJubilatoriosEmpleadoTemporario;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.ItemLiquidacion;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.ObraSocialEmpleadoTemporario;

public class EmpleadoPlantaTemporaria extends Empleado {
    private final LocalDateTime finDeDesignacion;
    private final int cantidadHorasExtra;

    public EmpleadoPlantaTemporaria(String nombre, String estadoCivil, LocalDate fechaDeNacimiento, float sueldoBasico, LocalDateTime finDeDesignacion, int cantidadHorasExtra) {
        super(nombre, estadoCivil, fechaDeNacimiento, sueldoBasico);
        this.finDeDesignacion = finDeDesignacion;
        this.cantidadHorasExtra = cantidadHorasExtra;
    }

    @Override
    public List<ItemLiquidacion> itemsRetenciones() {
        return Arrays.asList(
            new ObraSocialEmpleadoTemporario(sueldoBruto(), edad()),
            new AportesJubilatoriosEmpleadoTemporario(sueldoBruto(), cantidadHorasExtra)
        );
    }

    @Override
    public List<ItemLiquidacion> itemsSueldoBruto() {
        return Arrays.asList(
            new SueldoBasico(sueldoBasico),
            new HorasExtra(cantidadHorasExtra)
        );
    }
}