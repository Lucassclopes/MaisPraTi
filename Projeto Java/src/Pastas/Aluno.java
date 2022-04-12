package Pastas;

import java.time.LocalDate;

public class Aluno extends Pessoa {

    private double nota;

    public Aluno() {
        super();
    }

    public Aluno(String nome, String telefone, LocalDate nascimento, double notaFinal) {
        super(nome, telefone, nascimento);
        this.nota = nota;
    }

    public static Aluno parseAluno(Pessoa pessoa){
        return (Aluno) pessoa;
    }

    public double getNotaFinal() {
        return nota;
    }

    public void setNotaFinal(double notaFinal) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Data de nascimento: " + getNascimento().format(format) + ", Nota final do curso: " + getNotaFinal() + ", Data de cadastro: " + getCadastro().format(format) + ", Última alteração cadastral feita em: " + getUltimaAlteracao().format(format);
    }
}