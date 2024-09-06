package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;

import ar.edu.unq.clase2.empresa.ReciboDeHaberes;

public abstract class ItemLiquidacion {
    private final String descripcion;

    public ItemLiquidacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract float getMonto();

    public String getDescripcion() {
        return descripcion;
    }

    public abstract void aplicarA(ReciboDeHaberes reciboDeSueldo);
}
