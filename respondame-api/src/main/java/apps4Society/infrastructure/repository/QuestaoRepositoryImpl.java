package apps4Society.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import apps4Society.domain.model.Questao;
import apps4Society.domain.repository.QuestaoRepository;
import apps4Society.infrastructure.repository.exception.NaoEncontradoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class QuestaoRepositoryImpl implements QuestaoRepository {

//	GERENCIA TUDO
	@PersistenceContext
	private EntityManager manager; 
	
	
	@Override
	public List<Questao> todas() {
		return manager.createQuery("from Questao", Questao.class).getResultList();
	}

	@Transactional
	@Override
	public Questao adicionar(Questao questao) {
		return manager.merge(questao);
	}

	@Override
	public Questao BuscarPorID(Long id) {
		return manager.find(Questao.class, id);
	}	

	@Transactional
	@Override
	public void remover(Long id) {
		Questao questao = BuscarPorID(id);
		
		if(questao == null)
			throw new NaoEncontradoException("1");
//		IllegalArgumentException TRATAR
		manager.remove(questao);
	}

}
