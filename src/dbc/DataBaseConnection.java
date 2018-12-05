package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author: ren
 * @ProjectName: 图书
 * @Package: dbc
 * @Description:
 * @Date: Created in 上午11:07 2018/11/25
 */
public class DataBaseConnection {
     public  static final String  url="jdbc:mysql://localhost:3306/rjfbooks";
     public  static  final String user="root";
     public static final String  password="Yq1997..";
     private static Connection conn=null;

     public static Connection getConnection(){
         try {
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(url, user, password);
         }catch(Exception e){

         }
         return  conn;
     }

     public void close(){
          if(conn!=null){
              try {
                  conn.close();
              }catch(Exception e){

              }
          }
     }


}
