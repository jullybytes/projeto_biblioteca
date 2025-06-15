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
    private String Nome;
    private String idUsuario;
    private ArrayList<Livro> LivrosEmprestados;

     public Usuario(String Nome, String idUsuario){
        this.Nome = Nome;
        this.idUsuario = idUsuario;
        this.livrosEmprestados = new ArrayList<>();
     }

      public String getNome(){
        return Nome;
      }

      public String getidUsuario(){
        return idUsuario;
      }

       public ArrayList<Livro> getLivrosEmprestados(){
        return LivrosEmprestados;
       }

       public void EmprestarLivro (Livro livro) {
        if (livro.isDisponivel() && !LivrosEmprestados.contains (Livro)) {
            livro.emprestar();
            LivrosEmprestados.add(livro);
            System.out.printIn(nome + "emprestou o livro: " + livro.getTitulo());
        } else if (!livro.isDisponivel()) {
            System.out.printIn("Erro: Livro '" + Livro.getTitulo() + "' não está disponivel.");
        } else {
            System.out.printIn("Erro: Livro já foi emprestado por este usuário.");
        }
    }

    public void devolverLivro(Livro livro) {
        if (LivrosEmprestados.contains(livro)) {
            livro.devolver();
            LivrosEmprestados.remove(livro);
            System.out.printIn(nome + " devolveu o livro: " + livro.getTitulo());
        } else {
            System.out.printIn("Erro: Este livro não está com o usuário.");
        }
    }
        
    public void exibirLivrosEmprestados() {
        System.out.printIn("\nLivros emprestados por " + nome + ":");
        if (LivrosEmprestados.isEmpty()) {
            System.out.printIn("Nenhum livro emprestado.");
        } else {
            for (Livro livro : LivrosEmprestados) {
                System.out.printIn("- " + Livro.getTitulo());
            }
        }
    }
}

public interface ItemBiblioteca {
    boolean isDisponivel();
    void realizarEmprestimo();
    void realizarDevolucao();
    void exibirInformacoes();
    String getTitulo();
}

public class LivroFisico extends Livro implements ItemBiblioteca {
    private String localizacaoPrateleira;

    public LivroFisico(String Titulo, String Autor, int AnoPublicacao, String localizacaoPrateleira) {
        super(Titulo, Autor, AnoPublicacao);
        this.localizacaoPrateleira = localizacaoPrateleira;
    }

    public String getlocalizacaoPrateleira() {
        return localizacaoPrateleira;
    }

    public void setlocalizacaoPrateleira(String localizacaoPrateleira) {
        this.localizacaoPrateleira = localizacaoPrateleira;
    }

    @Override
    public void ExibirDetalhes() {
        System.out.printIn("[Livro Físico]");
        System.out.printIn("Titulo: " + getTitulo());
        System.out.printIn("Autor: " + getAutor());
        System.out.printIn("Ano: " + getAnoPublicacao());
        System.out.printIn("Disponivel: " + isDisponivel());
        System.out.printIn("Localização: " + localizacaoPrateleira);
    }

    @Override
    public boolean isDisponivel() {
        return super.isDisponivel();
    }

    @Override
    public void realizarEmprestimo() {
        super.emprestar();
    }

    @Override
    public void realizarDevolucao() {
        super.devolver();
    }

    @Override
    public void exibirInformacoes() {
        ExibirDetalhes();
    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }
}

public class Ebook extends Livro implements ItemBiblioteca {
    private double tamanhoArquivoMB;
    private String formato;

    public Ebook(String Titulo, String Autor, int AnoPublicacao, double tamanhoArquivoMB, String formato) {
        super(Titulo, Autor, AnoPublicacao);
        this.tamanhoArquivoMB = tamanhoArquivoMB;
        this.formato = formato;
    }

    public double getTamanhoArquivoMB() {
        return tamanhoArquivoMB;
    }

    public void setTamanhoArquivoMB(double tamanhoArquivoMB) {
        this.tamanhoArquivoMB = tamanhoArquivoMB;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void ExibirDetalhes() {
        System.out.printIn("[Ebook]");
        System.out.printIn("Titulo: " + getTitulo());
        System.out.printIn("Autor: " + getAutor());
        System.out.printIn("Ano: " + getAnoPublicacao());
        System.out.printIn("Formato: " + formato);
        System.out.printIn("Tamanho do Arquivo: " + tamanhoArquivoMB + "MB");
        System.out.printIn("Disponivel: " + isDisponivel());
    }

    @Override
    public boolean isDisponivel() {
        return super.isDisponivel();
    }

    @Override
    public void realizarEmprestimo() {
        super.emprestar();
    }

    @Override
    public void realizarDevolucao() {
        super.devolver();
    } 

    @Override
    public exibirInformacoes() {
        ExibirDetalhes();
    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }
}