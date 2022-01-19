package RecipiesMS.Controllers;

import RecipiesMS.DAO.RecipeDAO;
import RecipiesMS.JavaModels.Recipe;
import RecipiesMS.ServiceForVote.voteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("")
public class ServletRecipies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDAO ref = new RecipeDAO();
        voteService voteService = new voteService();

        List<Recipe> recipies = ref.getRecipies();
        request.setCharacterEncoding("UTF-8");

        List<Integer> sumsOfVotes = voteService.getCounter(recipies);

        List<Recipe> recipiesWithVotesSums = getRecipiesWithVotesSums(recipies, sumsOfVotes);

        request.setAttribute("recipies",recipiesWithVotesSums);

        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }

    private List<Recipe> getRecipiesWithVotesSums (List<Recipe> recipies, List<Integer> sums){
        int i = 0;
        Integer[] sumsOfVotes = sums.stream().toArray(Integer[]::new);
        List<Recipe> recipiesWithSums = new ArrayList<>();
        for(Recipe one : recipies){
            Integer id = one.getId();
            String title = one.getTitle();
            String ingredients = one.getIngredients();
            String desciption = one.getDesciption();
            int preptime = one.getPreptime();
            Integer sum = sumsOfVotes[i];
            i++;
            Recipe recipe = new Recipe(id,title,ingredients,desciption,preptime,sum);
            recipiesWithSums.add(recipe);
        }
        return recipiesWithSums;
    }

}