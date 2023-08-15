import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Localidad localidad1 = new Localidad("Localidad 1", 100);
        Localidad localidad5 = new Localidad("Localidad 5", 500);
        Localidad localidad10 = new Localidad("Localidad 10", 1000);
        Localidad[] localidades = {localidad1, localidad5, localidad10};
        Comprador comprador = null;

        int opcion = 0;
        while (opcion != 6) {
            System.out.println("Menú:");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese nombre: ");
                String nombre = scanner.next();
                System.out.print("Ingrese email: ");
                String email = scanner.next();
                System.out.print("Ingrese cantidad de boletos: ");
                int cantidad = scanner.nextInt();
                System.out.print("Ingrese presupuesto máximo: ");
                double presupuesto = scanner.nextDouble();
                comprador = new Comprador(nombre, email, cantidad, presupuesto);
                System.out.println("Nuevo comprador creado exitosamente.");
            } else if (opcion == 2) {
                if (comprador != null) {
                    Ticket ticket = new Ticket();
                    int a = ticket.generarNumero();
                    int b = ticket.generarNumero();
                    int ticketNumero = ticket.generarNumero();
                    if (ticketNumero >= Math.min(a, b) && ticketNumero <= Math.max(a, b)) {
                        ticket.asignarLocalidad(localidades);
                        Localidad localidadSeleccionada = ticket.getLocalidad();
                        if (localidadSeleccionada.validarEspacio()) {
                            int boletosDisponibles = localidadSeleccionada.validarDisponibilidad(comprador.getCantidadDeBoletos());
                            if (boletosDisponibles > 0 && comprador.validarPresupuesto(localidadSeleccionada.getPrecio() * boletosDisponibles)) {
                                localidadSeleccionada.comprarBoletos(boletosDisponibles);
                                System.out.println("Compra exitosa de " + boletosDisponibles + " boletos en " + localidadSeleccionada.getNombre());
                            } else {
                                System.out.println("Compra fallida. No hay suficientes boletos disponibles o el presupuesto es insuficiente.");
                            }
                        } else {
                            System.out.println("Compra fallida. No hay espacio en la localidad seleccionada.");
                        }
                    } else {
                        System.out.println("Compra fallida. El ticket no está dentro del rango generado.");
                    }
                } else {
                    System.out.println("Primero debe crear un comprador.");
                }
            } else if (opcion == 3) {
                for (Localidad localidad : localidades) {
                    System.out.println(localidad.getNombre() + ": " + (20 - localidad.getEspaciosDisponibles()) + " vendidos, " + localidad.getEspaciosDisponibles() + " disponibles.");
                }
            } else if (opcion == 4) {
                System.out.print("Defina una localidad (1, 5, 10): ");
                int seleccion = scanner.nextInt();
                Localidad localidadElegida = null;
                switch (seleccion) {
                    case 1:
                        localidadElegida = localidad1;
                        break;
                    case 5:
                        localidadElegida = localidad5;
                        break;
                    case 10:
                        localidadElegida = localidad10;
                        break;
                    default:
                        System.out.println("Localidad no válida.");
                        break;
                }
                if (localidadElegida != null) {
                    System.out.println(localidadElegida.getNombre() + ": " + localidadElegida.getEspaciosDisponibles() + " disponibles.");
                }
            } else if (opcion == 5) {
                double totalCaja = 0;
                for (Localidad localidad : localidades) {
                    totalCaja += (20 - localidad.getEspaciosDisponibles()) * localidad.getPrecio();
                }
                System.out.println("Total generado: $" + totalCaja);
            } else if (opcion == 6) {
                System.out.println("Saliendo del programa.");
                break; 
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}