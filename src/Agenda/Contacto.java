package Agenda;

// Clase que representa un contacto en la agenda
public class Contacto {
    private String nombre; // Atributo que almacena el nombre del contacto
    private String apellido; // Atributo que almacena el apellido del contacto
    private String telefono; // Atributo que almacena el teléfono del contacto

    // Constructor que inicializa un contacto con nombre, apellido y teléfono
    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre; // Asigna el nombre
        this.apellido = apellido; // Asigna el apellido
        this.telefono = telefono; // Asigna el teléfono
    }

    // Getters y Setters para acceder y modificar los atributos del contacto
    public String getNombre() {
        return nombre; // Retorna el nombre del contacto
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Modifica el nombre del contacto
    }

    public String getApellido() {
        return apellido; // Retorna el apellido del contacto
    }

    public void setApellido(String apellido) {
        this.apellido = apellido; // Modifica el apellido del contacto
    }

    public String getTelefono() {
        return telefono; // Retorna el teléfono del contacto
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono; // Modifica el teléfono del contacto
    }

    // Metodo toString para representar el contacto como una cadena de texto
    @Override
    public String toString() {
        return "Contacto: " + nombre + " " + apellido + ", Teléfono: " + telefono; // Formato de salida del contacto
    }

    //Implementación de un metodo heredado de una clase padre, para usarla más tarde
    // Metodo equals para comparar si dos contactos son iguales basado en nombre y apellido
    @Override
    public boolean equals(Object obj) {
        // Compara la referencia del objeto para la igualdad
        if (this == obj) {
            return true; // Son el mismo objeto
        }
        // Verifica si el objeto es nulo o de una clase diferente
        if (obj == null || getClass() != obj.getClass()) {
            return false; // No son iguales
        }
        // Cast del objeto a Contacto para comparar sus atributos
        Contacto contacto = (Contacto) obj;
        // Compara nombre y apellido ignorando mayúsculas y minúsculas
        return nombre.equalsIgnoreCase(contacto.nombre) && apellido.equalsIgnoreCase(contacto.apellido);
    }
}
