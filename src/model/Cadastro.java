package model;
import java.util.Scanner;

public class Cadastro {

    private String nome;
    private String senha;
    private String ConteudoSalvo;

    Scanner scanner = new Scanner(System.in);

    public Cadastro(String dado, String dado1){
        this.nome = dado;
        this.senha = dado1;
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

    public String toString(){
        return nome + ";" + senha;
    }
}
