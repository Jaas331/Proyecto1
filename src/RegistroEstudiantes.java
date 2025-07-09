import java.util.Scanner;

public class RegistroEstudiantes {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        var salir = false;
        
        do {
        System.out.print("""
                --- Sistema de Registro de Estudiantes ---

                1. Registrar datos de un estudiante
                2. Mostrar datos del estudiante actual
                3. Calcular promedio de notas del estudiante actual
                0. Salir
                
                seleccione la opción que desea realizar: """);
        var opcion = Integer.parseInt(entrada.nextLine());

        switch (opcion) {
            case 1:
                registroEstudiante();
                break;
            case 2:
                datosEstudiantes();
                break;
            case 3:
                promedioEstudiante();
                break;
            case 0:
                salir = true;
                break;
            default:
                System.out.println("Opción incorrecta");
                break;
        }

        System.out.println("\nPrecione ENTER para continuar");
        entrada.nextLine();
        limpiarPantalla();


        
    } while (!salir);
        System.out.println("saliendo del sistema");
        entrada.close();

    }


    // Metodos 

    private static void limpiarPantalla() {
        System.out.println();
    }


    private static void promedioEstudiante() {

    }




    private static void datosEstudiantes() {

    }




    private static void registroEstudiante() {

    }

}
