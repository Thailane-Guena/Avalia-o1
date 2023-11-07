package com.nivaldo.aulaspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nivaldo.aulaspring.entities.Usuario;
import com.nivaldo.aulaspring.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	
	private UsuarioRepository repository;
	
	public List<Usuario> procurarTodos () {
		return repository.findAll();
	}
    public Usuario procurarId (Integer id)  {
    	
    	return repository.findById(id).get();
    }
    
    public String adicionaUsuario(Usuario usuario) {
    repository.save(usuario);
    return "Usuario adicionado com sucesso!";
    }
    public String editarUsuario(Integer id, Usuario usuario) {
    Usuario response = repository.findById(id).get();
    response.setNome(usuario.getNome());
    response.setEmail(usuario.getEmail());
    response.setSenha(usuario.getSenha());
    response.setMatricula(usuario.getMatricula());
    repository.save(response);
    return "Usuario editado com sucesso!"; 
    }
    public void excluirUsuario(Integer id) {
		Usuario response = repository.findById(id).get();
		repository.delete(response);
    
}}

