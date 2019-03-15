package aseftian.bootfx.service;

import aseftian.bootfx.domain.User;

public interface UserService extends BaseService<User, String> {
	
	boolean authenticate(String username, String password);

	User findByUsername(String username);
}
