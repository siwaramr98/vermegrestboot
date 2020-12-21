package com.sip.demo.controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.sip.demo.entities.Provider;
import com.sip.demo.exception.ResourceNotFoundException;
import com.sip.demo.repositories.ProviderRepository;
@RestController
@RequestMapping({"/providers"})
@CrossOrigin(origins = "*")
public class ProviderRestController {
@Autowired
private ProviderRepository providerRepository;
@GetMapping("/list")
 public List<Provider> getAllProvider() {
 return (List<Provider>) providerRepository.findAll();
 }
@PostMapping("/add")
 public Provider createProvider(@Valid @RequestBody Provider provider) {
 return providerRepository.save(provider);
 }
@PutMapping("/{providerId}")
 public Provider updateProvider(@PathVariable Long providerId, @Valid
@RequestBody Provider providerRequest) {
 return providerRepository.findById(providerId).map(provider -> {
 provider.setName(providerRequest.getName());
 provider.setEmail(providerRequest.getEmail());
 provider.setAddress(providerRequest.getAddress());
 return providerRepository.save(provider);
 }).orElseThrow(() -> new ResourceNotFoundException("ProviderId " +
providerId + " not found"));
 }
@DeleteMapping("/{providerId}")
public Provider deleteProvider(@PathVariable Long providerId) {

	
	Provider provider = providerRepository.findById(providerId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + providerId));

	

	providerRepository.delete(provider);
	return provider;
   
}
@GetMapping("/{providerId}")
public Provider getProvider(@PathVariable Long providerId) {
	return providerRepository.findById(providerId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + providerId));

	
}

 /*@DeleteMapping("/{providerId}")
 public ResponseEntity<?> deleteProvider(@PathVariable Long providerId) {
 return providerRepository.findById(providerId).map(provider -> {
 providerRepository.delete(provider);
 return ResponseEntity.ok().build();
 }).orElseThrow(() -> new ResourceNotFoundException("ProviderId " +
providerId + " not found"));
 }*/
}
