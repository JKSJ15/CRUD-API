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
public class UsuarioService{
	private final UsuarioRepository ur;
	public UsuarioService(UsuarioRepository ur) {
		super();
		this.ur = ur;
	}
	//GETTERS MAPPING
	public List<Usuario> listar() {
		return ur.findAll();
	}
	public Usuario encontrarPeloId(long id) {
		return ur.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id do usuário não encontrado!"));
	}
	//POST MAPPING
	public ResponseEntity<Usuario> salvar(Usuario usu) {
		ur.save(usu);
		return new ResponseEntity<Usuario>(( HttpStatus.CREATED));
	}
	//PUT MAPPING
	public void atualizar(long id, Usuario usuario) {
		if (usuario.getId()!=id) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ids de busca e de inserção são distintos!");
		}
		ur.delete(encontrarPeloId(id));
		salvar(usuario);
	}
	//DELETE MAPPING
	public void deletar(long id) {
		ur.delete(encontrarPeloId(id));
	}
}
