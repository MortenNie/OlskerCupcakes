package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Updatebalance", value = "/updatebalance")
public class Updatebalance extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        int balance = Integer.parseInt(request.getParameter("balance"));
        User userTwo = UserFacade.SelectUserFromUsername(user, connectionPool);
        try {
            UserFacade.changeBalance(userTwo.getUsername(), balance, connectionPool);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<User> userList = UserFacade.getAllUsers(connectionPool);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("WEB-INF/userlist.jsp").forward(request, response);
    }
}
