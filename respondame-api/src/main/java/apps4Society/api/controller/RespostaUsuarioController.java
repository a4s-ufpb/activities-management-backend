package apps4Society.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import apps4Society.domain.model.RespostaUsuario;
import apps4Society.domain.service.RespostaUsuarioService;
import apps4Society.domain.service.exception.ObjetoNaoEncontradoException;

@Controller
@RequestMapping("/respostaUsuario")
public class RespostaUsuarioController {

	@Autowired RespostaUsuarioService respostaUsuarioService;
	
	@GetMapping
	public List<RespostaUsuario> listar(){
		return respostaUsuarioService.listar();
	}
	
	@GetMapping("/{respostaUsuarioId}")
	public ResponseEntity<RespostaUsuario> buscarPorId(@PathVariable("respostaUsuarioId") Long id) {
		RespostaUsuario respostaUsuario = respostaUsuarioService.buscarId(id);
		
		if (respostaUsuario != null) {
			return ResponseEntity.ok(respostaUsuario);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping()
	public ResponseEntity<RespostaUsuario> adicionar(@RequestBody RespostaUsuario respostaUsuario){
		return ResponseEntity.ok(respostaUsuarioService.salvar(respostaUsuario));
	}
	
	@PutMapping("/{respostaUsuarioId}")
	public ResponseEntity<RespostaUsuario> atualizar(@PathVariable("respostaUsuarioId") Long id,@RequestBody RespostaUsuario respostaUsuario){
		RespostaUsuario respostaUsuarioAtual = respostaUsuarioService.buscarId(id);
		
		if(respostaUsuarioAtual != null) {
			BeanUtils.copyProperties(respostaUsuario, respostaUsuarioAtual, "id");
			respostaUsuarioAtual = respostaUsuarioService.atualizar(respostaUsuarioAtual);
			
			return ResponseEntity.ok(respostaUsuarioAtual);
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<RespostaUsuario> remover(Long id){
		
		try {
			respostaUsuarioService.remover(id);
			return ResponseEntity.noContent().build();
			
		} catch (ObjetoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();

		} 
//		catch (ObjetoEmUsoException e) {
//			return ResponseEntity.badRequest().build();
//					
//		}
	}
	
	
	
}
