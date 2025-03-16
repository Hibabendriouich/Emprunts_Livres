/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import beans.User;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IDao<User>{
    private Connexion connexion;
    
    public UserService() {
        connexion = Connexion.getInstance();
    if (connexion == null || connexion.getCn() == null) {
        System.out.println("Erreur de connexion à la base de données !");
    } else {
        System.out.println("Connexion réussie !");
    }
    }
    
      public User findByLogin(String login) {
String req = "select * from User where login = ?";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new User(rs.getString("login"), rs.getString("password"));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return null;
    }

      
    @Override
    public boolean create(User o) {
//        String req="insert into User (login,password) values (?, ?)";
//    try {
//        PreparedStatement ps = connexion.getCn().prepareStatement(req);
//        ps.setString(1, o.getLogin());       
//        ps.setString(2, o.getPassword());  
//        ps.executeUpdate();
//        return true;
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//        return false;
//    }
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

}

    @Override
    public boolean delete(User o) {
String req = "delete from User where login = ?";
//    try {
//        PreparedStatement ps = connexion.getCn().prepareStatement(req);
//        ps.setString(1, o.getLogin());
//        ps.executeUpdate();
//        return true;
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//        return false;
//    }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
      public boolean update(User o) {
//String req = "update User set login = ?, password = ?";
//    try {
//        PreparedStatement ps = connexion.getCn().prepareStatement(req);
//        ps.setString(1, o.getLogin());
//        ps.setString(2, o.getPassword());;
//        ps.executeUpdate();
//        return true;
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//        return false;
//    }
                      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

    @Override
    public List<User> findAll() {
//        List<User> users = new ArrayList<>();
//    String req = "select * from User";
//    try {
//        PreparedStatement ps = connexion.getCn().prepareStatement(req);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            users.add(new User(rs.getString("login"), rs.getString("password")));
//        }
//    } catch (SQLException ex) {
//        System.out.println(ex.getMessage());
//    }
//    return users;
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

}


    @Override
    public User findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
