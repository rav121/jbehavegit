package competency.center.bdd;

import java.util.HashSet;
import java.util.Set;

import competency.center.bdd.User;

public class UserDao {

	private final Set<User>    users    = new HashSet<User>();
	 
	 public void save(final User user) {
	 users.add(user);
	 }
	 
	 public Set<User> findAll() {
	 return users;
	 }
}
