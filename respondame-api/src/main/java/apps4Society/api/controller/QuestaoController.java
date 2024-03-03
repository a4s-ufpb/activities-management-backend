package apps4Society.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import apps4Society.domain.model.Questao;
import apps4Society.domain.repository.QuestaoRepository;
import apps4Society.domain.service.QuestaoService;
import apps4Society.domain.service.exception.ObjetoEmUsoException;
import apps4Society.domain.service.exception.ObjetoNaoEncontradoException;

@RestController
@RequestMapping("/questao")
public class QuestaoController {

	@Autowired
	private QuestaoRepository questaoRepository;
	
	@Autowired
	private QuestaoService questaoService ;
	
	@GetMapping
	public List<Questao> listar(){
		return questaoService.listar();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Questao adicionar(@RequestBody Questao questao) {
		return questaoService.salvar(questao);
	}
	
	@GetMapping("/{questaoId}")
	public ResponseEntity<Questao> buscarPorId(@PathVariable("questaoId") Long id) {
		Questao questao = questaoRepository.BuscarPorID(id);
		
		if (questao != null)
			return ResponseEntity.ok(questao);
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{questaoId}")
	public ResponseEntity<Questao> atualizar(@PathVariable("questaoId") Long id, @RequestBody Questao questao){
		Questao questaoAtual = questaoService.buscarId(id);
		
		if (questaoAtual != null) {
			BeanUtils.copyProperties(questao, questaoAtual, "id");
			questaoAtual = questaoService.atualizar(questaoAtual);
		 
			return ResponseEntity.ok(questaoAtual);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{questaoId}")
	public ResponseEntity<Questao> remover(@PathVariable("questaoId") Long id) {
		
		try {
			questaoService.remover(id);
			return ResponseEntity.noContent().build();
			
		} catch (ObjetoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();

		} catch (ObjetoEmUsoException e) {
			return ResponseEntity.badRequest().build();
					
		}
		
	}
}
