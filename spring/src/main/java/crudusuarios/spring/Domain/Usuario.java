package crudusuarios.spring.Domain;

import java.util.ArrayList;
import java.util.Objects;

import crudusuarios.spring.Repository.UsuarioRepository;

public class Usuario{
	private String nome;
	private long id;
	
	public Usuario(String nome, long id) {
		super();
		this.nome = nome;
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", id=" + id + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
