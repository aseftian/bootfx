package aseftian.bootfx.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aseftian.bootfx.domain.User;
import aseftian.bootfx.repository.UserRepository;
import aseftian.bootfx.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public <S extends User> List<S> save(Iterable<S> itrbl) {
		return userRepo.saveAll(itrbl);
	}

	@Override
	public <S extends User> S save(S entity) {
		return userRepo.save(entity);
	}

	@Override
	public <S extends User> S update(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends User> Optional<S> findOne(String id) {
		return (Optional<S>) userRepo.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public Page<User> findAll(Pageable pgb) {
		return userRepo.findAll(pgb);
	}

	@Override
	public void delete(String id) {
		userRepo.deleteById(id);
	}

	@Override
	public boolean authenticate(String username, String password) {
		User user = this.findByUsername(username);
		if (user == null) {
			return false;
		} else {
			if (password.equals(user.getPassword()))
				return true;
			else
				return false;
		}
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public void deleteInBatch(List<User> entities) {
		userRepo.deleteInBatch(entities);
	}

}
