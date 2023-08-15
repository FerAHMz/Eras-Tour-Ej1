/**
 * Clase que representa una localidad en el teatro
 */
public class Localidad {
    private String nombre;
    private double precio;
    private int espaciosDisponibles;

    
    public Localidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.espaciosDisponibles = 20; 
    }

    
    public boolean validarEspacio() {
        return espaciosDisponibles > 0;
    }

    
    public int validarDisponibilidad(int cantidadDeseada) {
        if (cantidadDeseada <= espaciosDisponibles) {
            return cantidadDeseada;
        } else {
            return espaciosDisponibles;
        }
    }

    
    public void comprarBoletos(int cantidad) {
        espaciosDisponibles -= cantidad;
    }

    
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getEspaciosDisponibles() {
        return espaciosDisponibles;
    }

    public void setEspaciosDisponibles(int espaciosDisponibles) {
        this.espaciosDisponibles = espaciosDisponibles;
    }
}
