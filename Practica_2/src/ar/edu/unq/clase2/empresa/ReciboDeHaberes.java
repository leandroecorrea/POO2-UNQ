package ar.edu.unq.clase2.empresa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.edu.unq.clase2.empresa.empleados.Empleado;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.ItemLiquidacion;

public class ReciboDeHaberes {
    private final Empleado empleado;
    private final String direccion;
    private final LocalDateTime fechaEmision;
    private final List<ItemLiquidacion> retenciones;
    private final List<ItemLiquidacion> conceptosSueldoBruto;
    private float montoBruto = 0;
    private float descuentos = 0;

    private ReciboDeHaberes(Empleado empleado, String direccion) {
        this.empleado = empleado;
        this.direccion = direccion;
        this.fechaEmision = LocalDateTime.now();
        this.retenciones = empleado.itemsRetenciones();
        this.conceptosSueldoBruto = empleado.itemsSueldoBruto();
    }

    public String getNombreEmpleado() {
        return this.empleado.getNombre();
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public List<String> desgloseDeConceptos() {
        return Stream.concat(
                conceptosSueldoBruto.stream().map(x -> x.getDescripcion() + ": " + x.getMonto()),
                retenciones.stream().map(x -> x.getDescripcion() + ": - " + x.getMonto())
        ).collect(Collectors.toList());
    }

    public static ReciboDeHaberes calcular(Empleado empleado) {
        ReciboDeHaberes liquidacion = new ReciboDeHaberes(empleado, "direccion");
        liquidacion.calcularMontos();
        return liquidacion;
    }

    public float getSueldoBruto() {
        return montoBruto;
    }

    public float getDescuentos() {
        return descuentos;
    }

    public float getSueldoNeto() {
        return montoBruto - descuentos;
    }

    public void sumar(float monto) {
        montoBruto += monto;
    }

    public void descontar(float monto) {
        descuentos += monto;
    }    

    private void calcularMontos() {
        for (ItemLiquidacion item : itemsLiquidacion()) {
            item.aplicarA(this);
        }
    }

    private List<ItemLiquidacion> itemsLiquidacion() {    	
        List<ItemLiquidacion> items = new ArrayList<>();
        items.addAll(conceptosSueldoBruto);
        items.addAll(retenciones);
        return items;
    }
}


