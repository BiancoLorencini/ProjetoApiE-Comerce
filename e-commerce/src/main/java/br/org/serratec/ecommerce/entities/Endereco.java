package br.org.serratec.ecommerce.entities;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "endereco")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEndereco", scope = Endereco.class)
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer idEndereco;
	
	@NotBlank
	@Column(name = "cep")
	private String cep;
	

	@Column(name = "rua")
	@JsonAlias("logradouro")
	private String rua;
	

	@Column(name = "bairro")
	@JsonAlias("bairro")
	private String bairro;

	@Column(name = "cidade")
	@JsonAlias("localidade")
	private String cidade;
	
//	@NotNull
	@Column(name = "numero")
	private Integer numero;
//  @NotBlank
	@Column(name = "complemento")
	private String complemento;

	@Column(name = "uf")
	private String uf;

	@OneToOne(mappedBy = "endereco")
	@JsonBackReference
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String logradouro) {
		this.rua = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String localidade) {
		this.bairro = localidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


}
