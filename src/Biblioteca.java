public class Biblioteca {

    private Libro[] catalogo;
    private final int CANT_MAX_LIBROS;

    public Biblioteca(int cantidad_maxima_libros) {
        CANT_MAX_LIBROS = cantidad_maxima_libros;
        catalogo = new Libro[CANT_MAX_LIBROS];
    }

    /**
     * Busca el primer libro que encuentre con el id recibido
     * @param idLibro
     * @return
     */
    public Libro findLibro(int idLibro){
        boolean seguirBuscando = true;
        Libro LibroEncontrado = null;

        for(int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++){
            if(catalogo[i] != null && catalogo[i].getId() == idLibro){
                seguirBuscando = false;
                LibroEncontrado = catalogo[i];
            }

        }
        return LibroEncontrado;
    }

    /**
     * Metodo privado que busca la primera posicion libre en el catalogo
     * @return -1 si no hay posiciion libre
     */
    private int buscarPrimerHuecolIBRE(){
        int posicionLibre = -1;
        boolean seguirBuscando = true;

        for(int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++){
            if(catalogo[i] != null){
                posicionLibre = i;
                seguirBuscando = false;
            }
        }
        return posicionLibre;
    }

    /**
     * Recibe y anade el libro no duplicado
     * @param libro Libro recibido
     * @return true si se ha anadido false si no ha podido anadirlo
     */
    public boolean addLibro(Libro libro){
        boolean libroAnadido = false;
        int posicion;

        //comporbamos si existe
            //buscar hueco
                //no hay --> libroAnadido = false
                //si hay -->
                    //anadimos
                    //libroAnadido = true
        if(findLibro(libro.getId()) != null){ //no lo ha encontrado, no esta duplicado
            posicion = buscarPrimerHuecolIBRE();

            if(posicion >= 0){
                catalogo[posicion] = libro;
                libroAnadido = true;
            }
        }
        return libroAnadido;
    }

    /**
     * Recibe un id de un libro y lo borra
     * @param id Identificador de libro
     * @return el libro eliminado o null en caso de encontrarlo
     */
    public Libro deleteLibro(int id){
        Libro LibroEncontrado = null;
        boolean seguirBuscando = true;

        //comprobamos que exist. Necesitamos el libro y la pposicion

        for(int i = 0; i < CANT_MAX_LIBROS; i++){
            if(catalogo[i] != null && catalogo[i].getId() == id){
                LibroEncontrado = catalogo[i];
                catalogo[i] = null ;
                seguirBuscando = false;
            }
        }
        return LibroEncontrado;
    }

    public boolean updateNumPaginas(int idLibro, int numPaginas){
        boolean numPaginasActualizado;
        Libro libro;

        libro = findLibro(idLibro);

        if(libro != null){
            libro.updateNumPaginas(numPaginas);

        }
    }


}
