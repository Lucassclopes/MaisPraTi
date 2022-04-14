package Funcionalidades;

import Objetos.Aluno;
import Objetos.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


public class Operacao {

    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
    ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();


    String nomeAux;
    String telefoneAux;
    String dataNascimentoAux;
    float notaFinalAux;
    LocalDate dataCadastroAux;
    LocalDate dataAlteracaoAux;


    public void Cadastrar() {
        System.out.print("Nome:");
        nomeAux = sc.nextLine();
        System.out.print("Telefone:");
        telefoneAux = sc.nextLine();
        System.out.print("Data de nascimento (dd/mm/aaaa):");
        dataNascimentoAux = sc.nextLine();
        System.out.print("Nota (Dígite 0 para cadastrar pessoa):");
        notaFinalAux = sc.nextFloat();
        sc.nextLine();
        dataCadastroAux = LocalDate.now();
        dataAlteracaoAux = LocalDate.now();

        if (notaFinalAux == 0) {
            CriarPessoa();
        } else {
            CriarAluno();
        }
        System.out.println();
    }


    public void CriarPessoa() {
        Pessoa p1 = new Pessoa(nomeAux, telefoneAux, dataNascimentoAux, dataCadastroAux, dataAlteracaoAux);
        listaPessoa.add(p1);
    }


    public void CriarAluno() {
        Aluno a1 = new Aluno(nomeAux, telefoneAux, dataNascimentoAux, dataCadastroAux, dataAlteracaoAux, notaFinalAux);
        listaAluno.add(a1);
    }


    public void ListarPessoas() {
        System.out.println("Pessoas:");
        int aux = 1;
        for (Pessoa pessoa : listaPessoa) {
            System.out.print(aux + " - ");
            System.out.println(pessoa);
            aux++;
        }
    }


    public void ListarAlunos() {
        System.out.println("Alunos:");
        if (listaAluno.size() != 0) {
            int aux = 1;
            for (Aluno aluno : listaAluno) {
                System.out.print(aux + " - ");
                System.out.println(aluno);
                aux++;
            }
        } else {
            System.out.println("Nenhum aluno cadastrado.");
        }
    }


    public void AtualizarPessoa() {
        ListarPessoas();

        System.out.print("Informe correspondente ao campo que deseja alterar: ");
        int pLista = sc.nextInt();
        sc.nextLine();

        Pessoa pessoa = (Pessoa) listaPessoa.get(pLista - 1);

        System.out.println("1 - Novo nome");
        System.out.println("2 - Novo telefone");
        System.out.println("3 - Nova data de nascimento");
        int pDados = sc.nextInt();
        sc.nextLine();

        dataAlteracaoAux = LocalDate.now();

        if (pDados == 1) {
            System.out.print("Digite o novo nome: ");
            nomeAux = sc.nextLine();
            pessoa.setNome(nomeAux);
            pessoa.setDataAlteracao(dataAlteracaoAux);

        } else if (pDados == 2) {
            System.out.print("Digite o novo telefone: ");
            telefoneAux = sc.nextLine();
            pessoa.setTelefone(telefoneAux);
            pessoa.setDataAlteracao(dataAlteracaoAux);

        } else if (pDados == 3) {
            System.out.print("Digite a nova data de nascimento: ");
            dataNascimentoAux = sc.nextLine();
            pessoa.setDataNascimento(dataNascimentoAux);
            pessoa.setDataAlteracao(dataAlteracaoAux);

        } else {
            System.out.println("Opção inválida");
        }

    }


    public void AtualizarAluno() {
        ListarAlunos();

        System.out.print("Informe o número que deseja alterar: ");
        int aLista = sc.nextInt();
        sc.nextLine();

        Aluno aluno = (Aluno) listaAluno.get(aLista - 1);

        System.out.println("1 - Novo nome");
        System.out.println("2 - Novo telefone");
        System.out.println("3 - Nova data de nascimento");
        System.out.println("4 - Nova nota");
        int aDados = sc.nextInt();
        sc.nextLine();

        if (aDados == 1) {
            System.out.print("Digite o novo nome: ");
            nomeAux = sc.nextLine();
            aluno.setNome(nomeAux);

        } else if (aDados == 2) {
            System.out.print("Digite o novo telefone: ");
            telefoneAux = sc.nextLine();
            aluno.setTelefone(telefoneAux);

        } else if (aDados == 3) {
            System.out.print("Digite a nova data de nascimento: ");
            dataNascimentoAux = sc.nextLine();
            aluno.setDataNascimento(dataNascimentoAux);

        } else if (aDados == 4) {
            System.out.print("Digite a nova nota final: ");
            notaFinalAux = sc.nextFloat();
            sc.nextLine();
            aluno.setNotaFinal(notaFinalAux);
        } else {
        }
        System.out.println("Opção inválida");
    }


    public void DeletarPessoa() {
        ListarPessoas();
        System.out.print("Informe o número correspondente ao cadastro que deseja excluir: ");
        int pLista2 = sc.nextInt();
        sc.nextLine();
        listaPessoa.remove(pLista2 - 1);
    }


    public void DeletarAluno() {
        ListarAlunos();
        System.out.print("Informe o número correspondente ao cadastro que deseja excluir: ");
        int pLista2 = sc.nextInt();
        sc.nextLine();
        listaAluno.remove(pLista2 - 1);
    }
}