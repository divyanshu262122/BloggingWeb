package com.techBlog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techBlog.dao.UserDao;
import com.techBlog.entities.Message;
import com.techBlog.entities.User;
import com.techBlog.helper.ConnectionProvider;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			  PrintWriter out = response.getWriter();
		        try {
		            String check = request.getParameter("check"); //check term&condt checked or not
		            if (check == null) {
		                out.println("Please select terms & Conditions");
		                Message msg = new Message("Please fill all the required fields", "danger", "danger");
		                HttpSession session = request.getSession();
		                session.setAttribute("msg", msg);
		                response.sendRedirect("register.jsp");

		            } else {
		                //fetch Data from view-form and send to -> Model &to ->(Db)
		                String name = request.getParameter("name");
		                String email = request.getParameter("email");
		                String password = request.getParameter("password");
		                String gender = request.getParameter("gender");
		                String about = request.getParameter("about");

		                //now pass data to entities  for set all data 
		                User ru = new User(name, email, password, gender, about);

		                //now pass all userdao dattabase 
		                UserDao dao = new UserDao(ConnectionProvider.getConnection());
		                if (dao.saveUser(ru)) {
		                    out.print("done");
		                }
		                Message msg = new Message("Registration seccessful! Login here ", "success", "success");
		                HttpSession session = request.getSession();
		                session.setAttribute("msg", msg);

		                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		                rd.forward(request, response);
		            }
		        } catch (Exception se) {
		            out.print("Error\n" + se);
		        } finally {
		            out.close();
		        }
		    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
