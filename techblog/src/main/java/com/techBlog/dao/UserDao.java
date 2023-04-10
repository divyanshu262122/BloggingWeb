package com.techBlog.dao;

import com.techBlog.entities.User;

import java.sql.*;
public class UserDao {
    private Connection con;
    //constructor that use connection 
    public UserDao(Connection con) {
        this.con = con;
    }
    
    //to insert user to DB (save user details-> Register users)
    public boolean saveUser(User ruser){
       boolean f=false;
        try {
            //user->Db sending
            String query="insert into user(name,email,password,gender,about) values(?,?,?,?,?);";
            PreparedStatement ps=this.con.prepareStatement(query);
            ps.setString(1, ruser.getName());
            ps.setString(2, ruser.getEmail());
            ps.setString(3, ruser.getPassword());
            ps.setString(4, ruser.getGender());
            ps.setString(5, ruser.getAbout());
            
            ps.executeUpdate();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    //fetch user from Db (Login system ) 
    public User getUserByEmailId (String email, String password){
       User user=null;
        try{
        String query="select * from user where email=? and password=?";
        PreparedStatement ps=this.con.prepareStatement(query);
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
          //fetch data from value
          user=new User();
          //fetch value from db
          String name=rs.getString("name");
          //assign value to user object
          user.setName(name);
          //get data fro db and asssign to user
          user.setId(rs.getInt("id"));
          user.setEmail(rs.getString("email"));
          user.setGender(rs.getString("gender"));
          user.setRegdate(rs.getTimestamp("regdate "));
          user.setAbout(rs.getString("about"));
          user.setProfile(rs.getString("profile"));
        } else {
            System.out.println("username and password not found!..");
        }
       }catch(SQLException se){
           se.printStackTrace();
           
       }
        return user;
    }
    //method supdate user profile
    public boolean updateUser(User user){
        boolean f=false;
        try {
            String query="update user set name=?, profile=? where id=?";
            PreparedStatement ps=this.con.prepareStatement(query);
            ps.setString(1, user.getName());
//            ps.setString(2, user.getMobile());
            ps.setString(2, user.getProfile());
           ps.setInt(3, user.getId());
            ps.executeUpdate();
            f=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    //method for get user by uid
    public User getUsserById(int puid){
        User user=null;
         try{
        String query="select * from register where id=?";
        PreparedStatement ps=this.con.prepareStatement(query);
        ps.setInt(1,puid);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
          //fetch data from value
          user=new User();
          //fetch value from db
          String name=rs.getString("name");
          //assign value to user object
          user.setName(name);
          //get data fro db and asssign to user
          user.setId(rs.getInt("id"));
          user.setEmail(rs.getString("email"));
//          user.setMobile(rs.getString("mobile"));
          user.setGender(rs.getString("gender"));
//          user.setRegdate(rs.getString("regdate"));
         user.setProfile(rs.getString("profile"));
          
        } else {
            System.out.println("username and password not found!..");
        }
       }catch(SQLException se){
           se.printStackTrace();
           
       }
        return user;
    }
}
