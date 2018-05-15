package br.laab.askgo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends ObservadorEnquete{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nome_usuario",length=100)
	private String nome;
	
	private String email;
	private String celular;
	private String senha;
	
	@OneToMany(mappedBy="usuario")
	private List<Agenda> agendas;
	
	@ManyToMany
	private List<Enquete> enquetes;
	
	
	public Usuario(Long id) {
		this.id = id;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String Nome) {
		nome = Nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	public List<Enquete> getEnquetes() {
		return enquetes;
	}
	public void setEnquetes(List<Enquete> enquetes) {
		this.enquetes = enquetes;
	}
	
	@Override
	public void enqueteComVoto(Enquete enquete) {
		System.out.println("\nEnviando email para " + this.getEmail() + "...");
		System.out.println("Usuário [" + this.getNome() + "]: \nA enquete [" + enquete.getTitulo() + "] recebeu um novo voto");
	}
	
	@Override
	public void enqueteComVotoRemovido(Enquete enquete) {
		System.out.println("\nEnviando email para " + this.getEmail() + "...");
		System.out.println("Usuário [" + this.getNome() + "]: \nA enquete [" + enquete.getTitulo() + "] teve um voto removido");
	}

}
