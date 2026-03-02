public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int numPaginas;

    /**
     * Metodo constructor de libros
     * @param id
     * @param titulo
     * @param autor
     * @param numPaginas
     */
    public Libro(int id, String titulo, String autor, int numPaginas) {
        int numHojas;

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;

        numHojas = numPaginas/2;
    }

    /**
     * Devuelve el id del libro
     * @return
     */
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Libro: ");

        sb.append(String.format("\n id: %d;", id));
        sb.append(String.format("\n titulo: %s;", titulo));
        sb.append(String.format("\n autor: %s;", autor));
        sb.append(String.format("\n numPaginas: %s;", numPaginas));
        sb.append("}");

        return sb.toString();
    }

    public boolean updateNumPaginas(int numPaginas) {
        boolean resultado;

        if(numPaginas <= 0){
            resultado = false;
        } else{
            this.numPaginas = numPaginas;
            resultado = true;
        }
        return resultado;
    }
}
