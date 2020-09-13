

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.mail.MessagingException;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isSend = false;
		request.setCharacterEncoding("utf-8");
		try {
			if(SenderEmails.sendMyMessage(request.getParameter("user_name"),
			request.getParameter("user_phone"),
			request.getParameter("user_email"),
			request.getParameter("user_fill"),
			request.getParameter("user_cake"),

			request.getParameter("user_message"))) {
				isSend = true;
				request.setAttribute("result", isSend);
				request.getRequestDispatcher("input.html").forward(request, response);

			}
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cake = request.getParameter("user_cake");
		request.setAttribute("cake", cake);
		request.getRequestDispatcher("input.htmlS").forward(request, response);


	}

}
