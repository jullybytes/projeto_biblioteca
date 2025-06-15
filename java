public abstract class Livro {
private string Titulo;
private string Autor;
private int AnoPublicacao;
private boolean Disponivel;
public Livro (String Titulo, String Autor, int AnoPublicacao){
    this.Titulo = Titulo;
    this.Autor = Autor;
    this.AnoPublicacao = AnoPublicacao;
    this.Disponivel = true;
}

public String getTitulo(){
    return Titulo;
}

public String getAutor(){
    return Autor;
}

public int getAnoPublicacao(){
    return AnoPublicacao;
}

public boolean isDisponivel(){
    return Disponivel;
}

public void setTitulo (String Titulo){
    this.Titulo = Titulo;
}

public void setAutor (String Autor) {
    this.Autor = Autor;
}

public void setAnoPublicacao (int AnoPublicacao) {
    this.AnoPublicacao = AnoPublicacao;
}

public void Emprestar() {
if (Disponivel) {
    Disponivel = false;
    System.out.printIn("Livro '" + Titulo + "' emprestado com sucesso.");
} else {
    System.out.printIn("Livro '" + Titulo + "' está indisponivel para empréstimo.");
}
}

public void Devolver() {
    if (!Disponivel) {
        Disponivel = true;
        System.out.printIn("Livro '" + Titulo + "' devolvido com sucesso.");
    } else {
        System.out.printIn("Livro '" + Titulo + "' já está disponivel.");
}
}

public abstract void ExibirDetalhes();
}

public class Usuario {
    private String nome;
    private String idUsuario;
    private ArrayList<Livro> livrosEmprestados;
}