package model;

public class Matricula {
	
	private Integer matriculaAluno;
	private Integer codigoDisciplina;
	private Double primeiraNota;
	private Double segundaNota;
	
	public Matricula() {
	}

	public Matricula(Integer matriculaAluno, Integer codigoDisciplina, Double primeiraNota, Double segundaNota) {
		this.matriculaAluno = matriculaAluno;
		this.codigoDisciplina = codigoDisciplina;
		this.primeiraNota = primeiraNota;
		this.segundaNota = segundaNota;
	}

	public Integer getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(Integer matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

	public Integer getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(Integer codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public Double getPrimeiraNota() {
		return primeiraNota;
	}

	public void setPrimeiraNota(Double primeiraNota) {
		this.primeiraNota = primeiraNota;
	}

	public Double getSegundaNota() {
		return segundaNota;
	}

	public void setSegundaNota(Double segundaNota) {
		this.segundaNota = segundaNota;
	}
	
}
