package com.techBlog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class LoginsServlet
 */
@WebServlet("/LoginsServlet")
public class LoginsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
        try {
          
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            //create conn for user db interaction
            UserDao dao=new UserDao(ConnectionProvider.getConnection());
            //create user 
            User user=dao.getUserByEmailId(email,password);
            if(user==null){
                //login invalid 
                Message msg=new  Message("Invalid username and password", "danger" , "danger");
                HttpSession session=request.getSession();
                session.setAttribute("msg", msg);
                response.sendRedirect("login.jsp");
                
            }else{
                //login error
                
                HttpSession session=request.getSession();
                session.setAttribute("CurrentUser", user);
                response.sendRedirect("profile.jsp");
                
            }
            
      
        }catch(Exception e){
                    e.printStackTrace();
                    
                    }
        finally {
            out.close();
        }
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
