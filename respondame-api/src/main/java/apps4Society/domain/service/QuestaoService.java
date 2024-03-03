package apps4Society.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import apps4Society.domain.model.Questao;
import apps4Society.domain.repository.QuestaoRepository;
import apps4Society.domain.service.exception.ObjetoEmUsoException;
import apps4Society.domain.service.exception.ObjetoNaoEncontradoException;

@Service
public class QuestaoService {

	@Autowired QuestaoRepository questaoRepository;
	
	public Questao salvar(Questao questao) {
		/*List<Questao> questoesList = new ArrayList<>();  
		questoesList.add(questaoRepository.todas().stream().forEach(q -> questao.equals(q)));
		
		if(questoesList.isEmpty())
			return questaoRepository.adicionar(questao);
		*/
		return questaoRepository.adicionar(questao);
	}
	
	public void remover(Long id) {
		
		try {
			questaoRepository.remover(id);
		} catch (IllegalArgumentException e) {
			throw new ObjetoNaoEncontradoException(String.format("Não existe uma questão com o ID: %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new ObjetoEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso",id));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
