package dao;

/*
3. create connection
4. execute query
5.extract data from result set

closing all db resources
 */

import dbconnection.DbConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    //crud operations
    public static void insert(Book book){
        Connection connection = DbConnection.getConnection();
        String sqlInsert = "insert into Books(title,author,number) values(?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(sqlInsert);
            //bind values into parameters
            ps.setString(1,book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3,book.getNumber());
            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected+" row/s affected");
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                ps.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            DbConnection.close(connection);

        }
    }
    public static Book findById(int id){
        Connection connection = DbConnection.getConnection();
        String sql = "select * from Books where id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = null;
        try{
            ps = connection.prepareStatement(sql);
            //bind values
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            //extract data from resultset
            int idBook = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            int number = rs.getInt("number");

            book = new Book(idBook,title,author,number);

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
            try{
                ps.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            DbConnection.close(connection);

        }
        return book;
    }

    public static void update(String title,int no){
        Connection connection = DbConnection.getConnection();
        String sql = "update Books set number=? where title=?";
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(sql);
            //bind values
            ps.setInt(1,no);
            ps.setString(2,title);

            int rows = ps.executeUpdate();
            System.out.println(rows+" row/s affected");
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                ps.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            DbConnection.close(connection);

        }
    }

    public static void delete(String title){
        Connection connection = DbConnection.getConnection();
        String sql = "delete from Books where title=?";
        PreparedStatement ps=null;
        try{
            ps = connection.prepareStatement(sql);
            //bind values
            ps.setString(1,title);

            int rows = ps.executeUpdate();
            System.out.println(rows+" row/s affected");
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                ps.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            DbConnection.close(connection);

        }
    }

    public static List<Book> displayAll(){
        Connection connection = DbConnection.getConnection();
        String sql = "select * from Books";
        ArrayList<Book> allBooks = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){

                Book book = new Book(rs.getInt("id"),rs.getString("title"),
                        rs.getString("author"),rs.getInt("number"));
                allBooks.add(book);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
            try{
                ps.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            DbConnection.close(connection);

        }
        return allBooks;
    }
}
