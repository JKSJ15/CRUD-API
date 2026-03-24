package crudusuarios.spring.Repository;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import crudusuarios.spring.Domain.Usuario;

public interface UsuarioRepository {
	public ArrayList<Usuario> listar();
	public Usuario encontrarPeloId(long id);
	public ResponseEntity<Usuario> salvar(Usuario usuario);
	public void atualizar(long id, Usuario usuario);
	public void deletar(long id);
}
