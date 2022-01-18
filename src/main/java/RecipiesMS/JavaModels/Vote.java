package RecipiesMS.JavaModels;

import java.time.LocalDateTime;

public class Vote {
    private Integer id;
    private Integer recipeId;
    private Type type;
    private LocalDateTime dateAdded;

    public Vote(Integer recipeId, Type type, LocalDateTime dateAdded) {
        this.recipeId = recipeId;
        this.type = type;
        this.dateAdded = dateAdded;
    }

    public Vote(Integer recipeId, Type type) {
        this.recipeId = recipeId;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public enum Type {
        UP, DOWN;
    }
}
