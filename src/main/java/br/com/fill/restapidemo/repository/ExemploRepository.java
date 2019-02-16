package br.com.fill.restapidemo.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fill.restapidemo.entity.Exemplo;

@Repository
public class ExemploRepository {

private List<Exemplo> exemplos;
	
	public ExemploRepository() {
		this.exemplos = new ArrayList<>();
		exemplos.addAll(Arrays.asList(new Exemplo(1, "A"), new Exemplo(2, "B"), new Exemplo(3, "C")));
	}
	
	public Boolean adiciona(Exemplo exemplo) {
		return exemplos.add(exemplo);
	}

	public Boolean remove(Integer id) {
		return exemplos.removeIf(ex -> ex.getId().equals(id));
	}
	
	public Exemplo altera(Exemplo exemplo) {
		Exemplo alterado = exemplos.stream().filter(ex -> ex.getId().equals(exemplo.getId())).findFirst().get();
		alterado.setNome(exemplo.getNome());
		return alterado;
	}
	
	public Exemplo busca(Integer id) {
		return exemplos.stream().filter(ex -> ex.getId().equals(id)).findFirst().get();
	}
	
	public List<Exemplo> busca() {
		return exemplos;
	}
	
}
