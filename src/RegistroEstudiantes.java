import java.util.Scanner;

// clase de registro de estudiantes
public class RegistroEstudiantes {

    // Variables de clase globales para guardar los datos del estudiante actual
    static String estudianteActualNombre = "N/A";
    static double estudianteNota1 = 0.0;
    static double estudianteNota2 = 0.0;
    static double estudianteNota3 = 0.0;

    //metodo mail que es el cliente
    public static void main(String[] args) {

        //Creacion de la entrada por consola
        Scanner entrada = new Scanner(System.in);
        // Variable inicializada para el ciclo do-while
        var salir = false;
        
        //ciclo do-while que comienza con el do, presentando el menu de acciones a realizar
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
        var opcion = Integer.parseInt(entrada.nextLine());      // captura la opcion ingresada

        //Bucle switch, su entrada a evaluar es la opcion ingresada por el usuario, su caso apunta a un metodo
        switch (opcion) {
            case 1:
                registroEstudiante(entrada);  //el parametro es la entrada, ya que pedira los datos por consola 
                break;          // sale del bucle 
            case 2:
                datosEstudiantes();
                break;
            case 3:
                promedioEstudiante();
                break;
            case 0:
                salir = true;  //Indicando que el usuario desea salir del programa
                break;
            default:
                System.out.println("Opción incorrecta");
                break;
        }

        System.out.println("Precione ENTER para continuar");   //Siempre mostrara esta opcion para el usuario, incluso si da la opcion salir 
        entrada.nextLine();
        limpiarPantalla();          // Es una funcion que hace un salto de lineas


        // finaliza el ciclo do-while con el while negando su argumento para que pueda finalizar el ciclo 
    } while (!salir);
        System.out.println("saliendo del sistema");
        entrada.close();  // cierra el Scanner

    }


    // Funciones 

    private static void limpiarPantalla() { // esta funcion hace un salto de linea 
        System.out.println();
    }


    public static void registroEstudiante(Scanner entrada) { // esta funcion registra al estudiante y no retorna datos
        limpiarPantalla();

        //Declaracion de variables locales de la funcion
        String nombre;
        double nota1, nota2, nota3;

        //Se inicia nuevamente un ciclo donde valida el ingreso el nombre del estudiante
        do {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = entrada.nextLine();
            if (!validarNombre(nombre)) {                   //Funcion de validacion y condicional
                System.out.println("Nombre invalido. Intenta de nuevo.");
            }
        } while (!validarNombre(nombre)); // nuevamente se niega para salir del ciclo e imprime registro correcto

        System.out.println("Nombre registrado corectamente: " + nombre);

        // se inician ciclos para validar el ingreso de las notas 
        do {
            System.out.print("\nIngrese la primera nota: ");
            nota1 = Double.parseDouble(entrada.nextLine());
            if (!validarNota(nota1)) {  // condicional if y su argumento es una funcion que su parametro es una de las variables locales
                System.out.print("\nNota invalida. Intente nuevamente"); //como la funcion esta negada, sale este mensaje
                limpiarPantalla();
            }
        } while (!validarNota(nota1));  // se niega funcion pasa salir del ciclo y validar el ingreso de la nota
        System.out.println("Nota registrada correctamente: " + nota1);

        // se repite los validadores y los ingresos de las otras notas
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

      // se transfiere los valores a las variables globales 
    estudianteActualNombre = nombre;
    estudianteNota1 = nota1;
    estudianteNota2 = nota2;
    estudianteNota3 = nota3;

        // Finaliza la funcion mostrando los mensajes del registro exitoso
        System.out.println("Nota registrada correctamente: " + nota3);
        System.out.println("Datos del estudiante completos");
        limpiarPantalla();
    }

    public static void datosEstudiantes() { // Funcion de los datos ingresados del estudiante, no retorna datos
    limpiarPantalla();
    if (estudianteActualNombre.equals("N/A")) { //condicional que compara cadanas en su argumento
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


    public static boolean validarNombre(String nombre) { //Funcion de validacion de ingreso del nombre del estudiante, retorna un boolean
        return nombre != null && !nombre.trim().isEmpty(); //el parametro es nombre aunque no necesariamente se deba llamar asi
    }  //el operador de conjuncion valida que se cumpla. isEmpty() retorna un verdadero si la variable String esta vacia, por eso se niega en caso que si contenga un nombre

    public static boolean validarNota(double nota) { //Funcion que valida el ingreso de las notas. retorna un boolean
        return nota >= 0 && nota <= 5; // si la nota esta en el rango de 0 a 5 se valida la nota con un true
    }

    public static double promedioEstudiante() { //Funcion del promedio de las notas del estudiante. retorna un double
        limpiarPantalla();

        //calcula el promedio, primero realiza la suma en los parentesis que es la maxima precedencia de operadores
        // luego la cantidad de notas (que es 3) se divide por esa cantidad
        double promedio = (estudianteNota1 + estudianteNota2 + estudianteNota3) / 3;

        if (promedio > 2) { //Hacemos un bucle que indique el resultado de su promedio
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
        return promedio; // finalizamos retornando la variable que contiene el promedio en un double
    }
}
