package crudusuarios.spring.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import crudusuarios.spring.Domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Page<Usuario> findByNome(String nome, Pageable pageable);
}
