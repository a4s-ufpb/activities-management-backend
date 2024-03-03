package apps4Society.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import apps4Society.domain.model.RespostaUsuario;
import apps4Society.domain.repository.RespostaUsuarioRepository;
import apps4Society.infrastructure.repository.exception.NaoEncontradoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class RespostaUsuarioRepositoryImpl implements RespostaUsuarioRepository {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<RespostaUsuario> todas() {
		return manager.createQuery("from RespostaUsuario",RespostaUsuario.class).getResultList();
	}

	@Override
	public RespostaUsuario adicionar(RespostaUsuario respostaUsuario) {
		return manager.merge(respostaUsuario);
	}

	@Override
	public RespostaUsuario BuscarPorID(Long id) {
		return manager.find(RespostaUsuario.class, id);
	}

	@Override
	public void remover(Long id) {
		RespostaUsuario respotaRespostaUsuario = BuscarPorID(id);
		if(respotaRespostaUsuario == null)
			throw new NaoEncontradoException("1");
		
		manager.remove(respotaRespostaUsuario);
	}

	
}
