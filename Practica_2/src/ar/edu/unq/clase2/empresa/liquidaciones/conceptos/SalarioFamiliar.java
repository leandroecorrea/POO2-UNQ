package ar.edu.unq.clase2.empresa.liquidaciones.conceptos;

import java.util.Arrays;
import java.util.List;

public class SalarioFamiliar extends ConceptoSueldo {
    private final List<ConceptoSueldo> itemsSalarioFamiliar;

    public SalarioFamiliar(int cantidadDeHijos, boolean tieneConyuge, int totalAnios) {
        super("Salario Familiar");
        this.itemsSalarioFamiliar = Arrays.asList(
            new AsignacionPorHijo(cantidadDeHijos),
            new AsignacionPorConyuge(tieneConyuge),
            new AsignacionPorAntiguedad(totalAnios)
        );
    }

    @Override
    public float getMonto() {
        return (float) itemsSalarioFamiliar.stream().mapToDouble(ConceptoSueldo::getMonto).sum();
    }
}