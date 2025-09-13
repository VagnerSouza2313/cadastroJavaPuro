package domain;
import java.util.Scanner;

public class Cadastro {

    private String nome;
    private String senha;
    private String ConteudoSalvo;

    Scanner scanner = new Scanner(System.in);

    public Cadastro(){}

    public void telaCadastro(){
        System.out.println("-----sistema de cadastro java puro-----");

        System.out.println("Digite seu nome:");
        setNome(scanner.nextLine());

        System.out.println("Digite sua senha:");
        setSenha(scanner.nextLine());

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConteudoSalvo() {
        return ConteudoSalvo;
    }

    public void setConteudoSalvo(String conteudoSalvo) {
        ConteudoSalvo = conteudoSalvo;
    }
}
