package recipes;

import java.time.LocalDateTime;
import java.util.Comparator;

public class SortByDate implements Comparator<Recipe> {

	@Override
	public int compare(Recipe o1, Recipe o2) {
		LocalDateTime date1 = LocalDateTime.parse(o1.getDate());
		LocalDateTime date2 = LocalDateTime.parse(o2.getDate());
		return date2.compareTo(date1);
	}
}
