public class Socio {
    private String nombre ;
    private int numeroSocio;
    private int contrasenia;
    private int librosPrestados = 0 ;
    private final int MAX_PRESTAMOS = 2 ;

    public Socio(String nombre, int numeroSocio, int contrasenia) {
        this.nombre = nombre;
        this.numeroSocio = numeroSocio;
        this.contrasenia = contrasenia;
    }

    public boolean comprobarContrasenia(int pin ){
        if ( pin == contrasenia){
            return true;
        }
        else return false;
    }

    public boolean puedePedir(){
        if ( librosPrestados < 2 ){
            return true ;
        }
        else return false;
    }

    public void pedirLibro ( Libro libro ){
        if ( puedePedir() == true ){
            //biblioteca.prestar(libro)
            
        } else {
            System.out.println("No puedes pedir más libros. Ya tienes 2.");
        }
    }
    
}
