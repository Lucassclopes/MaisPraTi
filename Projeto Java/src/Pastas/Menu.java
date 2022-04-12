package Pastas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    Scanner recebe = new Scanner(System.in,"ISO-8859-1");
    private boolean verdadeiro = true;
    private List<Pessoa> listaDeCadastrados = new ArrayList();
    private String regexNome = "[a-zA-Zà-üÀ-Ü' ]{3,}";
    private String regexTelefone = "[0-9]{10,12}";
    private String regexNotaFinal = "[0-9]{1,}[\\.][0-9]{1,}|[0-9]{1,}";

    public static void chamarMenu() {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }

    private void mostrarMenu() {
        while (verdadeiro) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Cadastrar pessoa ou aluno");
            System.out.println("2 - Listar os cadastros");
            System.out.println("3 - Atualizar dados");
            System.out.println("4 - Deletar cadastro");
            System.out.println("5 - Encerrar.");

            switch (recebe.nextLine()) {
                case "1":
                    System.out.println("Você escolheu cadastrar pessoa ou aluno");
                        cadastrarPessoaOuAluno();
                    break;
                case "2":
                    System.out.println("Você escolheu listar os cadastros");
                        listarTodosCadastrados();
                    break;
                case "3":
                    System.out.println("Você escolheu atualizar dados");
                        atualizarPessoaOuAluno();
                    break;
                case "4":
                    System.out.println("Você escolheu deletar um cadastro");
                        deletarPessoaOuAluno();
                    break;
                case "5":
                    verdadeiro = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor selecione uma função existente.");
                    break;
            }
        }
    }

    private void cadastrarPessoaOuAluno() {
        System.out.println("Digite o nome:");
        String nome = recebe.nextLine();
        while (!nome.matches(regexNome)) {
            System.out.println("Por favor digite um nome:");
            nome = recebe.nextLine();
        }

        System.out.println("Digite o número de telefone com DDD (apenas números):");
        String telefone = recebe.nextLine();
        while (!telefone.matches(regexTelefone)) {
            System.out.println("Por favor, digite o número de telefone com DDD (apenas números):");
            telefone = recebe.nextLine();
        }

        System.out.println("Digite a data de nascimento(dd/mm/yyyy)");
        LocalDate nascimento = LocalDate.now();
        while (true) {
            try {
                nascimento = LocalDate.parse(recebe.nextLine(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Por favor digite uma data no formato dd/mm/yyyy");
            }
        }

        System.out.println("Digite a nota (caso seja aluno), caso contrário deixe o campo em branco");
        String notaFinal = recebe.nextLine();

        if (notaFinal.isBlank()) {
            listaDeCadastrados.add(new Pessoa(nome, telefone, nascimento));
            System.out.println("Cadastro realizado com sucesso");
        } else {
            while (!notaFinal.matches(regexNotaFinal)) {
                System.out.println("Por favor, digite uma nota válida");
                notaFinal = recebe.nextLine();
            }

            listaDeCadastrados.add(new Aluno(nome, telefone, nascimento, Double.parseDouble(notaFinal)));
            System.out.println("Cadastro realizado com sucesso");
        }
    }

    private void listarTodosCadastrados() {
        System.out.println();

        if (listaDeCadastrados.size() <= 0) {
            System.out.println("Sem cadastros no momento");
        } else {
            int i = 1;
            for (Pessoa cadastrado : listaDeCadastrados) {
                System.out.println("#" + i + "- " + cadastrado);
                i++;
            }
        }

        System.out.println();
    }

    private void atualizarPessoaOuAluno() {
        listarTodosCadastrados();
        if (listaDeCadastrados.size() > 0) {
            System.out.println("Informe o número corresponente ao cadastro que deseja alterar");
            int i = 1;
            while (true) {
                try {
                    i = Integer.parseInt(recebe.nextLine());
                    listaDeCadastrados.get(i - 1);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, digite o número correspondente ao cadastro desejado");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Por favor, digite o número correspondente ao cadastro desejado");
                }
            }

            System.out.println("Caso queira manter o dado anterior, deixe o campo em branco");

            System.out.println("Digite o novo nome:");
            String nome = recebe.nextLine();
            if (!nome.isBlank()) {
                while (!nome.matches(regexNome)) {
                    System.out.println("Por favor digite um nome:");
                    nome = recebe.nextLine();
                }
                listaDeCadastrados.get(i - 1).setNome(nome);
            }

            System.out.println("Por favor, digite o número de telefone com DDD (apenas números):");
            String telefone = recebe.nextLine();
            if (!telefone.isBlank()) {
                while (!telefone.matches(regexTelefone)) {
                    System.out.println("Por favor, digite o número de telefone com DDD (apenas números):");
                    telefone = recebe.nextLine();
                }
                listaDeCadastrados.get(i - 1).setTelefone(telefone);
            }

            System.out.println("Digite a nova data de nascimento(dd/mm/yyyy)");
            String nascimento = recebe.nextLine();
            if (!nascimento.isBlank()) {
                while (true) {
                    try {
                        LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/mm/yyyy"));
                        break;
                    } catch (DateTimeParseException e) {
                        System.out.println("Por favor digite uma data no formato dd/mm/yyyy)");
                        nascimento = recebe.nextLine();
                    }
                }
                listaDeCadastrados.get(i - 1).setNascimento(LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/uuuu")));
            }

            if (listaDeCadastrados.get(i - 1).getClass().toString().equals("class model.Aluno")) {
                System.out.println("Digite a nova nota final do curso:");
                String notaFinal = recebe.nextLine();
                if (!notaFinal.isBlank()) {
                    while (!notaFinal.matches(regexNotaFinal)) {
                        System.out.println("Por favor digite um valor válido(Utilize ponto no lugar da vírgula)");
                        notaFinal = recebe.nextLine();
                    }
                    Aluno.parseAluno(listaDeCadastrados.get(i - 1)).setNotaFinal(Double.parseDouble(notaFinal));
                }
            }

            listaDeCadastrados.get(i - 1).setUltimaAlteracao(LocalDate.now());

            System.out.println("Atualização cadastral realizada");
        }
    }

    private void deletarPessoaOuAluno() {
        listarTodosCadastrados();
        if (listaDeCadastrados.size() > 0) {
            System.out.println("Informe o número correspondente ao cadastro que deseja excluir");
            int i = 1;
            while (true) {
                try {
                    i = Integer.parseInt(recebe.nextLine());
                    listaDeCadastrados.get(i - 1);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor digite uma posição existente");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Por favor digite uma posição existente");
                }
            }

            listaDeCadastrados.remove(i - 1);

            System.out.println("Remoção efetuada com sucesso.\n");
        }
    }

}
