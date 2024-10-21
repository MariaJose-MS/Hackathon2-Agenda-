package Agenda;

import java.util.ArrayList;

// Clase principal para manejar la modificación y listado de contactos en una agenda
public class ModificacionYListado {
    private ArrayList<Contacto> listaContactos; // Lista que almacena los contactos
    private ManejoDeEspacio manejoEspacio; // Objeto para manejar el espacio disponible en la agenda

    // Constructor que inicializa la lista de contactos y el manejo del espacio
    public ModificacionYListado(ManejoDeEspacio manejoEspacio) {
        this.listaContactos = new ArrayList<>(); // Inicializa la lista de contactos
        this.manejoEspacio = manejoEspacio; // Asigna el objeto de manejo de espacio
    }

    // Añadir un contacto sin permitir duplicados
    public String añadirContacto(Contacto nuevoContacto) {
        // Verifica si el contacto ya existe en la lista
        if (existeContacto(nuevoContacto)) {
            return "El contacto ya existe en la agenda. No se puede añadir duplicado."; // Mensaje de error si ya existe
        } else {
            // Verifica si hay espacio disponible para agregar un nuevo contacto
            boolean espacioDisponible = manejoEspacio.agregarContacto(true);
            if (espacioDisponible) {
                listaContactos.add(nuevoContacto); // Añade el contacto a la lista
                return "Contacto añadido: " + nuevoContacto; // Mensaje de éxito
            } else {
                return "La agenda está llena. No se puede añadir más contactos."; // Mensaje de error si no hay espacio
            }
        }
    }

    // Verificar si un contacto ya existe en la lista
    private boolean existeContacto(Contacto contacto) {
        for (Contacto c : listaContactos) {
            // Compara el nombre y apellido de los contactos ignorando mayúsculas y minúsculas
            if (c.getNombre().equalsIgnoreCase(contacto.getNombre()) &&
                    c.getApellido().equalsIgnoreCase(contacto.getApellido())) {
                return true; // Retorna verdadero si el contacto existe
            }
        }
        return false; // Retorna falso si no existe
    }

    // Método para eliminar un contacto de la lista
    public String eliminarContacto(Contacto contactoAEliminar) {
        // Intenta eliminar el contacto de la lista
        if (listaContactos.remove(contactoAEliminar)) {
            manejoEspacio.eliminarContacto(); // Decrementa el espacio disponible
            return "Contacto eliminado: " + contactoAEliminar; // Mensaje de éxito
        } else {
            return "El contacto no se encontró en la agenda."; // Mensaje de error si no se encuentra
        }
    }

    // Metodo para listar todos los contactos en la agenda
    public void listarContactos() {
        // Verifica si la lista está vacía
        if (listaContactos.isEmpty()) {
            System.out.println("La agenda está vacía."); // Mensaje si la agenda no tiene contactos
        } else {
            System.out.println("Lista de contactos:"); // Mensaje inicial para la lista
            for (Contacto contacto : listaContactos) {
                System.out.println(contacto); // Imprime cada contacto
            }
        }
    }

    // Metodo para modificar el teléfono de un contacto existente
    public String modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto contacto : listaContactos) {
            // Busca el contacto por nombre y apellido
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)) {
                contacto.setTelefono(nuevoTelefono); // Actualiza el teléfono
                return "Teléfono actualizado para el contacto: " + nombre + " " + apellido; // Mensaje de éxito
            }
        }
        return "El contacto no se encontró en la agenda."; // Mensaje de error si no se encuentra
    }
}
