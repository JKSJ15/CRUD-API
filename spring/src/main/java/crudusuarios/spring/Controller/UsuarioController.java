package crudusuarios.spring.Controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import crudusuarios.spring.Service.UsuarioService;
import crudusuarios.spring.dto.UsuarioDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final UsuarioService us;
	public UsuarioController(UsuarioService us) {
		super();
		this.us = us;
	}
	
	@GetMapping()
	public ResponseEntity<Page<UsuarioDto>> listar(Pageable pageable){
		return new ResponseEntity<>(us.listar(pageable), HttpStatus.OK);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioDto> encontrarPeloId(@PathVariable long id){
		return new ResponseEntity<>(us.encontrarPeloId(id), HttpStatus.OK);
	}
	@GetMapping(path = "/encontrar")
	public ResponseEntity<Page<UsuarioDto>> encontrarPeloNome(@RequestParam String nome, Pageable pageable){
		return new ResponseEntity<>(us.encontrarPeloNome(nome, pageable), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<UsuarioDto> salvar(@RequestBody @Valid UsuarioDto usuario) {
		return new ResponseEntity<>(us.salvar(usuario), HttpStatus.CREATED);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable long id, @RequestBody @Valid UsuarioDto usuario) {
		us.atualizar(id, usuario);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		us.deletar(id);
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}
}
