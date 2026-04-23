package models;

public class Aluno {
	
	private Integer matricula;
	private String nome;
	private Integer idade;
	
	public Aluno() {
	}

	public Aluno(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
