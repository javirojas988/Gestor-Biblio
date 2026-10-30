public class Biblioteca {
    Libro libro1 = new Libro("Extranjero", "Camus", 1967);
    Libro libro2 = new Libro("Noches Blancas", "Dovtoiseki", 1910);
    Libro libro3 = new Libro("Tokyo BLues", "Haruki Murakami", 1990);

    public void prestar(Libro libro){
        if ( libro.getDisponible() == true ){
            libro.setDisponible(false);
            libro.setVecesPrestado(+1);
        }

    }
}
