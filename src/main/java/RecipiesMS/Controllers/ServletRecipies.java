package RecipiesMS.Controllers;

import RecipiesMS.DAO.RecipeDAO;
import RecipiesMS.JavaModels.Recipe;
import RecipiesMS.ServiceForVote.voteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet("")
public class ServletRecipies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDAO ref = new RecipeDAO();
        voteService voteService = new voteService();

        List<Recipe> recipies = ref.getRecipies();
        request.setCharacterEncoding("UTF-8");

        Integer counter = voteService.getCounter(recipies);

        List<Recipe> recipiesWithCounter = voteService.getRecipiesWithCounter(recipies, counter);
        request.setAttribute("recipies",recipiesWithCounter);

        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }

}