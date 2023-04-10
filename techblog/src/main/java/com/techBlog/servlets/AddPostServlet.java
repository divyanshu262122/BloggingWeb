package com.techBlog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.techBlog.dao.PostDao;
import com.techBlog.entities.Post;
import com.techBlog.entities.User;
import com.techBlog.helper.ConnectionProvider;
import com.techBlog.helper.Helper;


@WebServlet("/AddPostServlet")
@MultipartConfig
public class AddPostServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 PrintWriter out = response.getWriter();
     try {
         /* TODO output your page here. You may use following sample code. */
         int cid=Integer.parseInt(request.getParameter("cid"));
         String ptitle = request.getParameter("ptitle");
         String pcontent = request.getParameter("pcontent");
         String pprogram = request.getParameter("pprog");
       
         //to fetch files like pic and doc use Part
         Part part = request.getPart("ppic");
         
         String ppic;
         if(part.getSubmittedFileName().equals("")){
             ppic="default.png";
         }else{
             ppic=part.getSubmittedFileName();
        }

         //get user id  detail who want to post
         HttpSession hs = request.getSession();
         User u = (User) hs.getAttribute("CurrentUser");
        // int puid = u.getId();

         //Modal intract with DB 
         Post p = new Post(ptitle, pcontent, pprogram, part.getSubmittedFileName(), null, cid, u.getId());

         //pass data to PostDao
         PostDao pd = new PostDao(ConnectionProvider.getConnection());
         //saving post
         boolean posted = pd.savePost(p);
         if (posted) {
             //path for blog pics in disk
             String blogpicpath = request.getRealPath("/") + "Blog_pics" + File.separator + part.getSubmittedFileName();
             Helper.saveFile(part.getInputStream(), blogpicpath);
             out.print("done");
         } else {
             out.print("error");
         }
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         out.close();
     }
 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
