package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;

import ar.edu.unq.clase2.empresa.ReciboDeHaberes;

public abstract class RetencionSueldo extends ItemLiquidacion {
    protected final float sueldoBruto;

    public RetencionSueldo(String descripcion, float sueldoBruto) {
        super(descripcion);
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public void aplicarA(ReciboDeHaberes reciboDeHaberes) {
        reciboDeHaberes.descontar(getMonto());
    }
}