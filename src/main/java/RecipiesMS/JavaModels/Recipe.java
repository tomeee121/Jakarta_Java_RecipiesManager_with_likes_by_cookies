package RecipiesMS.JavaModels;

public class Recipe {
    private Integer id;
    private String title;
    private String ingredients;
    private String desciption;
    private int preptime;
    private Integer counter;

    public Recipe(String title, String ingredients, String desciption, int preptime) {
        this.title = title;
        this.ingredients = ingredients;
        this.desciption = desciption;
        this.preptime = preptime;
    }

    public Recipe(Integer id, String title, String ingredients, String desciption, int preptime) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.desciption = desciption;
        this.preptime = preptime;
    }

    public Recipe(Integer id, String title, String ingredients, String desciption, int preptime, Integer counter) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.desciption = desciption;
        this.preptime = preptime;
        this.counter = counter;
    }

    public Recipe(String title, String ingredients, String desciption, int preptime, Integer counter) {
        this.title = title;
        this.ingredients = ingredients;
        this.desciption = desciption;
        this.preptime = preptime;
        this.counter = counter;
    }

    public Integer getCounter() {
        return counter;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDesciption() {
        return desciption;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", desciption='" + desciption + '\'' +
                ", preptime=" + preptime +
                '}';
    }
}
