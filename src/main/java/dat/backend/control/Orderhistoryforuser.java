package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Orderhistoryforuser", value = "/orderhistoryforuser")
public class Orderhistoryforuser extends HttpServlet {
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
        String username = request.getParameter("orderhistoryforuser");
        User user = UserFacade.SelectUserFromUsername(username, connectionPool);
        List<Order> orderList = OrderFacade.selectAllOrdersFromUser(user.getUsername(), connectionPool);
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("WEB-INF/orderhistory.jsp").forward(request, response);


    }
}
