package crudusuarios.spring.mapper;

import crudusuarios.spring.Domain.Usuario;
import crudusuarios.spring.dto.UsuarioDto;

public class UsuarioMapping {
	public static Usuario paraUsuario(UsuarioDto dto) {
		Usuario usu = new Usuario(dto.getNome(), dto.getId());
		return usu;
	}
	public static UsuarioDto paraDto(Usuario usu) {
		UsuarioDto dto = new UsuarioDto();
		dto.setId(usu.getId());
		dto.setNome(usu.getNome());
		return dto;
	}
}
