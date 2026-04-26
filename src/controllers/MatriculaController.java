package controllers;

import models.Aluno;
import models.Disciplina;
import models.Matricula;

import java.util.Scanner;

public class MatriculaController {

    private Matricula[] vetorMatricula;
    private Integer quantidadeMatricula;

    Scanner sc = new Scanner(System.in);

    public MatriculaController(Integer quantidadeMatricula, Matricula[] vetorMatricula) {
        this.quantidadeMatricula = quantidadeMatricula;
        this.vetorMatricula = vetorMatricula;
    }

    public Integer getQuantidadeMatricula() {
        return quantidadeMatricula;
    }

    public Matricula[] getVetorMatricula() {
        return vetorMatricula;
    }

    public void CadastraMatricula(AlunoController alunoController, DisciplinaController disciplinaController) {

        Aluno aluno = alunoController.PedirDadosAluno();
        Disciplina disciplina = disciplinaController.PedirDadosDisciplina();

        // Checa se o aluno está matriculado nessa disciplina
        for (int i = 0; i < quantidadeMatricula; i++) {
            if (vetorMatricula[i].getMatriculaAluno() == aluno.getMatricula() && vetorMatricula[i].getCodigoDisciplina() == disciplina.getCodigo()) {
                System.out.println("Aluno já está matriculado nessa disciplina.");
                return;
            }
        }

        // Cria a matricula com notas zeradas
        Matricula matricula = new Matricula();
        matricula.setMatriculaAluno(aluno.getMatricula());
        matricula.setCodigoDisciplina(disciplina.getCodigo());
        matricula.setPrimeiraNota(0.0);
        matricula.setSegundaNota(0.0);

        vetorMatricula[quantidadeMatricula++] = matricula;

        System.out.println("Matrícula concluída.");
    }

    // Atribui as notas de um aluno em uma disciplina
    public void AtribuirNota(AlunoController alunoController, DisciplinaController disciplinaController) {

        Aluno aluno = alunoController.PedirDadosAluno();
        Disciplina disciplina = disciplinaController.PedirDadosDisciplina();

        for (int i = 0; i < quantidadeMatricula; i++) {
            if (vetorMatricula[i].getMatriculaAluno() == aluno.getMatricula() && vetorMatricula[i].getCodigoDisciplina() == disciplina.getCodigo()) {
                System.out.print("Primeira nota: ");
                vetorMatricula[i].setPrimeiraNota(sc.nextDouble());

                System.out.print("Segunda nota: ");
                vetorMatricula[i].setSegundaNota(sc.nextDouble());

                System.out.println("Notas atribuídas.");
                return;
            }
        }

        System.out.println("Matrícula não encontrada!");
    }

    private double Media(Matricula matricula) {
        return (matricula.getPrimeiraNota() + matricula.getSegundaNota()) / 2.0;
    }

    public void ListaAlunosDaDisciplina(DisciplinaController disciplinaController, AlunoController alunoController) {

        Disciplina disciplina = disciplinaController.PedirDadosDisciplina();
        System.out.println("Alunos em " + disciplina.getNome() + ":");

        boolean achouAluno = false;
        for (int i = 0; i < quantidadeMatricula; i++) {
            if (vetorMatricula[i].getCodigoDisciplina() == disciplina.getCodigo()) {
                Aluno aluno = alunoController.BuscarAluno(vetorMatricula[i].getMatriculaAluno().toString());

                if (aluno == null) {
                    System.out.println("Aluno não encontrado, tente novamente.");
                }
                else {
                    double media = (vetorMatricula[i].getPrimeiraNota() + vetorMatricula[i].getSegundaNota()) / 2.0;

                    String situacao;
                    if (media >= disciplinaController.PedirDadosDisciplina().getNotaMinima()) {
                        situacao = "Aprovado!";
                    }
                    else {
                        situacao = "Reprovado!";
                    }

                    System.out.println(aluno.getNome() + " | N1: " + vetorMatricula[i].getPrimeiraNota() + " | N2: " + vetorMatricula[i].getSegundaNota() + " | Média: " + String.format("%.2f", media) + " | " + situacao);
                    achouAluno = true;
                }
            }
        }

        if (!achouAluno) {
            System.out.println("Nenhum aluno cadastrado nessa disciplina.");
        }
    }

    public void ListarDisciplinasDoAluno(DisciplinaController disciplinaController, AlunoController alunoController) {

        Aluno aluno = alunoController.PedirDadosAluno();
        System.out.println("Disciplinas de " + aluno.getNome() + ":");

        boolean achouDisciplina = false;
        for (int i = 0; i < quantidadeMatricula; i++) {
            if (vetorMatricula[i].getMatriculaAluno() == aluno.getMatricula()) {
                Disciplina disciplina = disciplinaController.BuscarDisciplina(vetorMatricula[i].getCodigoDisciplina().toString());

                if (disciplina == null) {
                    System.out.println("Disciplina não encontrada");
                }
                else {
                    double media = (vetorMatricula[i].getPrimeiraNota() + vetorMatricula[i].getSegundaNota()) / 2.0;

                    String situacao;
                    if (media >= disciplinaController.PedirDadosDisciplina().getNotaMinima()) {
                        situacao = "Aprovado!";
                    }
                    else {
                        situacao = "Reprovado!";
                    }

                    System.out.println(aluno.getNome() + " | N1: " + vetorMatricula[i].getPrimeiraNota() + " | N2: " + vetorMatricula[i].getSegundaNota() + " | Média: " + String.format("%.2f", media) + " | " + situacao);
                    achouDisciplina = true;
                }
            }
        }

        if (!achouDisciplina) {
            System.out.println("Nenhuma disciplina cadastrada.");
        }
    }
}
