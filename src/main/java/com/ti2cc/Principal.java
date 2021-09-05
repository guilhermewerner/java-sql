package com.ti2cc;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.conectar();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        do {
            System.out.println("[1] Listar");
            System.out.println("[2] Inserir");
            System.out.println("[3] Excluir");
            System.out.println("[4] Atualizar");
            System.out.println();
            System.out.println("[0] Sair");

            int option = scanner.nextInt();

            if (option == 1) { // Listar
                Usuario[] usuarios = dao.getUsuarios();

                for (int i = 0; i < usuarios.length; i++) {
                    System.out.println(usuarios[i].toString());
                }
            } else if (option == 2) { // Inserir
                System.out.print("Informe o código do usuário: ");
                int codigo = scanner.nextInt();

                System.out.print("Informe o login do usuário: ");
                String login = scanner.next();

                System.out.print("Informe a senha do usuário: ");
                String senha = scanner.next();

                System.out.print("Informe o sexo do usuário: ");
                char sexo = scanner.next().charAt(0);

                Usuario usuario = new Usuario(codigo, login, senha, sexo);

                if (dao.inserirUsuario(usuario)) {
                    System.out.println("Usuário " + codigo + " inserido!");
                }
            } else if (option == 3) { // Excluir
                System.out.print("Informe o código do usuário: ");
                int codigo = scanner.nextInt();

                if (dao.excluirUsuario(codigo)) {
                    System.out.println("Usuário " + codigo + " excluído!");
                }
            } else if (option == 4) { // Atualizar
                System.out.print("Informe o código do usuário: ");
                int codigo = scanner.nextInt();

                Usuario usuario = dao.getUsuario(codigo);

                System.out.print("Informe o login do usuário: ");
                usuario.setLogin(scanner.next());

                System.out.print("Informe a senha do usuário: ");
                usuario.setSenha(scanner.next());

                System.out.print("Informe o sexo do usuário: ");
                usuario.setSexo(scanner.next().charAt(0));

                if (dao.atualizarUsuario(usuario)) {
                    System.out.println("Usuário " + codigo + " atualizado!");
                }
            } else if (option == 0) { // Sair
                quit = true;
            } else {
                System.out.println("Opção inválida!");
            }
        } while (!quit);

        scanner.close();
        dao.close();
    }
}
