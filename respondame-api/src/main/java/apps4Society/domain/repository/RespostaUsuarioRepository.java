package apps4Society.domain.repository;

import java.util.List;

import apps4Society.domain.model.RespostaUsuario;

public interface RespostaUsuarioRepository {

	List<RespostaUsuario> todas();
	RespostaUsuario adicionar(RespostaUsuario respostaUsuario);
	RespostaUsuario BuscarPorID(Long id);
	void remover(Long id);
}
