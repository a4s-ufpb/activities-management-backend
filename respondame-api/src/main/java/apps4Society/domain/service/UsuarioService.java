package apps4Society.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import apps4Society.domain.model.Usuario;
import apps4Society.domain.repository.UsuarioRepository;
import apps4Society.domain.service.exception.ObjetoEmUsoException;
import apps4Society.domain.service.exception.ObjetoNaoEncontradoException;
import apps4Society.infrastructure.repository.exception.NaoEncontradoException;

public class UsuarioService {

	@Autowired UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		/*List<Questao> questoesList = new ArrayList<>();  
		questoesList.add(questaoRepository.todas().stream().forEach(q -> questao.equals(q)));
		
		if(questoesList.isEmpty())
			return questaoRepository.adicionar(questao);
		*/
		return usuarioRepository.adicionar(usuario);
	}
	
	
	public Usuario atualizar(Usuario usuario) {
		return usuarioRepository.adicionar(usuario);
	}
	
	public void remover(Long id) {
		try {
			usuarioRepository.remover(id);
		} catch (NaoEncontradoException e) {
			throw new ObjetoNaoEncontradoException(String.format("Não existe uma questão com o ID: %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new ObjetoEmUsoException(String.format("Usuário de código %d não pode ser removida, pois está em uso",id));
		}
		
	}
	
	public List<Usuario> listar(){
		return usuarioRepository.todas();
	}
	
	public Usuario buscarId(Long id) {
		return usuarioRepository.BuscarPorID(id);
	}
	
}
