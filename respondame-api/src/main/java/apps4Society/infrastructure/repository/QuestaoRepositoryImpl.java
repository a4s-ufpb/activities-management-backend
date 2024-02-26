package apps4Society.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import apps4Society.domain.model.Questao;
import apps4Society.domain.repository.QuestaoRepository;
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
		return manager.merge(null);
	}

}
