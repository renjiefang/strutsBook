package ss;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginRegisterAction extends ActionSupport {
    private String username;
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role= role;
    }

    public String execute() throws Exception {
        if(getUsername().equals("ren")&&getPassword().equals("123")&&getRole().equals("用户")){
            ActionContext.getContext().getSession().put("user",username);
            return SUCCESS;
        }else {
            return ERROR;
        }
    }
    public String admin() throws Exception {
        if(getUsername().equals("mimi")&&getPassword().equals("123")&&getRole().equals("管理员")){
            ActionContext.getContext().getSession().put("user",username);
            return "success1";
        }else {
            return ERROR;
        }
    }
    public String regist() throws Exception {
            ActionContext.getContext().getSession().put("user",username);
            return SUCCESS;
    }

}
