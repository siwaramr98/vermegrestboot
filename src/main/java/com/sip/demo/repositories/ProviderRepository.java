package com.sip.demo.repositories;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sip.demo.entities.Provider;
@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
