package ar.edu.unq.clase2.empresa.liquidaciones.retenciones;

//Punto 2
public class GastosAdministrativosContractuales extends RetencionSueldo{

	public GastosAdministrativosContractuales() {
		super("Gastos Administrativos Contractuales", 0);
	}

	@Override
	public float getMonto() {
		return 50;
	}

}
