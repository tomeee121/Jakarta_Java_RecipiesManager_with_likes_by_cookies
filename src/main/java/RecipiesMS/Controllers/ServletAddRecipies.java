package RecipiesMS.Controllers;

import RecipiesMS.DAO.RecipeDAO;
import RecipiesMS.JavaModels.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/add")
public class ServletAddRecipies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Recipe recipe = createRecipe(request);
        RecipeDAO ref = new RecipeDAO();
        ref.addRecipe(recipe);
        request.setCharacterEncoding("UTF-8");
        response.sendRedirect("/recipiesNEW");
    }

    private Recipe createRecipe(HttpServletRequest request) {
        String title = request.getParameter("title");
        String preptimeString = request.getParameter("preptime");
        Integer preptime = Integer.valueOf(preptimeString);
        String ingredients = request.getParameter("ingredients");
        String description = request.getParameter("description");
        return new Recipe(title,ingredients,description,preptime);



    }


}