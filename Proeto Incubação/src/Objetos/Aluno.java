package Objetos;

import java.time.LocalDate;

public class Aluno extends Pessoa {

    private float notaFinal;

    public Aluno(String nome, String telefone, String dataNascimento, LocalDate dataCadastro, LocalDate dataAlteracao, float notaFinal) {
        super(nome, telefone, dataNascimento, dataCadastro, dataAlteracao);
        this.notaFinal = notaFinal;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String toString() {
        return "Nome: " + getNome() + " | Telefone: " + getTelefone() + " | Data do nascimento: " + getDataNascimento() +
                " | Nota final: " + getNotaFinal() + " | Data do Cadastro: " + dtf.format(getDataCadastro()) + " | Data da ultima alteracao: " +
                dtf.format(getDataAlteracao());
    }
}
