package dao;

import dbc.DataBaseConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ren
 * @ProjectName: 图书
 * @Package: dao
 * @Description:
 * @Date: Created in 上午11:34 2018/11/25
 */
public class BookDao {
    private Connection conn;

    public BookDao() {
        this.conn = DataBaseConnection.getConnection();
    }

    public ArrayList<Book> QueryAll() {
        ArrayList<Book> book1 = new ArrayList<Book>();
        PreparedStatement prep = null;
        String sql = "select * from books";
        try {
            prep = conn.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                Book book = new Book();

                book.setBookId(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookPrice(rs.getDouble(3));
                book.setBookPhoto(rs.getString(4));
                //System.out.println(book.getISBN()+","+book.getBookName()+","+book.getPrice());
                book1.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book1;

    }


    public Book getBookById(int bookId) throws SQLException {
        PreparedStatement prep = null;
        ResultSet rs = null;
        Book book = new Book();
        String sql = "select * from books where bookId='" + bookId + "'";
        try {
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            if (rs.next()) {
                book.setBookId(rs.getInt(1));
                book.setBookName(rs.getString(2));
                book.setBookPrice(rs.getDouble(3));
                book.setBookPhoto(rs.getString(4));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            rs.close();
            prep.close();
        }
        return book;
    }

    public int addBook(Book book) {
         int flag=1;
        PreparedStatement prep;
        String sql = "select * from books where bookId='"
                + book.getBookId() + "'";
        try {
            prep = conn.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                flag = 2;

            } else {
                System.out.println("添加");
                String sql1 = "insert into books values(?,?,?,?)";
                prep = conn.prepareStatement(sql1);
                prep.setInt(1, book.getBookId());
                prep.setString(2, book.getBookName());
                prep.setDouble(3, book.getBookPrice());
                prep.setString(4, book.getBookPhoto());
                System.out.println(book.getBookPhoto());
                System.out.println(book.getBookId() + "," + book.getBookName() + "," + book.getBookPrice());
                prep.executeUpdate();
            }
                prep.close();
            } catch(Exception e){
            }

        return flag;
    }

    public int UpdateBook(Book book) {
        int flag = 0;

        String sql = "update books set bookName=?,bookPrice=? where bookId=?";
        PreparedStatement prep;
        try {
            prep = conn.prepareStatement(sql);
            prep.setString(1, book.getBookName());
            prep.setDouble(2, book.getBookPrice());
            prep.setInt(3, book.getBookId());
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    public int deleteBook(int bookId) {
        int flag = 0;
        PreparedStatement prep;
        String sql = "delete from books where bookId=" + bookId + "";
        System.out.println("hou"+bookId);
        try {
            prep = conn.prepareStatement(sql);
            flag = prep.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }
}
