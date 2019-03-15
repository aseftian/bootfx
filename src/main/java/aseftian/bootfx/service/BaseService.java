package aseftian.bootfx.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService <T extends Object, ID extends Serializable> {
	
	<S extends T> List<S> save(Iterable<S> itrbl);
	
	<S extends T> S save(S entity);
	
	<S extends T> S update(S entity);
	
	<S extends T> Optional<S> findOne(ID id);
	
	List<T> findAll();
	
	Page<T> findAll(Pageable pgb);
	
	void delete(ID id);
	
	void deleteInBatch(List<T> entities);

}
