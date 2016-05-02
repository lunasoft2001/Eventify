package la.oja.eventify;

/**
 * Created by luna-aleixos on 26.04.2016.
 */
public class EventoAntiguo {

    private String titulo;
    private String enlace;
    private String enlaceImagen;
    private String categoria;

    public EventoAntiguo(String titulo, String enlace, String enlaceImagen, String categoria) {
        this.titulo = titulo;
        this.enlace = enlace;
        this.enlaceImagen = enlaceImagen;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEnlace() {
        return enlace;
    }

    public String getEnlaceImagen() {
        return enlaceImagen;
    }

    public String getCategoria() {
        return categoria;
    }
}
