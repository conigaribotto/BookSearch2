package Model;

import java.io.Serializable;

public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String autor;
    private String descripcion;
    private int imagenResId; // nuevo atributo

    public Libro(String titulo, String autor, String descripcion, int imagenResId) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.imagenResId = imagenResId;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getDescripcion() { return descripcion; }
    public int getImagenResId() { return imagenResId; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setImagenResId(int imagenResId) { this.imagenResId = imagenResId; }
}
