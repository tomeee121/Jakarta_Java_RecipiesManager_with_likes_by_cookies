package RecipiesMS.Controllers;

import RecipiesMS.DAO.RecipeDAO;
import RecipiesMS.JavaModels.Log;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/vote")
public class FilterVote implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String ip = request.getRemoteAddr();
        String userAgent = ((HttpServletRequest) request).getHeader("user-agent");
        String recipeIdString = ((HttpServletRequest) request).getParameter("recipeId");
        Integer recipeId = Integer.valueOf(recipeIdString);
//        request.setAttribute("ip",ip);
//        request.setAttribute("userAgent",userAgent);
        boolean ifLogAlreadyExists = checkIfAlreadyVoted(ip,userAgent, recipeId);

        if(!ifLogAlreadyExists){
        chain.doFilter(request, response);}
        else{
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/recipiesNEW");}
    }
    private boolean checkIfAlreadyVoted (String ip,String userAgent, Integer recipeId){
        RecipeDAO recipeDAO = new RecipeDAO();
        boolean ifLogExists = recipeDAO.checkForLog(ip,userAgent,recipeId);
        if(!ifLogExists){
            recipeDAO.saveLog(ip,userAgent,recipeId);

        }
        return ifLogExists;

    }
}
