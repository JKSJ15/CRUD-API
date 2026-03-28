package crudusuarios.spring.exceptions.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import crudusuarios.spring.exceptions.UserNotFoundException;
import crudusuarios.spring.response.ErroResponse;


@RestControllerAdvice
public class GlobalHandlerException {
	@ExceptionHandler()
	public ResponseEntity<ErroResponse> trataIllegalArgumentException(IllegalArgumentException e){
		ErroResponse erro =new ErroResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	} 
	@ExceptionHandler()
	public ResponseEntity<ErroResponse> trataUserNotFoundException(UserNotFoundException e){
		ErroResponse erro =new ErroResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	} 
}
