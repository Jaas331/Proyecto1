import java.util.Scanner;
public class RegistroEstudiantes {

    // Variables de clase para guardar los datos del estudiante actual
    static String estudianteActualNombre = "N/A";
    static double estudianteNota1 = 0.0;
    static double estudianteNota2 = 0.0;
    static double estudianteNota3 = 0.0;

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        var salir = false;
        
        do {
        System.out.print("""
                        *** Sistema de Registro de Estudiantes ***
                ===========================================================
                Opciones a realizar
                1. Registrar datos de un estudiante
                2. Mostrar datos del estudiante registrado
                3. Calcular promedio de las notas del estudiante registrado
                0. Salir
                -----------------------------------------------------------
                seleccione la opción que desea realizar: """);
        var opcion = Integer.parseInt(entrada.nextLine());

        switch (opcion) {
            case 1:
                registroEstudiante(entrada);
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

        System.out.println("Precione ENTER para continuar");
        entrada.nextLine();
        limpiarPantalla();


        
    } while (!salir);
        System.out.println("saliendo del sistema");
        entrada.close();

    }


    // Funciones 

    private static void limpiarPantalla() {
        System.out.println();
    }

    public static void registroEstudiante(Scanner entrada) {
        limpiarPantalla();

        String nombre;
        double nota1, nota2, nota3;

        do {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = entrada.nextLine();
            if (!validarNombre(nombre)) {
                System.out.println("Nombre invalido. Intenta de nuevo.");
            }
        } while (!validarNombre(nombre));

        System.out.println("Nombre registrado corectamente: " + nombre);

        do {
            System.out.print("\nIngrese la primera nota: ");
            nota1 = Double.parseDouble(entrada.nextLine());
            if (!validarNota(nota1)) {
                System.out.print("\nNota invalida. Intente nuevamente");
                limpiarPantalla();
            }
        } while (!validarNota(nota1));
        System.out.println("Nota registrada correctamente: " + nota1);

        do {
            System.out.print("\nIngrese la segunda nota: ");
            nota2 = Double.parseDouble(entrada.nextLine());
            if (!validarNota(nota2)) {
            System.out.print("\nNota invalida. Intente nuevamente");
            limpiarPantalla();
            }
        } while (!validarNota(nota2));
        System.out.println("Nota registrada correctamente: " + nota2);

        do {
            System.out.print("\nIngrese la tercera nota: ");
            nota3 = Double.parseDouble(entrada.nextLine());
            if (!validarNota(nota3)) {
                System.out.print("\nNota invalida. Intente nuevamente");
                limpiarPantalla();
            }
        } while (!validarNota(nota3));

      
    estudianteActualNombre = nombre;
    estudianteNota1 = nota1;
    estudianteNota2 = nota2;
    estudianteNota3 = nota3;

        System.out.println("Nota registrada correctamente: " + nota3);
        System.out.println("Datos del estudiante completos");
        limpiarPantalla();
    }

    public static void datosEstudiantes() {
    limpiarPantalla();
    if (estudianteActualNombre.equals("N/A")) {
        System.out.println("Aún no se ha registrado ningún estudiante.");
    } else {
        System.out.println("Datos del estudiante registrado:");
        System.out.println("Nombre: " + estudianteActualNombre);
        System.out.println("Nota 1: " + estudianteNota1);
        System.out.println("Nota 2: " + estudianteNota2);
        System.out.println("Nota 3: " + estudianteNota3);
        limpiarPantalla();
    }
    }


    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 5;
    }

    public static double promedioEstudiante() {
        limpiarPantalla();

        double promedio = (estudianteNota1 + estudianteNota2 + estudianteNota3) / 3;

        if (promedio > 2) {
            System.out.printf("""
            El promedio del estudiante %s es:
            %.2f 
            Felicitaciones, has aprobado.
            """, estudianteActualNombre, promedio);
        } else {
            System.out.printf("""
            El promedio del estudiante %s es:
            %.2f 
            Lo sentimos, has reprobado, lo animamos a que sigas perseverando.
            """, estudianteActualNombre, promedio);
        }
        return promedio;
    }











}
