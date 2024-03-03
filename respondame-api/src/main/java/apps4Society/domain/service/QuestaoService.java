package apps4Society.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apps4Society.domain.model.Questao;
import apps4Society.domain.repository.QuestaoRepository;

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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
