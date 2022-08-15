package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeService {
	private final RecipeRepository recipeRepository;

	@Autowired
	public RecipeService(RecipeRepository recipeRepository) {
			this.recipeRepository = recipeRepository;
	}

	public Recipe findById(Integer id) {
		return recipeRepository.findById(id).orElse(null);
	}

	public Recipe save(Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	public boolean deleteById(Integer id) {
		Recipe recipeResult = findById(id);
		if (recipeResult != null) {
			recipeRepository.deleteById(id);
			return true;
		}
		return false;
	}
	public boolean updateById(Integer id, Recipe recipe) {
		Recipe recipeResult = findById(id);
    if (recipeResult != null) {
//      if (!recipeResult.getCategory().equals(recipe.getCategory())) recipeResult.setCategory(recipe.getCategory());
//			if (!recipeResult.getName().equals(recipe.getName())) recipeResult.setName(recipe.getName());
//			if (!recipeResult.getDescription().equals(recipe.getDescription())) recipeResult.setDescription(recipe.getDescription());
//			if (!recipeResult.getDirections().equals(recipe.getDirections())) recipeResult.setDirections(recipe.getDirections());
//			if (!recipeResult.getIngredients().equals(recipe.getIngredients())) recipeResult.setIngredients(recipe.getIngredients());
	    recipeResult.setName(recipe.getName());
			recipeResult.setDescription(recipe.getDescription());
	    recipeResult.setDirections(recipe.getDirections());
			recipeResult.setIngredients(recipe.getIngredients());
			recipeResult.setCategory(recipe.getCategory());
			recipeResult.setDate(LocalDateTime.now().toString());
			recipeRepository.save(recipeResult);
      return true;
    }
		return false;
	}
	public List<Recipe> searchRecipes(String name, String category) {
		System.out.println("name = " + name);
		System.out.println("category = " + category);
		SortByDate sort = new SortByDate();
		List<Recipe> recipes = recipeRepository.findAll();
		if (category == null)	{
			recipes = recipes.stream().filter(recipe -> recipe.getName().toLowerCase()
			                                                  .contains(name.toLowerCase())).sorted(sort)
			                 .toList();
		}
		if (name == null) {
			recipes =
					recipes.stream().filter(recipe -> recipe.getCategory().toLowerCase()
					                                        .equals(category.toLowerCase())).sorted(sort)
					       .toList();
		}
//		List<Recipe> recipesSorted = recipes.sort((a,b) -> sort.compare(a,b));
		return recipes;
		}
	}
