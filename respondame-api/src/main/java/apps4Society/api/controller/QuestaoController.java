package apps4Society.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import apps4Society.domain.model.Questao;
import apps4Society.domain.repository.QuestaoRepository;

@RestController
@RequestMapping("/questao")
public class QuestaoController {

	@Autowired
	private QuestaoRepository questaoRepository;
	
	
	@GetMapping
	public List<Questao> listar(){
		return questaoRepository.todas();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Questao adicionar(@RequestBody Questao questao) {
		return questaoRepository.adicionar(questao);
	}
	
	@GetMapping("/{questaoId}")
	public ResponseEntity<Questao> buscarPorId(@PathVariable("questaoId") Long id) {
		Questao questao = questaoRepository.BuscarPorID(id);
		
		if (questao != null)
			return ResponseEntity.ok(questao);
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{questaoId}")
	public ResponseEntity<Questao> remover(@PathVariable("questaoId") Long id) {
		questaoRepository.remover(id);
		return ResponseEntity.noContent().build();
	}
}
