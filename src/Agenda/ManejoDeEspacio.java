package Agenda;

// Clase que maneja el espacio de la agenda, incluyendo el tamaño máximo y el espacio ocupado
public class ManejoDeEspacio {
    private int maxEspacio; // Tamaño máximo de la agenda
    private int espacioOcupado; // Espacio actualmente ocupado en la agenda

    // Constructor por defecto que establece un tamaño de agenda de 10
    public ManejoDeEspacio() {
        this.maxEspacio = 10; // Tamaño por defecto de la agenda
        this.espacioOcupado = 0; // Inicializa el espacio ocupado en 0
    }

    // Constructor que permite al usuario definir el tamaño de la agenda (10 o 20)
    public ManejoDeEspacio(int maxEspacio) {
        // Valida el tamaño ingresado y lo establece; de lo contrario, asigna 10 por defecto
        if (maxEspacio == 10 || maxEspacio == 20) {
            this.maxEspacio = maxEspacio;
        } else {
            this.maxEspacio = 10; // Tamaño por defecto si se ingresa un valor incorrecto
        }
        this.espacioOcupado = 0; // Inicializa el espacio ocupado en 0
    }

    // Metodo para agregar un contacto solo si hay espacio disponible
    public boolean agregarContacto(boolean esContactoNuevo) {
        // Verifica si es un contacto nuevo y si hay espacio disponible en la agenda
        if (esContactoNuevo && espacioOcupado < maxEspacio) {
            espacioOcupado++; // Aumenta el contador de espacio ocupado
            System.out.println("Contacto agregado. Espacio ocupado: " + espacioOcupado);
            return true; // Retorna verdadero indicando que se agregó el contacto
        }
        return false; // Retorna falso si no se puede agregar el contacto
    }

    // Metodo para eliminar un contacto y liberar espacio
    public void eliminarContacto() {
        // Verifica si hay contactos ocupando espacio
        if (espacioOcupado > 0) {
            espacioOcupado--; // Disminuye el contador de espacio ocupado
            System.out.println("Contacto eliminado. Espacio ocupado: " + espacioOcupado);
        }
    }

    // Metodo para verificar el espacio libre en la agenda
    public int espacioLibre() {
        return maxEspacio - espacioOcupado; // Retorna el espacio libre disponible
    }
}
