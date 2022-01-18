package RecipiesMS.Controllers;

import RecipiesMS.JavaModels.VoteToAdd;
import RecipiesMS.ServiceForVote.voteService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/vote")
public class ServletVote extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Optional<Cookie> votesCookie = getCookieByName(request,"numberOfVotes");
        Integer numberOfVotes = votesCookie.
                map(Cookie::getValue).
                map(Integer::valueOf).
                orElse(0);
        numberOfVotes++;

        Cookie cookie = new Cookie("numberOfVotes",Integer.toString(numberOfVotes));
        cookie.setMaxAge(20);

        if(numberOfVotes == 1){
            voteService service = new voteService();
            VoteToAdd vote = createVote(request);
            service.addVote(vote);}

        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath());
    }

    private VoteToAdd createVote(HttpServletRequest request) {
        Integer discoveryId = Integer.valueOf(request.getParameter("recipeId"));
        String voteType = request.getParameter("type");
        VoteToAdd voteAdded = new VoteToAdd(discoveryId, voteType);
        return voteAdded;
    }

    private Optional<Cookie> getCookieByName (HttpServletRequest request, String cookieName){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookies == null){
                return Optional.empty();
            }
            else if(cookie.getName().equals(cookieName)){
                return Optional.of(cookie);
            }
        }
        return Optional.empty();
    }
}
