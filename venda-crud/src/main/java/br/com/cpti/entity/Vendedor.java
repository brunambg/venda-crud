package br.com.cpti.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

public class Vendedor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codVendedor;
	
	@NotBlank(message = "Nome inválido!")
    @Size(max = 50)
	private String nome;
	
    @Email(message = "email inválido!")
	private String email;
    
    @DecimalMin(value = "1.412", message = "Valor inválido") 
	private Double salario;
	
	public Long getCodVendedor() {
		return codVendedor;
	}
	public void setCodVendedor(Long codVendedor) {
		this.codVendedor = codVendedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Vendedor [codVendedor=" + codVendedor + ", nome=" + nome + ", email=" + email + ", salario=" + salario
				+ "]";
	}
	
}
