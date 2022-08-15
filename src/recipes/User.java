package recipes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String email;

	@Column
	private String password;

	public List<Recipe> getRecipes() {
		return recipes;
	}

	@Column
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Recipe> recipes = new ArrayList<>();

	public String getRole() {
		return role;
	}

	@Column
	private String role;

	public String getEmail() {
		return email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public User(String email, String password) {
		this.email = email;
		this.password = password;
		this.role = "ROLE_USER";
	}
	public User() {
	}
}
