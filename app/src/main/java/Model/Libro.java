package Model;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private String descripcion;

    public Libro(String titulo, String autor, String descripcion) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}
