package Agenda;

import java.util.ArrayList;

public class GestionContacto {
    // Lista que almacena los contactos
    private ArrayList<Contacto> contactos;

    // Constructor de la clase que inicializa la lista de contactos
    public GestionContacto() {
        this.contactos = new ArrayList<>();
    }

    // Metodo para agregar un contacto
    public String añadirContacto(Contacto c) {
        // Verificar si el nombre y el apellido del contacto están vacíos
        if (c.getNombre().isEmpty() || c.getApellido().isEmpty()) {
            return "El nombre y el apellido no pueden estar vacíos."; // Mensaje de error si están vacíos
        }
        // Verificar si el contacto ya existe en la agenda
        if (existeContacto(c)) {
            return "El contacto ya existe en la agenda."; // Mensaje de error si el contacto ya existe
        }
        // Agregar el contacto a la lista
        contactos.add(c);
        return "Contacto añadido: " + c.toString(); // Mensaje de confirmación
    }

    // Metodo para verificar si un contacto existe
    public boolean existeContacto(Contacto c) {
        // Retorna true si el contacto está en la lista, de lo contrario false
        return contactos.contains(c);
    }

    // Metodo para listar contactos
    public void listarContactos() {
        // Verificar si la lista de contactos está vacía
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía."); // Mensaje si no hay contactos
            return; // Salir del metodo
        }
        // Ordenar los contactos por nombre y apellido
        contactos.sort((c1, c2) -> { //sort se utiliza para ordenar los elementos de una lista, en este caso, tomando los dos parámentros de contactos
            int cmp = c1.getNombre().compareTo(c2.getNombre()); // Obtenemos los nombre a comparar. Devuelve un número negativo si el primer nombre es menor alfabéticamente que el segundo nombre (c2.getNombre()). Un número positivo si es al contrario.
            return (cmp != 0) ? cmp : c1.getApellido().compareTo(c2.getApellido()); // Si son iguales, comparar apellidos
        });

        // Mostrar cada contacto en la lista
        for (Contacto contacto : contactos) {
            System.out.println(contacto); // Imprimir el contacto
        }
    }

    // Metodo para buscar un contacto por nombre y apellido
    public String buscaContacto(String nombre, String apellido) {
        // Recorre e itera sobre la lista de contactos
        for (Contacto contacto : contactos) {
            // Verificar si el nombre y apellido coinciden
            if (contacto.getNombre().equals(nombre) && contacto.getApellido().equals(apellido)) {
                return "Contacto encontrado: " + contacto.getTelefono(); // Retornar el teléfono si se encuentra el contacto
            }
        }
        return "Contacto no encontrado."; // Mensaje si no se encuentra el contacto
    }

    // Metodo para eliminar un contacto
    public String eliminarContacto(Contacto c) {
        // Intentar eliminar el contacto de la lista
        if (contactos.remove(c)) {
            return "Contacto eliminado: " + c.toString(); // Mensaje de confirmación si se elimina
        } else {
            return "El contacto no existe en la agenda."; // Mensaje de error si el contacto no está en la lista
        }
    }
}
