package controllers;

import models.Aluno;
import models.Disciplina;

import java.util.Scanner;

public class DisciplinaController {

    private Disciplina[] vetorDisciplina;
    private Integer quantidadeDisciplina;

    Scanner sc = new Scanner(System.in);

    public DisciplinaController(Disciplina[] vetorDisciplina, int quantidadeDisciplina) {
        this.vetorDisciplina = vetorDisciplina;
        this.quantidadeDisciplina = quantidadeDisciplina;
    }

    public Integer getQuantidadeDisciplina() {
        return quantidadeDisciplina;
    }

    public Disciplina[] getVetorDisciplina() {
        return vetorDisciplina;
    }

    public void CadastrarDisciplina() {

        System.out.print("Nome da disciplina: ");
        String nome = sc.next();

        System.out.print("Nota minima da disciplina: ");
        double notaMinima = sc.nextDouble();

        // Pega o maior codigo existente e soma 1
        int maiorCodigo = 0;
        for (int i = 0; i < quantidadeDisciplina; i++) {
            if (vetorDisciplina[i].getCodigo() > maiorCodigo) {
                maiorCodigo = vetorDisciplina[i].getCodigo();
            }
        }

        Disciplina disciplina = new Disciplina(maiorCodigo + 1, nome, notaMinima);
        vetorDisciplina[quantidadeDisciplina++] = disciplina;

        System.out.println("Disciplina cadastrada! Codigo: " + disciplina.getCodigo());
    }

    public void ListarDisciplina() {

        if (quantidadeDisciplina == 0) {
            System.out.println("Sem disciplinas cadastradas.");
            return;
        }

        for (int i = 0; i < quantidadeDisciplina; i++) {
            System.out.println(vetorDisciplina[i].getCodigo() + " | " + vetorDisciplina[i].getNome() + " | Nota minima: " + vetorDisciplina[i].getNotaMinima());
        }
    }

    // Busca disciplina pelo codigo ou nome (LOGICA)
    public Disciplina BuscarDisciplina(String valor) {
        for (int i = 0; i < quantidadeDisciplina; i++) {
            if (vetorDisciplina[i].getCodigo().toString().equals(valor)) {
                return vetorDisciplina[i];
            }

            if (vetorDisciplina[i].getNome().toLowerCase().equals(valor.toLowerCase())) {
                return vetorDisciplina[i];
            }
        }
        return null;
    }

    // Busca aluno pelo nome ou matricula (SAIDA)
    public Disciplina PedirDadosDisciplina() {

        Disciplina disciplina = null;
        while (disciplina == null) {
            System.out.print("Nome ou codigo da disciplina: ");
            String valor = sc.next();

            disciplina = BuscarDisciplina(valor);

            if (disciplina == null) {
                System.out.println("Disciplina não encontrada, tente novamente.");
            }
        }
        return disciplina;
    }
}
