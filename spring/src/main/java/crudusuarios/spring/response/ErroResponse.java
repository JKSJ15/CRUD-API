package crudusuarios.spring.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErroResponse {
	private String mensagem;
	private LocalDateTime tempo;
	private HttpStatus erro;
	private int status;

	public ErroResponse(String mensagem, LocalDateTime tempo, HttpStatus erro, int status) {
		super();
		this.mensagem = mensagem;
		this.tempo = tempo;
		this.erro = erro;
		this.status = status;
	}


	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDateTime getTempo() {
		return tempo;
	}

	public void setTempo(LocalDateTime tempo) {
		this.tempo = tempo;
	}


	public HttpStatus getErro() {
		return erro;
	}


	public void setErro(HttpStatus erro) {
		this.erro = erro;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	
	
	
	
}
