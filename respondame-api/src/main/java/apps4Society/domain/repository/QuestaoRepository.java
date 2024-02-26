package apps4Society.domain.repository;

import java.util.List;

import apps4Society.domain.model.Questao;

public interface QuestaoRepository {

	List<Questao> todas();
	Questao adicionar(Questao questao);
	
}
