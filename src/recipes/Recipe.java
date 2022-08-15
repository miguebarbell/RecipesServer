package recipes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "recipe")
@Table(name = "recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	@JsonIgnore
	private Integer id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	@ElementCollection
	private List<String> ingredients;
	@Column
	@ElementCollection
	private List<String> directions;
	@Column
	private String category;
	@Column
	private String date;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@JsonCreator
	public Recipe(@JsonProperty("name") String name,
	              @JsonProperty("description") String description,
								@JsonProperty("category") String category,
	              @JsonProperty("ingredients") List<String> ingredients,
	              @JsonProperty("directions") List<String> directions) {
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.directions = directions;
		this.category = category;
		this.date = LocalDateTime.now().toString();
	}
	public Recipe() {

	}
	public boolean validateRecipe() {
		if (this.name == null ||
				this.description == null ||
				this.ingredients == null ||
				this.directions == null ||
				this.category == null ||
				this.name.equals("null") ||
				this.description.equals("null") ||
				this.name.isBlank() ||
				this.name.isBlank() ||
				this.category.isBlank() ||
				this.description.isBlank() ||
				this.ingredients.size() < 1 ||
				this.directions.size() < 1) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			return false;
		}
		return true;
	}


}
