package br.laab.askgo.entities;

import java.util.Date;
import java.util.List;
import java.util.Observable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Enquete extends Observable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	
	private String titulo;
	private String descricao;
	private String status;
	
	@ManyToMany(mappedBy="enquetes")
	private List<Usuario> colaboradores;
	
	@Temporal(TemporalType.DATE)
	private Date dataLimiteVotacao;	
	
	@OneToMany(mappedBy="enquete")
	private List<OpcaoEnquete> opcoes;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Usuario> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<Usuario> colaboradores) {
		this.colaboradores = colaboradores;
	}
	public Date getDataLimiteVotacao() {
		return dataLimiteVotacao;
	}
	public void setDataLimiteVotacao(Date dataLimiteVotacao) {
		this.dataLimiteVotacao = dataLimiteVotacao;
	}
	public List<OpcaoEnquete> getOpcoes() {
		return opcoes;
	}
	public void setOpcoes(List<OpcaoEnquete> opcoes) {
		this.opcoes = opcoes;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public void votar() {
		this.status = "com voto";
		this.atualizarStatus();
		
	}
	
	public void removerVoto() {
		this.status = "voto removido";
		this.atualizarStatus();
	}
	
	
	private void atualizarStatus() {
		setChanged();
		notifyObservers(status);
		
	}

}
	
