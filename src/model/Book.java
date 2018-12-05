package model;

/**
 * @Author: ren
 * @ProjectName: 图书
 * @Package: model
 * @Description:
 * @Date: Created in 上午10:53 2018/11/25
 */
public class Book {
     private int bookId;
     private String bookName;
     private Double bookPrice;
     private String bookPhoto;


     public  int getBookId(){
         return bookId;
     }

     public  void setBookId(int bookId){
         this.bookId=bookId;
     }
     public String getBookName(){
         return bookName;
     }
     public  void setBookName(String bookName){
         this.bookName=bookName;
     }
     public Double getBookPrice(){
          return bookPrice;
     }
     public  void setBookPrice(Double bookPrice){
         this.bookPrice=bookPrice;
     }
    public String getBookPhoto(){
        return bookPhoto;
    }
    public  void setBookPhoto(String bookPhoto){
        this.bookPhoto=bookPhoto;
    }

}
