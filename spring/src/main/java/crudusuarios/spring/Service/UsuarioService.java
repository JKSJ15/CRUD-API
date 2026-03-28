package crudusuarios.spring.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import crudusuarios.spring.Domain.Usuario;
import crudusuarios.spring.Repository.UsuarioRepository;
import crudusuarios.spring.dto.UsuarioDto;
import crudusuarios.spring.exceptions.UserNotFoundException;
import crudusuarios.spring.mapper.UsuarioMapping;

@Service
public class UsuarioService{
	private final UsuarioRepository ur;
	public UsuarioService(UsuarioRepository ur) {
		super();
		this.ur = ur;
	}
	//GETTERS MAPPING
	public List<UsuarioDto> listar() {
		return ur.findAll().stream().map(u -> UsuarioMapping.paraDto(u)).toList();
	}
	public UsuarioDto encontrarPeloId(long id) {
		Usuario usu = ur.findById(id).orElseThrow(()->new UserNotFoundException("Usuário não encontrado!"));
		return UsuarioMapping.paraDto(usu);
	}
	//POST MAPPING
	public ResponseEntity<UsuarioDto> salvar(UsuarioDto dto) {
		
		ur.save(UsuarioMapping.paraUsuario(dto));
		return new ResponseEntity<UsuarioDto>(( HttpStatus.CREATED));
	}
	//PUT MAPPING
	public void atualizar(long id, UsuarioDto dto) {
		if (!dto.getId().equals(id)) {
			throw new IllegalArgumentException("Ids de inserção e de busca não conferem!");
		}
		Usuario usu = ur.findById(id).orElseThrow(()->new UserNotFoundException("Usuário não encontrado!"));
		usu.setId(dto.getId());
		usu.setNome(dto.getNome());
		ur.save(usu);
	}
	//DELETE MAPPING
	public void deletar(long id) {
		UsuarioDto dto = encontrarPeloId(id);
		ur.delete(UsuarioMapping.paraUsuario(dto));
	}
}
