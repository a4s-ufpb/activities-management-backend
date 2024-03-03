package apps4Society.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import apps4Society.domain.model.Questao;
import apps4Society.domain.repository.QuestaoRepository;
import apps4Society.domain.service.exception.ObjetoEmUsoException;
import apps4Society.domain.service.exception.ObjetoNaoEncontradoException;
import apps4Society.infrastructure.repository.exception.NaoEncontradoException;

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
	
	
	public Questao atualizar(Questao questao) {
		return questaoRepository.adicionar(questao);
	}
	
	public void remover(Long id) {
		try {
			questaoRepository.remover(id);
		} catch (NaoEncontradoException e) {
			throw new ObjetoNaoEncontradoException(String.format("Não existe uma questão com o ID: %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new ObjetoEmUsoException(String.format("Questão de código %d não pode ser removida, pois está em uso",id));
		}
		
	}
	
	public List<Questao> listar(){
		return questaoRepository.todas();
	}
	
	public Questao buscarId(Long id) {
		return questaoRepository.BuscarPorID(id);
	}
	
	
	
}
