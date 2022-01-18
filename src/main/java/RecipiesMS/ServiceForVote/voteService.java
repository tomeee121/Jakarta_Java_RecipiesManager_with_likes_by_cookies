package RecipiesMS.ServiceForVote;

import RecipiesMS.DAO.RecipeDAO;
import RecipiesMS.JavaModels.Recipe;
import RecipiesMS.JavaModels.Vote;
import RecipiesMS.JavaModels.VoteToAdd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class voteService {
    private RecipeDAO voteDao = new RecipeDAO();
    private VoteMapper voteMapper = new VoteMapper();

    public void addVote(VoteToAdd vote) {
        Vote voteToSave = voteMapper.map(vote);
        voteDao.addVote(voteToSave);
    }

    private static class VoteMapper {
        Vote map(VoteToAdd vote) {
            return new Vote(
                    vote.getRecipeId(),
                    Vote.Type.valueOf(vote.getType()),
                    LocalDateTime.now()
            );
        }
    }


    public Integer getCounter(List<Recipe> recipies){

        RecipeDAO ref = new RecipeDAO();
        Integer counter = 0;

        for(Recipe one : recipies){
            Integer id = one.getId();
            counter = ref.countVotes(id);
        }
        return counter;
    }

    public List<Recipe> getRecipiesWithCounter(List<Recipe> recipies, Integer counter){
        List<Recipe> recipiesWithCounter = new ArrayList<>();

        for(Recipe one : recipies) {
            Integer id = one.getId();
            String title = one.getTitle();
            String ingredients = one.getIngredients();
            String desciption = one.getDesciption();
            int preptime = one.getPreptime();
            Recipe recipe = new Recipe(id,title,ingredients,desciption,preptime,counter);
            recipiesWithCounter.add(recipe);
        }
        return recipiesWithCounter;
    }
}