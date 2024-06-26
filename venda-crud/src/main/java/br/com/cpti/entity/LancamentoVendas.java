package br.com.cpti.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class LancamentoVendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoVenda;   
	private LocalDate dataVenda;
   	private Double valorVenda;  
	private String vendedor;
	
	public Long getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(Long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	@Override
	public String toString() {
		return "LancamentoVendas [codigoVenda=" + codigoVenda + ", dataVenda=" + dataVenda + ", valorVenda="
				+ valorVenda + ", vendedor=" + vendedor + "]";
	}
	
	
	
}
