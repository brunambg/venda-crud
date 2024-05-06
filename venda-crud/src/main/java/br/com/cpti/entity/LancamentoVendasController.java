package br.com.cpti.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpti.repository.LancamentoVendasRepository;

@RestController
@RequestMapping("/LancamentoVendas")

public class LancamentoVendasController {

	@Autowired
	private LancamentoVendasRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LancamentoVendas inserir(@RequestBody LancamentoVendas lv) {
		return repository.save(lv);
	}
	
	@GetMapping
	public List<LancamentoVendas> listar(){
		return repository.findAll();
	}
	
@GetMapping("{id}")
public ResponseEntity<LancamentoVendas> buscar(@PathVariable Long codigoVenda){
	Optional<LancamentoVendas> lancamentovendas = repository.findById(codigoVenda);
	if (lancamentovendas.isPresent()) {
		return ResponseEntity.ok(lancamentovendas.get());
	}
	return ResponseEntity.notFound().build();
}

@PutMapping("{codVendedor}")
public ResponseEntity<LancamentoVendas> alterar(@PathVariable Long codigoVenda, @RequestBody LancamentoVendas lv){
	Optional<LancamentoVendas> lancamentovendas = repository.findById(codigoVenda);
	if (lancamentovendas.isPresent()) {
		lv.setCodigoVenda(codigoVenda);
		repository.save(lv);
		return ResponseEntity.ok(lv);
	}
	return ResponseEntity.notFound().build();
}
	
@DeleteMapping("{id}")
public ResponseEntity<LancamentoVendas> apagar(@PathVariable Long codigoVenda){

	if (repository.existsById(codigoVenda)) {
		repository.deleteById(codigoVenda);
		return ResponseEntity.noContent().build();
	}
	return ResponseEntity.notFound().build();
}
}

