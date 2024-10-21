package Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int tamañoAgenda;

        // Solicitar el tamaño de la agenda al usuario y validar la entrada
        while (true) {
            // Solicitar al usuario que ingrese el tamaño de la agenda
            System.out.println("Ingrese el tamaño de la agenda (10 o 20): ");
            tamañoAgenda = scanner.nextInt(); // Leer el tamaño ingresado
            scanner.nextLine(); // Limpiar el buffer para evitar problemas con la entrada posterior

            // Verificar si el tamaño ingresado es válido
            if (tamañoAgenda == 10 || tamañoAgenda == 20) {
                // Si es válido, mostrar un mensaje y salir del bucle
                System.out.println("Tamaño de la agenda establecido a " + tamañoAgenda + ".");
                break; // Salir del bucle si la entrada es válida
            } else {
                // Si no es válido, mostrar un mensaje de error
                System.out.println("Entrada no válida. Por favor, ingrese 10 o 20.");
            }
        }

        // Crear una instancia de ManejoDeEspacio con el tamaño especificado por el usuario
        ManejoDeEspacio manejoEspacio = new ManejoDeEspacio(tamañoAgenda);
        // Crear una instancia de ModificacionYListado, pasando manejoEspacio al constructor
        ModificacionYListado listaContactos = new ModificacionYListado(manejoEspacio);

        // Bucle principal del menú de la agenda
        while (true) {
            // Mostrar las opciones disponibles en la agenda
            System.out.println("\n--- Agenda ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Ver espacio libre");
            System.out.println("4. Listar contactos");
            System.out.println("5. Modificar teléfono de contacto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt(); // Leer la opción seleccionada por el usuario
            scanner.nextLine(); // Limpiar el buffer

            // Ejecutar la acción correspondiente según la opción seleccionada
            switch (opcion) {
                case 1: // Añadir contacto
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine(); // Leer el nombre del contacto
                    System.out.print("Ingrese el apellido del contacto: ");
                    String apellido = scanner.nextLine(); // Leer el apellido del contacto
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine(); // Leer el teléfono del contacto

                    // Crear una instancia de Contacto y añadirlo a la lista
                    Contacto contacto = new Contacto(nombre, apellido, telefono);
                    String resultado = listaContactos.añadirContacto(contacto); // Intentar añadir el contacto
                    System.out.println(resultado); // Mostrar el resultado de la operación
                    break;

                case 2: // Eliminar contacto
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine(); // Leer el nombre del contacto a eliminar
                    System.out.print("Ingrese el apellido del contacto a eliminar: ");
                    String apellidoEliminar = scanner.nextLine(); // Leer el apellido del contacto a eliminar
                    // Crear una instancia de Contacto para eliminar
                    Contacto contactoAEliminar = new Contacto(nombreEliminar, apellidoEliminar, null);
                    String resultadoEliminacion = listaContactos.eliminarContacto(contactoAEliminar); // Intentar eliminar el contacto
                    System.out.println(resultadoEliminacion); // Mostrar el resultado de la operación
                    break;

                case 3: // Ver espacio libre
                    // Mostrar la cantidad de espacio libre en la agenda
                    System.out.println("Espacio libre en la agenda: " + manejoEspacio.espacioLibre());
                    break;

                case 4: // Listar contactos
                    // Listar todos los contactos en la agenda
                    listaContactos.listarContactos();
                    break;

                case 5: // Modificar teléfono de contacto
                    System.out.print("Ingrese el nombre del contacto a modificar: ");
                    String nombreModif = scanner.nextLine(); // Leer el nombre del contacto a modificar
                    System.out.print("Ingrese el apellido del contacto a modificar: ");
                    String apellidoModif = scanner.nextLine(); // Leer el apellido del contacto a modificar
                    System.out.print("Ingrese el nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine(); // Leer el nuevo teléfono
                    // Modificar el teléfono del contacto y mostrar el resultado
                    System.out.println(listaContactos.modificarTelefono(nombreModif, apellidoModif, nuevoTelefono));
                    break;

                case 6: // Salir
                    System.out.println("Saliendo de la agenda..."); // Mensaje de salida
                    scanner.close(); // Cerrar el escáner para liberar recursos
                    return; // Salir del programa

                default: // Opción no válida
                    // Mostrar un mensaje de error si la opción no es válida
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
