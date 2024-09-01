package ar.edu.unq.clase2.empresa;
import java.time.LocalDate;
import java.time.LocalDateTime;
import ar.edu.unq.clase2.empresa.empleados.*;

public class Main {
    public static void main(String[] args) {
        Empleado ricardo = new EmpleadoPlantaPermanente(
            "Ricardo",
            "casado",
            LocalDate.of(1999, 10, 10),
            100000,
            1,
            3
        );

        Empleado ruben = new EmpleadoPlantaTemporaria(
            "Ruben",
            "soltero",
            LocalDate.of(1978, 1, 1),
            110000,
            LocalDateTime.now().plusDays(19),
            25
        );
        
        Empleado jose = new EmpleadoContratado(
        		"Jose",
        		"soltero",
        		LocalDate.of(1978, 1, 1),
        		100000,
        		"Siempreviva 123",
        		123,
        		"cheque"
        		);

        Empresa cocaCola = new Empresa("Coca Cola", "11-13456767-05");

        cocaCola.agregarEmpleado(ruben);
        cocaCola.agregarEmpleado(ricardo);
        cocaCola.agregarEmpleado(jose);
        LiquidacionDeSueldos liquidaciones = cocaCola.liquidarSueldos();

        for (ReciboDeHaberes reciboDeSueldo : liquidaciones.getRecibosDeSueldo()) {
            System.out.println("Liquidacion para empleado: " + reciboDeSueldo.getNombreEmpleado());
            System.out.println("Fecha de emision: " + reciboDeSueldo.getFechaEmision());
            for (String item : reciboDeSueldo.desgloseDeConceptos()) {
                System.out.println(item);
            }
            System.out.println("Sueldo bruto: " + reciboDeSueldo.getSueldoBruto());
            System.out.println("Descuentos: - " + reciboDeSueldo.getDescuentos());
            System.out.println("Sueldo neto: " + reciboDeSueldo.getSueldoNeto());
        }
    }
}


