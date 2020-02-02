package lostandfound.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lostandfound.excpetion.NoDataFoundExcpetion;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		// convert into a list
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(() -> new NoDataFoundExcpetion(userId));
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(String userId, User user) {
		try {
			userRepository.save(user);
		} catch (DataAccessException ex) {
			throw new NoDataFoundExcpetion(ex.getCause().getMessage());
		}
	}

	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

}
