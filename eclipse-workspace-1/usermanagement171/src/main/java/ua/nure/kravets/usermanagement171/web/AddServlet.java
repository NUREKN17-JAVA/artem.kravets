package ua.nure.kravets.usermanagement171.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.nure.kravets.usermanagement171.db.DaoFactory;
import ua.nure.kravets.usermanagement171.db.DatabaseException;
import ua.nure.kravets.usermanagement171.User;

public class AddServlet extends EditServlet{
	@Override
	protected void processUser(User user) throws DatabaseException {
		DaoFactory.getInstance().getUserDao().create(user);
	}


	@Override
	protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/add.jsp").forward(req,resp);
	}
}