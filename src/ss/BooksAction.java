package ss;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.BookDao;
import model.Book;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BooksAction extends ActionSupport{
    private List<Book> bookList;
    private Book book;
    private int bookId;

    private File photo;
    //封装上传文件的类型
    private String photoContentType;

    //封装上传文件名称
    private String photoFileName;

    private String photoSavePath;

    private int p=1;  //p变量存储当前页码，初始值设置为1
    private int lastpage; //总页数

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public  Book getBook(){
        return book;
    }
    public void setBook(Book book){
        this.book=book;
    }

    public int getBookId(){
        return bookId;
    }
    public  void setBookId(int bookId){
        this.bookId=bookId;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoSavePath() {
        return photoSavePath;
    }

    public void setPhotoSavePath(String photoSavePath) {
        this.photoSavePath = photoSavePath;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public String showBook() throws Exception {
         String user = (String) ActionContext.getContext().getSession().get("user");
          if(user!=null&&user.equals("mimi"))
        {
            BookDao bd=new BookDao();
            bookList=bd.QueryAll();
            return "success1";
        }
           if(user!=null&&user.equals("ren"))
        {
            BookDao bd=new BookDao();
             bookList=bd.QueryAll();
             for(int i=0;i<bookList.size();i++){
                    book=bookList.get(i);
                 System.out.println(book.getBookId()+"-"+book.getBookName()+"-"+book.getBookPrice());
             }
               return SUCCESS;
          }else {
            return LOGIN;
        }
    }

    public String addBook()throws IOException {

        String tip = "图书添加成功";
        ActionContext.getContext().getSession().put("tip", tip);

        book.setBookPhoto(this.getPhotoSavePath() + "/" + this.getPhotoFileName());
        //System.out.println(path);
        System.out.println("photoFileName" + this.getPhotoFileName());
        BookDao bd = new BookDao();

        System.out.println(book.getBookId() + "-" + book.getBookName() + "-" + book.getBookPrice() + "-" + book.getBookPhoto());
        int flag = bd.addBook(book);

        if (flag == 1) {

            String dstPath = ServletActionContext.getServletContext().getRealPath(
                    this.getPhotoSavePath()) + "/" + this.getPhotoFileName();
            FileOutputStream fos = new FileOutputStream(dstPath);
            System.out.println(dstPath);
            FileInputStream fis = new FileInputStream(getPhoto());
            System.out.println(getPhoto());
            byte[] b = new byte[1024];
            int len;
            System.out.println(fis.read(b));
            while ((len = fis.read(b)) > 0) {
                fos.write(b, 0, len);
            }
            fis.close();
            fos.close();


            bookList = bd.QueryAll();
            System.out.println(book.getBookPhoto());
            return "add";

        }else if(flag==2){
            this.addFieldError("book.bookName","该图书编号已存在");
            return INPUT;
        }
        return "";
    }

    public String updateBook() throws Exception {
        String tip = "图书修改成功";
        ActionContext.getContext().getSession().put("tip",tip);
        BookDao bd=new BookDao();

        bd.UpdateBook(book);
        System.out.println(book.getBookId()+"-"+book.getBookName());

        bookList=bd.QueryAll();

        return"update";
    }

    public String getBookById()throws SQLException{
        BookDao bd=new BookDao();
        this.book=bd.getBookById(bookId);
        return SUCCESS;
    }


    public String deleteBook() throws Exception {
        String tip = "图书删除成功";
        ActionContext.getContext().getSession().put("tip", tip);
        BookDao bd=new BookDao();
        System.out.println(bookId);
        bd.deleteBook(bookId);
        bookList=bd.QueryAll();
        return "success";
    }
    public String getAllList(){
        int pageS=3;  //每页显示5条记录
        BookDao bd=new BookDao();
        this.bookList=bd.QueryAll();
        int listLength=this.bookList.size();
        if(listLength%pageS==0){
            this.lastpage=listLength/pageS;
        }else{
            this.lastpage=listLength/pageS+1;
        }
        if(this.p<1)
            this.p=1;
        if(this.p>this.lastpage)
            this.p=this.lastpage;

        int startIndex=(this.p-1)*pageS;
        int endIndex=startIndex+pageS;

        if(endIndex>=listLength)
            endIndex=listLength;
       this.bookList= this.bookList.subList(startIndex,endIndex);
        return SUCCESS;
    }

}
