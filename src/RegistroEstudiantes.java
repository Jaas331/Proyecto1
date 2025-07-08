import java.util.Scanner;

public class RegistroEstudiantes {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        
        System.out.print("""
                --- Sistema de Registro de Estudiantes ---

                1. Registrar datos de un estudiante
                2. Mostrar datos del estudiante actual
                3. Calcular promedio de notas del estudiante actual
                0. Salir
                
                seleccione la opción que desea realizar
                """);
        var opcion = Integer.parseInt(entrada.nextLine());

        System.out.println(opcion);



    }

}
