package crudusuarios.spring.Controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import crudusuarios.spring.Domain.Usuario;
import crudusuarios.spring.Service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final UsuarioService us;
	public UsuarioController(UsuarioService us) {
		super();
		this.us = us;
	}
	
	@GetMapping()
	public ArrayList listar(){
		return us.listar();
	}
	@GetMapping(path = "/{id}")
	public Usuario encontrarPeloId(@PathVariable long id){
		return us.encontrarPeloId(id);
	}
	@PostMapping
	public void salvar(@RequestBody Usuario usuario) {
		us.salvar(usuario);
	}
	@PutMapping(path = "/{id}")
	public void atualizar(@PathVariable long id, @RequestBody Usuario usuario) {
		us.atualizar(id, usuario);
	}
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable long id) {
		us.deletar(id);
	}
}
