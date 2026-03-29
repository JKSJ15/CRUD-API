package crudusuarios.spring.Service;

import java.util.List;
import org.springframework.stereotype.Service;
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
	public List<UsuarioDto> encontrarPeloNome(String nome) {
		return ur.findByNome(nome).stream().map(u-> UsuarioMapping.paraDto(u)).toList();
	}
	//POST MAPPING
	public UsuarioDto salvar(UsuarioDto dto) {
		if (ur.existsById(dto.getId())) {
	        throw new IllegalArgumentException("Já existe um usuário cadastrado com esse Id!");
	    }
		Usuario usuario = ur.save(UsuarioMapping.paraUsuario(dto));
	    return UsuarioMapping.paraDto(usuario);
	}
	//PUT MAPPING
	public void atualizar(long id, UsuarioDto dto) {
		if (!dto.getId().equals(id)) {
			throw new IllegalArgumentException("Ids de inserção e de busca não conferem!");
		}
		Usuario usu = ur.findById(id).orElseThrow(()->new UserNotFoundException("Usuário não encontrado!"));
		usu.setNome(dto.getNome());
		ur.save(usu);
	}
	//DELETE MAPPING
	public void deletar(long id) {
		Usuario usu = ur.findById(id).orElseThrow(()->new UserNotFoundException("Usuário não encontrado!"));
		ur.delete(usu);
	}
}
