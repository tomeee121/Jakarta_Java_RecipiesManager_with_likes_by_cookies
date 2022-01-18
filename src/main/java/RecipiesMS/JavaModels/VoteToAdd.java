package RecipiesMS.JavaModels;

public class VoteToAdd {
    private Integer recipeId;
    private String type;

    public VoteToAdd(Integer recipeId, String type) {
        this.recipeId = recipeId;
        this.type = type;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public String getType() {
        return type;
    }
}

