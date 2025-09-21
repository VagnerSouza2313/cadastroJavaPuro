package repository;

import model.Cadastro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoSave {
    private final String arquivo = "cadastroJavaPuro/src/resources/arquivo.txt";

    public void Salvar(Cadastro cadastro) {
        try {
            File f = new File(arquivo);
            if (!f.exists()) {
                File parent = f.getParentFile();
                if (parent != null && !parent.exists()) parent.mkdirs();
                f.createNewFile();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
                bw.write(cadastro.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cadastro> listar() {
        List<Cadastro> usuarios = new ArrayList<>();
        File f = new File(arquivo);

        // Se não existir, cria e retorna lista vazia
        try {
            if (!f.exists()) {
                File parent = f.getParentFile();
                if (parent != null && !parent.exists()) parent.mkdirs();
                f.createNewFile();
                return usuarios;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return usuarios;
        }

        // Leitura com validação das linhas
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            int linhaNum = 0;
            while ((linha = br.readLine()) != null) {
                linhaNum++;
                linha = linha.trim();
                if (linha.isEmpty()) continue; // pula linhas vazias

                // split no máximo em 2 partes (nome;senha)
                String[] dados = linha.split(";", 2);

                if (dados.length < 2) {
                    // Log para ajudar a debugar
                    System.out.println("Linha inválida (pulada) no arquivo " + arquivo + " [linha " + linhaNum + "]: '" + linha + "'");
                    continue;
                }

                String nome = dados[0].trim();
                String senha = dados[1].trim();
                usuarios.add(new Cadastro(nome, senha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean Autenticar(String nome, String senha) {
        for (Cadastro u : listar()) {
            if (u.getNome().equals(nome) && u.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
