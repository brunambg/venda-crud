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

import br.com.cpti.repository.VendedorRepository;

@RestController
@RequestMapping("/vendedor")

public class VendedorController {

	@Autowired
	private VendedorRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor inserir(@RequestBody Vendedor v) {
		return repository.save(v);
	}
	
	@GetMapping
	public List<Vendedor> listar(){
		return repository.findAll();
	}
	
@GetMapping("{id}")
public ResponseEntity<Vendedor> buscar(@PathVariable Long codVendedor){
	Optional<Vendedor> vendedor = repository.findById(codVendedor);
	if (vendedor.isPresent()) {
		return ResponseEntity.ok(vendedor.get());
	}
	return ResponseEntity.notFound().build();
}

@PutMapping("{codVendedor}")
public ResponseEntity<Vendedor> alterar(@PathVariable Long codVendedor, @RequestBody Vendedor v){
	Optional<Vendedor> vendedor = repository.findById(codVendedor);
	if (vendedor.isPresent()) {
		v.setCodVendedor(codVendedor);
		repository.save(v);
		return ResponseEntity.ok(v);
	}
	return ResponseEntity.notFound().build();
}
	
@DeleteMapping("{id}")
public ResponseEntity<Vendedor> apagar(@PathVariable Long codVendedor){

	if (repository.existsById(codVendedor)) {
		repository.deleteById(codVendedor);
		return ResponseEntity.noContent().build();
	}
	return ResponseEntity.notFound().build();
}
}
