package crudusuarios.spring.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import crudusuarios.spring.Domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	List<Usuario> findByNome(String nome);
}
