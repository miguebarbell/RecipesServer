package recipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class UserRepository {
	final private Map<String, User> users = new ConcurrentHashMap<>();
	public User findById(String id) {
		return users.get(id);
	}
	public boolean save(User user) {
		if (!users.containsValue(user.getEmail())) {
			users.put(user.getEmail(), user);
			return true;
		} else return false;
	}
}
