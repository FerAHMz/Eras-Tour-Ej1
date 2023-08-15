/**
 * Clase que representa a un comprador de boletos.
 */
public class Comprador {
    private String nombre;
    private String email;
    private int cantidadDeBoletos;
    private double presupuestoMaximo;

    
    public Comprador(String nombre, String email, int cantidadDeBoletos, double presupuestoMaximo) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadDeBoletos = cantidadDeBoletos;
        this.presupuestoMaximo = presupuestoMaximo;
    }

    
    public boolean validarPresupuesto(double precio) {
        return presupuestoMaximo >= precio * cantidadDeBoletos;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCantidadDeBoletos() {
        return cantidadDeBoletos;
    }

    public void setCantidadDeBoletos(int cantidadDeBoletos) {
        this.cantidadDeBoletos = cantidadDeBoletos;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public void setPresupuestoMaximo(double presupuestoMaximo) {
        this.presupuestoMaximo = presupuestoMaximo;
    }
}
