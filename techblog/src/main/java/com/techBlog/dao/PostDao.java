package com.techBlog.dao;

import com.techBlog.entities.Category;
import com.techBlog.entities.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    private Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }

    //Fetch category from db Method
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<Category>();
        try {
            String q = "select * from category";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                int cid = set.getInt("cid");
                String cname = set.getString("cname");
                String cdesc = set.getString("cdesc");
                Category c = new Category(cid, cname, cdesc);
                list.add(c);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //method for save post in db
    public boolean savePost(Post p) {
        boolean f = false;
        try {
            String query = "insert into post (ptitle,pcontent,pprogram,ppic,cid,id) values(?,?,?,?,?,?)";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, p.getPtitle());
            ps.setString(2, p.getPcontent());
            ps.setString(3, p.getPprog());
            ps.setString(4, p.getPpic());
            ps.setInt(5, p.getCid());
            ps.setInt(6, p.getid());
            ps.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

    //method for fetch all post
    public List<Post> getAllPost() {
        List<Post> list = new ArrayList<Post>();
        //code for fetch all post
        try {
            PreparedStatement ps = this.con.prepareStatement("select * from post");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //fetch data from Resultset and asssign to new variable 
                int pid = rs.getInt("pid");
                String ptitle = rs.getString("ptitle");
                String pcontent = rs.getString("pcontent");
                String pprogram = rs.getString("pprogram");
                String ppic = rs.getString("ppic");
                Timestamp puploaddate = rs.getTimestamp("puploaddate");
                int cid = rs.getInt("cid");
                int id = rs.getInt("id");
              
                //all data fetched from DB now assign to Post Object to use this data
                Post p = new Post(pid, ptitle, pcontent, pprogram, ppic, puploaddate, cid, id);

                list.add(p);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //method for get post by  category id 
    public List<Post> getAllPostByCid(int cid) {
        List<Post> list = new ArrayList<Post>();
        //code for fetch all post by category id 
        try {
            PreparedStatement ps = this.con.prepareStatement("select * from post where cid=? order by pid desc");
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //fetch data from Resultset and asssign to new variable 
                int pid = rs.getInt("pid");
                String ptitle = rs.getString("ptitle");
                String pcontent = rs.getString("pcontent");
                String pprogram = rs.getString("pprogram");
                String ppic = rs.getString("ppic");
                
                int id = rs.getInt("id");
                Timestamp pdate = rs.getTimestamp("puploaddate");
                //all data fetched from DB now assign to Post Object to use this data
                Post p = new Post(pid, ptitle, pcontent, pprogram, ppic, pdate, pid, id);

                list.add(p);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //method to get post by ppostid
//    public Post getPostByPid(int pid) {
//        Post post = null;
//        try {
//            PreparedStatement ps = this.con.prepareStatement("select * from post where pid=?");
//            ps.setInt(1, pid);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                //fetch data from Resultset and asssign to new variable 
//                
//                String title = rs.getString("ptitle");
//                String pcontent = rs.getString("pcontent");
//                String pprogram = rs.getString("pprogram");
//                String ppic = rs.getString("ppic");
//                Timestamp pdate = rs.getTimestamp("puplddate");
//                String cid = rs.getString("cid");
//                int uid = rs.getInt("id");
//              
//                //all data fetched from DB now assign to Post Object to use this data
//                post = new Post(title, pcontent, pprogram, ppic, pdate,cid, uid);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return post;
//    }

}
