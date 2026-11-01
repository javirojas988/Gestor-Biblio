public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible = true;
    private int vecesPrestado;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + anioPublicacion);
        if (disponible == true) {
            System.out.println("Libro disponible");
        } else {
            System.out.println("Prestado");
        }
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public boolean getDisponible(){
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void setVecesPrestado(int vecesPrestado) {
        this.vecesPrestado = vecesPrestado;
    }
    public int getVecesPrestado() {
        return vecesPrestado;
    }
}
