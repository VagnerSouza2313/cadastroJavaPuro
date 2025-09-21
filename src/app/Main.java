package app;

import model.Cadastro;
import repository.ArquivoSave;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome, senha;
        ArquivoSave arquivoSave = new ArquivoSave();
        char escolha = 0;

        do {

            System.out.println("-----SISTEMA DE CADASTRO E LOGIN-----");
            System.out.println("Escolha uma opção \n (1) CADASTRAR \n (2) LOGAR \n");
            int opc = scanner.nextInt();

            scanner.nextLine();

            if (opc == 1) {
                System.out.println("Digite seu nome: ");
                nome = scanner.nextLine();
                System.out.println("Digite sua senha: ");
                senha = scanner.nextLine();

                Cadastro cadastro = new Cadastro(nome, senha);
                arquivoSave.Salvar(cadastro);
                System.out.println("Usuario Cadastrado com sucesso!");
                System.out.println("Deseja realizar o login: (S)im  (N)ão");
                escolha = scanner.next().charAt(0);

            } else if (opc == 2) {
                System.out.println("Nome: ");
                String nomeLogin = scanner.nextLine();
                System.out.println("Senha: ");
                String senhaLogin = scanner.nextLine();

                if (arquivoSave.Autenticar(nomeLogin, senhaLogin)) {
                    System.out.println("-----TELA INICIAL-----");
                    System.out.println("Login Realizado com sucesso");
                    System.out.println("Deseja voltar a tela de opções: (S)im  (N)ão");
                    escolha = scanner.next().charAt(0);
                } else {
                    System.out.println("Dados incorretos!");
                }
            }
        }
        while (escolha == 'S');
        if (escolha == 'N'){
            System.out.println("Programa encerrado.");
        }
    }
}