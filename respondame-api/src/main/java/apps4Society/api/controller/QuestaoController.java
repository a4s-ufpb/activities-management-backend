package apps4Society.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Questao adicionar(Questao questao) {
		return questaoRepository.adicionar(questao);
	}
}
