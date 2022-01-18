package RecipiesMS.Controllers;

import RecipiesMS.DAO.RecipeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateOrInsert")
public class ServletUpdateOrInsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/WEB-INF/updateOrInsert.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDAO DAO = new RecipeDAO();
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Integer id = DAO.findRecipeId(title).orElseThrow(() -> new NullPointerException());
        DAO.updateOrAddDescription(id,description);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;Charset=UTF-8");
        response.sendRedirect("/recipiesNEW");

    }
}