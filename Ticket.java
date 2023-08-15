/**
 * Clase Ticket
 */
public class Ticket {
    private int numeroAleatorio;
    private Localidad localidad; 

    // Constructor
    public Ticket() {
        this.numeroAleatorio = generarNumero();
        this.localidad = null; 
    }

    
    public int generarNumero() {
        return (int) (Math.random() * 15000) + 1;
    }

    
    public boolean validarRango(int a, int b) {
        return numeroAleatorio >= Math.min(a, b) && numeroAleatorio <= Math.max(a, b);
    }

    
    public void asignarLocalidad(Localidad[] localidades) {
        Localidad localidadSeleccionada = localidades[0];
        for (Localidad localidad : localidades) {
            if (localidad.getEspaciosDisponibles() > localidadSeleccionada.getEspaciosDisponibles()) {
                localidadSeleccionada = localidad;
            }
        }
        this.localidad = localidadSeleccionada;
    }

    
    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
