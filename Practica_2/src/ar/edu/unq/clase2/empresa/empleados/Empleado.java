package ar.edu.unq.clase2.empresa.empleados;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.ItemLiquidacion;

public abstract class Empleado {
    protected final String nombre;
    protected final String estadoCivil;
    protected final LocalDate fechaDeNacimiento;
    protected float sueldoBasico;

    public Empleado(String nombre, String estadoCivil, LocalDate fechaDeNacimiento, float sueldoBasico) {
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sueldoBasico = sueldoBasico;
    }

    public int edad() {
        return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    }

    public float sueldoBruto() {
        return (float) this.itemsSueldoBruto().stream().mapToDouble(ItemLiquidacion::getMonto).sum();
    }

    public float retencionesAplicadas() {
        return (float) itemsRetenciones().stream().mapToDouble(ItemLiquidacion::getMonto).sum();
    }

    public float sueldoNetoRestante() {
        return sueldoBruto() - retencionesAplicadas();
    }

    public abstract List<ItemLiquidacion> itemsSueldoBruto();
    public abstract List<ItemLiquidacion> itemsRetenciones();

    public String getNombre() {
        return nombre;
    }

    protected boolean tieneConyuge() {
        return this.estadoCivil.equals("casado");
    }
}
