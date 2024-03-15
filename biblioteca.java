package java_poo.bibliotech;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private Map<String, ArrayList<String>> livros = new HashMap<String, ArrayList<String>>();
    private Map<String, ArrayList<String>> usuarios = new HashMap<String, ArrayList<String>>();
    private Map<String, String> emprestimos = new HashMap<String, String>();
    private ArrayList<String> relatorio = new ArrayList<String>();

    Biblioteca(String razaoSocial, String cnpj, String endereco){
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void interfaceBiblioteca(){
        Scanner scanner = new Scanner(System.in);
        Integer opcao = 9;
        
        while (opcao != 0){
            
            System.out.println("                     ");
            System.out.println("INTERFACE BIBLIOTECH:");
            System.out.println("                     ");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Consultar usuários cadastrados");
            System.out.println("4 - Consultar acervo de livros");
            System.out.println("5 - Gerar relatórios de empréstimos");
            System.out.println("6 - Registrar empréstimo");
            System.out.println("7 - Registrar devolução");
            System.out.println("                     ");
            System.out.println("0 - Sair");
            System.out.println("                     ");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
        
            switch (opcao) {
                case 1:
                    ArrayList<String> listaUsuario = cadastrarUsuario();
                    usuarios.put(listaUsuario.get(0), listaUsuario);
                    continuar();
                    break;
                case 2:
                    ArrayList<String> listaLivro = cadastrarLivro();
                    livros.put(listaLivro.get(0), listaLivro);
                    continuar();
                    break;
                case 3:
                    if (usuarios.isEmpty()){
                        System.out.println("                      ");
                        System.out.println("== Nenhum usuário cadastrado... ==");
                        continuar();
                    } else {
                        consultarUsuarios();
                    }
                    break;
                case 4:
                    if (livros.isEmpty()){
                        System.out.println("                      ");
                        System.out.println("== Nenhum livro no acervo... ==");
                        continuar();
                    } else {
                        consultarLivros();
                    }
                    break;
                case 5:
                System.out.println("           ");
                System.out.println("RELATÓRIO:");
                    for (int i = 0; i < relatorio.size(); i++)
                        System.out.println(relatorio.get(i));
                        continuar();
                    break;
                case 6:
                    ArrayList<String> emprestimo = emprestarLivro();
                    emprestimos.put(emprestimo.get(0), emprestimo.get(1));
                    Date dataEmprestimo = new Date();
                    if (relatorio.size() >= 0){
                        relatorio.add(relatorio.size(), ("\nEmprestimo:\nUsuário: " + usuarios.get(emprestimo.get(0)).get(1) + "\nLivro: " + livros.get(emprestimo.get(1)).get(1) + "\n Data: " + dataEmprestimo));
                    }
                    continuar();
                    break;
                case 7:
                    ArrayList<String> devolucao = devolverLivro();
                    emprestimos.remove(devolucao.get(0), devolucao.get(1));
                    Date dataDevolucao = new Date();
                    if (relatorio.size() >= 0){
                        relatorio.add(relatorio.size(), ("\nDevolução:\nUsuário: " + usuarios.get(devolucao.get(0)).get(1) + "\nLivro: " + livros.get(devolucao.get(1)).get(1) + "\nData: " + dataDevolucao));
                    }
                    break;
                case 0:
                    scanner.close();
                    break;
                default:
                    System.out.println("                       ");
                    System.out.println("== Esta opção não é válida ==");
                    continuar();
            }
        }
    }

    public void continuar(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("                    ");
        System.out.println("Pressione ENTER pra continuar");
        scanner.nextLine();
    }

    public ArrayList<String> cadastrarUsuario(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("                    ");
        System.out.println("CADASTRANDO USUÁRIO:");
        System.out.println("                    ");
        
        System.out.println("Novo ID: ");
        String id = scanner.next();
        scanner.nextLine();

        System.out.println("Nome completo: ");
        String nome = scanner.next();
        scanner.nextLine();
        
        System.out.println("Telefone: ");
        String telefone = scanner.next();
        scanner.nextLine();
        
        System.out.println("Email: ");
        String email = scanner.next();
        scanner.nextLine();
        
        System.out.println("Endereço: ");
        String endereco = scanner.next();
        scanner.nextLine();

        Usuario usuario = new Usuario(id, nome, telefone, email, endereco);
        
        ArrayList<String> dadosUsuario = new ArrayList<String>();
        dadosUsuario.add(0, usuario.getID());
        dadosUsuario.add(1, usuario.getNome());
        dadosUsuario.add(2, usuario.getTelefone());
        dadosUsuario.add(3, usuario.getEmail());
        dadosUsuario.add(4, usuario.getEndereco());

        return dadosUsuario;
    }

    public ArrayList<String> cadastrarLivro(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("                    ");
        System.out.println("CADASTRANDO LIVRO:");
        System.out.println("                    ");
        
        System.out.println("ISBN: ");
        String livroISBN = scanner.next();
        scanner.nextLine();

        System.out.println("Titulo: ");
        String livroTitulo = scanner.next();
        scanner.nextLine();
        
        System.out.println("Categoria: ");
        String livroCategoria = scanner.next();
        scanner.nextLine();
        
        System.out.println("Autor: ");
        String livroAutor = scanner.next();
        scanner.nextLine();
        
        System.out.println("Editora: ");
        String livroEditora = scanner.next();
        scanner.nextLine();

        System.out.println("Ano de Publicação: ");
        String livroAnoPublicacao = scanner.next();
        scanner.nextLine();

        Livro livro = new Livro(livroISBN, livroTitulo, livroCategoria, livroAutor, livroEditora, livroAnoPublicacao);
        
        ArrayList<String> dadosLivro = new ArrayList<String>();
        dadosLivro.add(0, livro.getISBN());
        dadosLivro.add(1, livro.getTitulo());
        dadosLivro.add(2, livro.getCategoria());
        dadosLivro.add(3, livro.getAutor());
        dadosLivro.add(4, livro.getEditora());
        dadosLivro.add(5, livro.getAnoPublicacao());

        return dadosLivro;
    }

    public void consultarUsuarios(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("                    ");
        System.out.println("CONSULTA DE USUÁRIOS:");
        System.out.println("                    ");
        System.out.println("Informe o ID do usuário:");
        String idUser = scanner.next();
        scanner.hasNextLine();

        System.out.println("                    ");
        System.out.println("DADOS DO USUÁRIO:");
        System.out.println("                    ");
        System.out.println("ID: " + usuarios.get(idUser).get(0));
        System.out.println("NOME: " + usuarios.get(idUser).get(1));
        System.out.println("TELEFONE: " + usuarios.get(idUser).get(2));
        System.out.println("EMAIL: " + usuarios.get(idUser).get(3));
        System.out.println("ENDEREÇO: " + usuarios.get(idUser).get(4));

        continuar();
    }

    public void consultarLivros(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("                    ");
        System.out.println("CONSULTA DE LIVROS:");
        System.out.println("                    ");
        System.out.println("Informe o ISBN do livro:");
        String isbnLivro = scanner.next();
        scanner.hasNextLine();

        System.out.println("                    ");
        System.out.println("DADOS DO USUÁRIO:");
        System.out.println("                    ");
        System.out.println("ISBN: " + livros.get(isbnLivro).get(0));
        System.out.println("TITULO: " + livros.get(isbnLivro).get(1));
        System.out.println("CATEGORIA: " + livros.get(isbnLivro).get(2));
        System.out.println("AUTOR: " + livros.get(isbnLivro).get(3));
        System.out.println("EDITORA: " + livros.get(isbnLivro).get(4));
        System.out.println("ANO DE PUBLICAÇÃO: " + livros.get(isbnLivro).get(5));

        continuar();
    }

    public ArrayList<String> emprestarLivro(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("                    ");
        System.out.println("EMPRESTAR LIVRO:");
        System.out.println("                    ");
        System.out.println("(Apenas 1 livro por pessoa)");
        System.out.println("                    ");
        System.out.println("Informe o ID do usuário:");
        String idUser = scanner.next();
        scanner.hasNextLine();
        System.out.println("Informe o ISBN do livro:");
        String isbnLivro = scanner.next();
        scanner.hasNextLine();

        ArrayList<String> dadosEmprestimo = new ArrayList<String>();
        dadosEmprestimo.add(0, idUser);
        dadosEmprestimo.add(1, isbnLivro);

        return dadosEmprestimo;
    }

    public ArrayList<String> devolverLivro(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("                    ");
        System.out.println("DEVOLVER LIVRO:");
        System.out.println("                    ");
        System.out.println("Informe o ID do usuário:");
        String idUser = scanner.next();
        scanner.hasNextLine();
        System.out.println("Informe o ISBN do livro:");
        String isbnLivro = scanner.next();
        scanner.hasNextLine();

        ArrayList<String> dadosDevolucao = new ArrayList<String>();
        dadosDevolucao.add(0, idUser);
        dadosDevolucao.add(1, isbnLivro);

        return dadosDevolucao;
    }
}
    
    