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
            boolean prestamoHecho = Biblioteca.prestar(libro);
            if ( prestamoHecho == true ){
                librosPrestados++;
                System.out.println("Papu prestamo hecho!!! ya tienes: "+ libro.getTitulo());
            }
            System.out.println("papu, libro no disponible, salu2");
        } else {
            System.out.println("No puedes pedir más libros. Ya tienes 2.");
        }
    }
    
    public void devolverLibr(Libro libro){
        Biblioteca.devolver(libro);
        if (librosPrestados >=0){
            librosPrestados-- ;
        }
    }
    
    public void mostrarDatos(){
        System.out.printf("Nombre: %s\nNúmero de socio: %d\nLibros prestados: %d: ", nombre, numeroSocio, librosPrestados);
    }

    public String getNombre() {
        return nombre;
    }
    public int getNumeroSocio() {
        return numeroSocio;
    }
    public int getContrasenia(){
        return  contrasenia;
    }
    public int getLibrosPrestados() {
        return librosPrestados;
    }
}
