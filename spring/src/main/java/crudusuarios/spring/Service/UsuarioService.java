package crudusuarios.spring.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<UsuarioDto> listar(Pageable pageable) {
		return ur.findAll(pageable)
	             .map(UsuarioMapping::paraDto);
	}
	public UsuarioDto encontrarPeloId(long id) {
		Usuario usu = ur.findById(id).orElseThrow(()->new UserNotFoundException("Usuário não encontrado!"));
		return UsuarioMapping.paraDto(usu);
	}
	public Page<UsuarioDto> encontrarPeloNome(String nome, Pageable pageable) {
		return ur.findByNome(nome, pageable)
	             .map(UsuarioMapping::paraDto);
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
