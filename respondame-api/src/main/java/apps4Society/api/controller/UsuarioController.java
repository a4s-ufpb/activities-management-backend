package apps4Society.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import apps4Society.domain.model.Usuario;
import apps4Society.domain.service.UsuarioService;
import apps4Society.domain.service.exception.ObjetoEmUsoException;
import apps4Society.domain.service.exception.ObjetoNaoEncontradoException;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listar(){
		return usuarioService.listar();
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> BuscarPorId(@PathVariable("usuarioId") Long id){
		Usuario usuarioAtual = usuarioService.buscarId(id);
		if(usuarioAtual != null)
			return ResponseEntity.ok(usuarioAtual);
			
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> atualizar(@PathVariable("usuarioId") Long id,@RequestBody Usuario usuario){
		Usuario usuarioAtual = usuarioService.buscarId(id);
		if (usuarioAtual != null) {
			BeanUtils.copyProperties(usuario, usuarioAtual, "id");
			usuarioAtual = usuarioService.atualizar(usuarioAtual);
			
			return ResponseEntity.ok(usuarioAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Usuario> remover(@PathVariable("usuarioId") Long id){
		
		try {
			usuarioService.remover(id);
			return ResponseEntity.notFound().build();
			
		} catch (ObjetoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
			
		} catch (ObjetoEmUsoException e) {
			return ResponseEntity.badRequest().build();
			
		}
	}
}
