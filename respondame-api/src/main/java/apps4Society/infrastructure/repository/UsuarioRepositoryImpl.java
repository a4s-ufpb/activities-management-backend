package apps4Society.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import apps4Society.domain.model.Usuario;
import apps4Society.domain.repository.UsuarioRepository;
import apps4Society.infrastructure.repository.exception.NaoEncontradoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class UsuarioRepositoryImpl implements UsuarioRepository{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Usuario> todas() {
		return manager.createQuery("from Usuario", Usuario.class).getResultList();
	}

	@Override
	public Usuario adicionar(Usuario usuario) {
		return manager.merge(usuario);
	}

	@Override
	public Usuario BuscarPorID(Long id) {
		return manager.find(Usuario.class, id);
	}

	@Override
	public void remover(Long id) {
		Usuario usuario = BuscarPorID(id);
		if (usuario == null) 
			throw new NaoEncontradoException("1");
		
		manager.remove(usuario);
	}

}
