package ar.edu.unq.clase2.empresa;

import java.util.List;

public class LiquidacionDeSueldos {
    private List<ReciboDeHaberes> liquidaciones;

    public LiquidacionDeSueldos(List<ReciboDeHaberes> liquidaciones) {
        this.liquidaciones = liquidaciones;
    }

    public List<ReciboDeHaberes> getRecibosDeSueldo() {
        return this.liquidaciones;
    }
}
