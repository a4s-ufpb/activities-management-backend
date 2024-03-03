package apps4Society.domain.repository;

import java.util.List;

import apps4Society.domain.model.Usuario;

public interface UsuarioRepository {

	List<Usuario> todas();
	Usuario adicionar(Usuario usuario);
	Usuario BuscarPorID(Long id);
	void remover(Long id);
}
