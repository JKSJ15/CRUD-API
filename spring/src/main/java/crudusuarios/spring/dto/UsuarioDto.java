package crudusuarios.spring.dto;

public class UsuarioDto {
	private String nome;
	private Long id;
	public UsuarioDto() {}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
