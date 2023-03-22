package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Signup", value = "/signup")
public class Signup extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String balance = request.getParameter("balance");
        int balanceTwo = Integer.parseInt(balance);

        User user = new User(username, password, "user", balanceTwo);
        List<User> list = UserFacade.testIfUserExists(user.getUsername(), connectionPool);

        if (list.isEmpty()) {
            try {
                UserFacade.createUser(username, password, "user", balanceTwo, connectionPool);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            request.getRequestDispatcher("index.jsp").forward(request, response);


        }

        else {
            request.setAttribute("errormessage", "Username is already taken, try again");
            request.getRequestDispatcher("error.jsp").forward(request, response);


        }


    }
}
