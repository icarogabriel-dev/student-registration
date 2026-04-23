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
		
		Aluno aluno = new Aluno();
		
		System.out.print("Nome: ");
		aluno.setNome(sc.nextLine());
		
		System.out.print("Idade: ");
		aluno.setIdade(Integer.parseInt(sc.nextLine()));
		
		// Pega a maior matricula existente e soma 1
		
		int maiorMatricula = 0;
		for (int i = 0; i < quantidadeAluno; i++) {
			if (vetorAluno[i].getMatricula() > maiorMatricula) {
				maiorMatricula = vetorAluno[i].getMatricula();
			}
		}
		
		aluno.setMatricula(maiorMatricula + 1);
		vetorAluno[quantidadeAluno++] = aluno;
	}
}
