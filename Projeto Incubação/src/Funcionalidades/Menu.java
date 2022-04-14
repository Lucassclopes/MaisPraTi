package Funcionalidades;

import java.util.Scanner;


public class Menu {

    public void Inicializar () {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        Operacao sistema = new Operacao();

        int menu = 0;
        do {
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Cadastrar uma pessoa ou aluno");
            System.out.println("2 - Listar os cadastrados");
            System.out.println("3 - Atualizar dados");
            System.out.println("4 - Deletar cadastro");
            System.out.println("5 - Encerrar");
            menu = sc.nextInt();
            System.out.println("");

            switch(menu) {
                case 1:
                    sistema.Cadastrar();
                    break;
                case 2:
                    sistema.ListarPessoas();
                    System.out.println("");
                    sistema.ListarAlunos();
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Digite (1) para atualizar pessoas ou (2) para atualizar alunos");
                    int op = sc.nextInt();
                    sc.nextLine();
                    if(op == 1) {
                        sistema.AtualizarPessoa();
                    }else if (op == 2){
                        sistema.AtualizarAluno();
                    }else {
                        System.out.println("Opção inválida!");
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.out.print("Digite (1) para deletar uma pessoa ou (2) para deletar um aluno: ");
                    int op2 = sc.nextInt();
                    sc.nextLine();
                    if(op2 == 1) {
                        sistema.DeletarPessoa();
                    }else if (op2 == 2){
                        sistema.DeletarAluno();
                    }else {
                        System.out.println("Opção inválida!");
                        System.out.println("");
                    }
                    break;
                case 5:
                    System.out.println("Encerrado.");
                    System.exit(0);
                default:
                    System.out.println("Digite uma opção válida!");
                    System.out.println("");
                    menu = 1;
                    break;
            }
        } while (menu != 0);
    }
}
