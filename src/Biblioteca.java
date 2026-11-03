import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteca {

    public static boolean prestar(Libro libro) {
        if (libro.getDisponible() == true) {
            libro.setDisponible(false);
            libro.setVecesPrestado(libro.getVecesPrestado()+1);
            return true;
        }
        return false;

    }

    public static void devolver(Libro libro) {
        libro.setDisponible(true);

    }

    public static Scanner sc = new Scanner(System.in);

    public static void mostrarTodos(Libro libro, Libro libro2, Libro libro3) {
        libro.mostrarInfo();
        System.out.println("======================");
        libro2.mostrarInfo();
        System.out.println("======================");
        libro3.mostrarInfo();
    }

    public static Libro elegirLibro(int num, Libro libro, Libro libro2, Libro libro3) {
        if (num == 1)
            return libro;
        else if (num == 2)
            return libro2;
        else
            return libro3;
    }

    public static int lecturaSegura(String frase) {
        boolean repetir;
        int respuesta = 0;
        do {
            repetir = false;
            try {
                System.out.print(frase);
                respuesta = sc.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
                sc.next();
                repetir = true;
            }

        } while (repetir == true);
        return respuesta;
    }
    public static Libro libroMasPrestado(Libro libro, Libro libro2, Libro libro3){
        if (libro.getVecesPrestado() >= libro2.getVecesPrestado()){
            if( libro.getVecesPrestado() > libro3.getVecesPrestado()){
                return libro;
            }else return libro3;
        }else{
            if(libro2.getVecesPrestado()>=libro3.getVecesPrestado()){
                return libro2;
            }else return libro3;
        }
    }
    public static void main(String[] args) {
        Libro libro1 = new Libro("Extranjero", "Camus", 1967);
        Libro libro2 = new Libro("Noches Blancas", "Dovtoiseki", 1910);
        Libro libro3 = new Libro("Tokyo BLues", "Haruki Murakami", 1990);

        Socio socio1 = new Socio("Javier", 0, 67);
        Socio socio2 = new Socio("David", 1, 68);

        boolean accedio;

        System.out.printf("Socios\n===========\n");
        System.out.printf("%s - %d\n%s - %d\n",socio1.getNombre(), socio1.getNumeroSocio(), socio2.getNombre(), socio2.getNumeroSocio());
        System.out.print("Introduce número de socio: ");
        int respuesta = lecturaSegura("");

        while (respuesta != socio1.getNumeroSocio() && respuesta != socio2.getNumeroSocio()) {
            respuesta = lecturaSegura("Este socio no existe intentalo de nuevo: ");
        }

        //una vez tengo socio miro contras
        Socio socioActual; 
        if (respuesta == socio1.getNumeroSocio()) {
            socioActual = socio1 ; // esto se le pregunté a la IA porque me parecia raro hacer un menu para socio 1 y para socio 2 por separado

        } else {
            socioActual = socio2;
        }

        respuesta = lecturaSegura("Contraseña: ");
        accedio = socioActual.comprobarContrasenia(respuesta);

        if (accedio == false) {

            for (int i = 1; i <= 2; i++) {

                System.out.println("Contraseña incorrecta. Te quedan " + (i + 1) + " intentos");
                respuesta = lecturaSegura("Contraseña");
                accedio = socioActual.comprobarContrasenia(i);

                if (accedio == true) {
                    i = 4;
                }

            }
        }

        // si no has accedio ya es que has perdio los intentos
        if (accedio == false ){
            System.out.println("No quedan más intentos");

        
            // si accedio, pues siguiente paso
        }else {
            System.out.println("Bienvenido "+ socioActual.getNombre());
            // menú en do while hasta que el usuario elija salir, y el 5 , 6 ,7 , 8 ,9 
            int opcion ; 
            int elijeLibro;
            Libro eleccion;
            boolean repetir = true ; 
            while (repetir) {
                System.out.println("----------------");
                System.out.println("1. Ver todos los libros");
                System.out.println("2. Pedir un libr");
                System.out.println("3. Devolver un libro");
                System.out.println("4. Ver mis datos de socio");
                System.out.println("5. Salir ");
                opcion = lecturaSegura("Elija una opción: ");
                switch (opcion) {
                    case 1:
                        mostrarTodos(libro1, libro2, libro3);
                        break;
                    case 2:
                        mostrarTodos(libro1, libro2, libro3);
                        
                        do {
                            elijeLibro = lecturaSegura("Que libro quieres");
                        } while (elijeLibro < 1 && elijeLibro > 3 );

                        eleccion = elegirLibro(elijeLibro, libro1, libro2, libro3);
                        socioActual.pedirLibro(eleccion);
                        break;
                    case 3: 
                        if ( socioActual.getLibrosPrestados() == 0 ){
                            System.out.println("uste no tiene ningun libro pa delvolver");
                        }else {
                            mostrarTodos(libro1, libro2, libro3);
                            System.out.println("Elije que libro devolver");
                            do {
                                elijeLibro = lecturaSegura("");
                            } while (elijeLibro < 1 && elijeLibro > 3 );
                            eleccion = elegirLibro(elijeLibro, libro1, libro2, libro3);
                            devolver(eleccion);
                        }
                        break;
                    case 4:
                        socioActual.mostrarDatos();
                        break;
                    case 5:
                        repetir=false;
                        System.out.println("adios mu buena");
                        System.out.printf("Te queda %d libros sin devolver.", socioActual.getLibrosPrestados());
                        Libro libroGanador = libroMasPrestado(libro1, libro2, libro3);
                        System.out.printf("El libro más prestado ha sido el %s, (%d veces)", libroGanador.getTitulo(), libroGanador.getVecesPrestado());
                        break;
                    default:
                        System.out.println("Elija una opción válida");
                        break;
                }
            }
        }

    }
}
