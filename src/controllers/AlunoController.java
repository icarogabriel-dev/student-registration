package controllers;

import java.util.Scanner;

import models.Aluno;

public class AlunoController {
	
	private Aluno[] vetorAluno;
	private Integer quantidadeAluno;
	
	Scanner sc = new Scanner(System.in);
	
	public AlunoController() {
	}

	public AlunoController(Aluno[] vetorAluno, Integer quantidadeAluno) {
		this.vetorAluno = vetorAluno;
		this.quantidadeAluno = quantidadeAluno;
	}

	public Integer getQuantidadeAluno() {
		return quantidadeAluno;
	}
	
	public Aluno[] getVetorAluno() {
		return vetorAluno;
	}
	
	public void CadastrarAluno() {
		
		System.out.print("Nome: ");
		String nome = sc.next();
		
		System.out.print("Idade: ");
		int idade = sc.nextInt();
		
		// Pega a maior matricula existente e soma 1
		int maiorMatricula = 0;
		for (int i = 0; i < quantidadeAluno; i++) {
			if (vetorAluno[i].getMatricula() > maiorMatricula) {
				maiorMatricula = vetorAluno[i].getMatricula();
			}
		}
		
		Aluno aluno = new Aluno(nome, idade, maiorMatricula + 1);
		vetorAluno[quantidadeAluno++] = aluno;

		System.out.println("Aluno cadastrado! Matricula: " + aluno.getMatricula());
	}

	public void ListarAluno() {

		if (quantidadeAluno == 0) {
			System.out.println("Sem alunos cadastrados.");
			return;
		}

		for (int i = 0; i < quantidadeAluno; i++) {
			System.out.println(vetorAluno[i].getMatricula() + " | " + vetorAluno[i].getNome() + " | " + vetorAluno[i].getIdade() + " anos");
		}
	}

	// Busca aluno pelo nome ou matricula (LOGICA)
	public Aluno BuscarAluno(String valor) {

		for (int i = 0; i < quantidadeAluno; i++) {
			boolean nomeIgual = vetorAluno[i].getNome().toLowerCase() == valor.toLowerCase();
			boolean matriculaIgual = vetorAluno[i].getMatricula().toString().equals(valor);

			if (nomeIgual || matriculaIgual) {
				return vetorAluno[i];
			}
		}
		return null;
	}

	// Busca aluno pelo nome ou matricula (SAIDA)
	public Aluno PedirDadosAluno() {

		Aluno aluno = null;
		while (aluno == null) {
			System.out.print("Nome ou matricula do aluno: ");
			String valor = sc.next();

			aluno = BuscarAluno(valor);

			if (aluno == null) {
				System.out.println("Aluno não encontrado, tente novamente.");
			}
		}
		return aluno;
	}
}
