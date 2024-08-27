package com.generation.Gendesafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_dados")
public class Dados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo é Obrigatório!")
	@Size(min = 3, max = 100, message = "O nome deve conter no mínimo 03 e no máximo 100 caracteres" )
	private String nome;
	
	@NotNull(message = "A idade é obrigatória!")
    @Min(value = 7, message = "A idade deve ser no mínimo 7")
    private Integer idade;
	
	@NotNull(message = "A nota do primeiro semestre é obrigatória!")
    @Min(value = 0, message = "A nota deve ser no mínimo 0")
    @Max(value = 10, message = "A nota deve ser no máximo 10")
    private Double notaPrimeiroSemestre;
	
	@NotNull(message = "A nota do segundo semestre é obrigatória!")
	@Min(value = 0, message = "A nota deve ser no mínimo 0")
	@Max(value = 10, message = "A nota deve ser no máximo 10")
	private Double notaSegundoSemestre;
	
	@NotBlank(message = "O nome do professor é obrigatório!")
	private String nomeProfessor;
	
	@NotNull(message = "O número da sala é obrigatório!")
    private Integer numeroSala;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getNotaPrimeiroSemestre() {
		return notaPrimeiroSemestre;
	}

	public void setNotaPrimeiroSemestre(Double notaPrimeiroSemestre) {
		this.notaPrimeiroSemestre = notaPrimeiroSemestre;
	}

	public Double getNotaSegundoSemestre() {
		return notaSegundoSemestre;
	}

	public void setNotaSegundoSemestre(Double notaSegundoSemestre) {
		this.notaSegundoSemestre = notaSegundoSemestre;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public Integer getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(Integer numeroSala) {
		this.numeroSala = numeroSala;
	}
	
	
	 
}
