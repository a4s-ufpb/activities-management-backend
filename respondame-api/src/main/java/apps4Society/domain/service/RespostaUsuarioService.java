package apps4Society.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apps4Society.domain.model.RespostaUsuario;
import apps4Society.domain.repository.RespostaUsuarioRepository;
import apps4Society.domain.service.exception.ObjetoNaoEncontradoException;
import apps4Society.infrastructure.repository.exception.NaoEncontradoException;

@Service
public class RespostaUsuarioService {

	@Autowired RespostaUsuarioRepository respostaUsuarioRepository;
	
	public RespostaUsuario salvar(RespostaUsuario respostaUsuario) {
		/*List<Questao> questoesList = new ArrayList<>();  
		questoesList.add(questaoRepository.todas().stream().forEach(q -> questao.equals(q)));
		
		if(questoesList.isEmpty())
			return questaoRepository.adicionar(questao);
		*/
		return respostaUsuarioRepository.adicionar(respostaUsuario);
	}
	
	
	public RespostaUsuario atualizar(RespostaUsuario respostaUsuario) {
		return respostaUsuarioRepository.adicionar(respostaUsuario);
	}
	
	public void remover(Long id) {
		try {
			respostaUsuarioRepository.remover(id);
		} catch (NaoEncontradoException e) {
			throw new ObjetoNaoEncontradoException(String.format("Não existe uma resposta com o ID: %d", id));
		} 
//		catch (DataIntegrityViolationException e) {
//			throw new ObjetoEmUsoException(String.format("",id));
//		}
		
	}
	
	public List<RespostaUsuario> listar(){
		return respostaUsuarioRepository.todas();
	}
	
	public RespostaUsuario buscarId(Long id) {
		return respostaUsuarioRepository.BuscarPorID(id);
	}
	
}
