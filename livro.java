package java_poo.bibliotech;

public class Livro {
    private String ISBN;
    private String titulo;
    private String categoria;
    private String autor;
    private String editora;
    private String anoPublicacao;

    Livro(String ISBN, String titulo, String categoria, String autor, String editora, String anoPublicacao){
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.categoria = categoria;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }
    public void setAnoPublicacao(String anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }
    
    public String getISBN(){
        return this.ISBN;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public String getAutor(){
        return this.autor;
    }
    public String getEditora(){
        return this.editora;
    }
    public String getAnoPublicacao(){
        return this.anoPublicacao;
    }
}