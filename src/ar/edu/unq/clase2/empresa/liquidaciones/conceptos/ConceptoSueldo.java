package ar.edu.unq.clase2.empresa.liquidaciones.conceptos;

import ar.edu.unq.clase2.empresa.ReciboDeHaberes;
import ar.edu.unq.clase2.empresa.liquidaciones.retenciones.ItemLiquidacion;

public abstract class ConceptoSueldo extends ItemLiquidacion {
    public ConceptoSueldo(String descripcion) {
        super(descripcion);
    }

    @Override
    public void aplicarA(ReciboDeHaberes reciboDeHaberes) {
        reciboDeHaberes.sumar(getMonto());
    }
}