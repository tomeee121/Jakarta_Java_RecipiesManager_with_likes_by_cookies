package RecipiesMS.Controllers;

import RecipiesMS.DAO.RecipeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delete")
public class ServletDeleteRecipe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDAO DAO = new RecipeDAO();
        String title = request.getParameter("title");
        Integer id = DAO.findRecipeId(title).orElseThrow(() -> new NullPointerException());
        boolean ifDeleted = DAO.deleteRecipe(id);
        if(ifDeleted){
            response.sendRedirect("/recipiesNEW");
        }
        else throw new NullPointerException();

    }
}