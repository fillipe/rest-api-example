package br.com.fill.restapidemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fill.restapidemo.entity.Exemplo;
import br.com.fill.restapidemo.repository.ExemploRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ExemploController {
	
	Logger logger = LoggerFactory.getLogger(ExemploController.class);

	@Autowired
	private ExemploRepository repository;
	
	@GetMapping("/exemplos")
	public List<Exemplo> exemplos() {
		logger.info("Buscando todos os exemplos");
		return repository.busca();
	}

	@PostMapping("/exemplo")
	public ResponseEntity<Boolean>  adicionaExemplo(@RequestBody Exemplo exemplo) {
		logger.info("Adicionando o exemplo {}", exemplo);
		return new ResponseEntity<Boolean>(repository.adiciona(exemplo), HttpStatus.OK);
	}

	@GetMapping("/exemplo/{id}")
	public ResponseEntity<Exemplo> buscar(@PathVariable Integer id) {
		logger.info("Buscando um exemplo pelo id {}", id);
		return new ResponseEntity<Exemplo>(repository.busca(id), HttpStatus.OK);
	}

	@DeleteMapping("/exemplo/{id}")
	public ResponseEntity<Boolean> remover(@PathVariable Integer id) {
		logger.info("Deletando um exemplo pelo id {}", id);
		return new ResponseEntity<Boolean>(repository.remove(id), HttpStatus.OK);
	}

	@PutMapping("/exemplo")
	public ResponseEntity<Exemplo> updateFuncionario(@RequestBody Exemplo exemplo) {
		logger.info("Alterando um exemplo para {}", exemplo);
		return new ResponseEntity<Exemplo>(repository.altera(exemplo), HttpStatus.OK);
	}

}
