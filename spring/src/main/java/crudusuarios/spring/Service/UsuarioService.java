package crudusuarios.spring.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import crudusuarios.spring.Domain.Usuario;
import crudusuarios.spring.Repository.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioRepository{
	private ArrayList<Usuario> usuarios = new ArrayList<>(List.of(new Usuario("Jakson", 1L), new Usuario("Abreu e lima", 2L), new Usuario("Kaká", 3L),
			new Usuario("Maria", 4L), new Usuario("Roque", 5L), new Usuario("Josefa", 6L), new Usuario("Fulano", 7L), new Usuario("Fulana", 8L), new Usuario("Yago", 9L), new Usuario("Tatiane", 10L)));

	//GETTERS MAPPING
	@Override
	public ArrayList<Usuario> listar() {
		return usuarios;
	}
	@Override
	public Usuario encontrarPeloId(long id) {
		return usuarios.stream().filter(n -> n.getId() == id).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id do usuário não encontrado!"));
	}
	//POST MAPPING
	@Override
	public ResponseEntity<Usuario> salvar(Usuario usu) {
		usuarios.add(usu);
		return new ResponseEntity<Usuario>(( HttpStatus.CREATED));
	}
	//PUT MAPPING
	@Override
	public void atualizar(long id, Usuario usuario) {
		deletar(id);
		salvar(usuario);
	}
	//DELETE MAPPING
	@Override
	public void deletar(long id) {
		usuarios.remove(encontrarPeloId(id));
	}
}
