package recipes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class RecipesApplication {

public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }
//  @RestController
//  public class RecipeController {
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Autowired
//    RecipeService recipeService;
//    @PostMapping("/api/recipe/new")
//    public String createRecipe(@RequestBody Recipe newRecipe) throws JsonProcessingException {
//      System.out.println("POST new = " + newRecipe.toString());
//      if (newRecipe.validateRecipe()) {
//        Integer id = recipeService.save(newRecipe).getId();
//        Map<String, Integer> map = new HashMap<>();
//        map.put("id", id);
//        return objectMapper.writeValueAsString(map);
//      }
//      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//
//    }
//    @GetMapping("/api/recipe/{id}")
//    public String getRecipe(@PathVariable Integer id) throws JsonProcessingException {
//      System.out.println("GET recipe = " + id);
//      Recipe recipeResult = recipeService.findById(id);
//      if (recipeResult == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//      return objectMapper.writeValueAsString(recipeResult);
//    }
//    @DeleteMapping("/api/recipe/{id}")
//    public HttpStatus deleteRecipe(@PathVariable Integer id) {
//      System.out.println("DELETE recipe = " + id);
//      if (recipeService.deleteById(id)) {
//        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
//      } else {
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//      }
//    }
//    @PutMapping("/api/recipe/{id}")
//    public void updateRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
//      System.out.println("UPDATE recipe " + recipe);
//      if (!recipe.validateRecipe()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//      if (recipeService.updateById(id, recipe)) {
//        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
//      } else {
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//      }
//    }
//    @GetMapping("/api/recipe/search/")
//    public String searchRecipes(@RequestParam(required = false) String name, @RequestParam(required = false) String category) throws JsonProcessingException {
//      System.out.println("search name=" + name + " category=" + category);
//      if (((name == null) && (category == null)) ||
//          ((category != null) && (name != null))
//      ){
//        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//      }
//      return objectMapper.writeValueAsString(recipeService.searchRecipes(name, category));
//    }
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder encoder;
//    @PostMapping("/api/register")
//    public String registerUser(@RequestBody User user) throws JsonProcessingException {
//      user.setPassword(encoder.encode(user.getPassword()));
//      if (userRepository.save(user)) {
//        System.out.println("created");
//      } else System.out.println("email already registered");
//      System.out.println(objectMapper.writeValueAsString(userRepository.findById(user.getEmail())));
//      return objectMapper.writeValueAsString(user);
//    }
//  }
}
