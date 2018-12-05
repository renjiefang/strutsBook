package ss;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author: ren
 * @ProjectName: 图书
 * @Package: ss
 * @Description:
 * @Date: Created in 下午1:53 2018/11/18
 */

import java.io.File;


    public class UploadAction extends ActionSupport {
        private File upload;
        private String uploadFileName;
        private String uploadContentType;
        private String savePath;

        public File getUpload() {
            return upload;
        }

        public void setUpload(File upload) {
            this.upload = upload;
        }

        public String getUploadFileName() {
            return uploadFileName;
        }

        public void setUploadFileName(String uploadFileName) {
            this.uploadFileName = uploadFileName;
        }

        public String getUploadContentType() {
            return uploadContentType;
        }

        public void setUploadContentType(String uploadContentType) {
            this.uploadContentType = uploadContentType;
        }

        public String getSavePath() {
            return savePath;
        }

        public void setSavePath(String savePath) {
            this.savePath = savePath;
        }

        public String execute() throws Exception {
            String dstPath = ServletActionContext.getServletContext().getRealPath(
                    this.getSavePath())+ "/" + this.getUploadFileName();
            FileOutputStream fos = new FileOutputStream(dstPath);
            FileInputStream fis = new FileInputStream(getUpload());
            byte[] b = new byte[1024];
            int len;
            while((len = fis.read(b)) > 0){
                fos.write(b,0,len);
            }
            return SUCCESS;
        }

    }


