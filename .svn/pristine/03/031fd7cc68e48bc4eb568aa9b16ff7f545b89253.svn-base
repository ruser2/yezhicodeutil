//package com.yllt.utils;
//
//import com.manager.constants.ErrorCode;
//import com.manager.constants.GlobalConstant;
//import com.manager.containers.ApplicationContext;
//import com.manager.containers.entity.FileEntity;
//import com.manager.controller.MainController;
//import com.manager.pojo.comm.Response;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.log4j.Logger;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Administrator on 2015/12/21.
// */
//public class FileProcesser {
//
//    private static FileProcesser processer;
//    private FileProcesser(){
//    }
//    public static FileProcesser instance(){
//        if(null==processer){
//            processer=new FileProcesser();
//        }
//        return processer;
//    }
//
//    private static Logger logger = Logger.getLogger(MainController.class);
//
//    private static String[] allowFiles = {".rar", ".doc", ".docx", ".zip", ".pdf", ".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp", ".mp3", ".mp4"};
//    private static long maxSize = GlobalConstant.UPLOAD_IMAGE_SIZE;//上传文件最大值
//
//    public class FileFoulException extends Throwable {
//        private Response response = null;
//
//        public FileFoulException(Response response) {
//            this.response = response;
//        }
//
//        public Response getResponse() {
//            return response;
//        }
//    }
//
//
//
//    public void process() throws FileFoulException{
//        //TODO 文件名中文乱码
//        HttpServletRequest request=ApplicationContext.CTX.getRequest();
//
//        DiskFileItemFactory factory = new DiskFileItemFactory();//上传文件
//        factory.setSizeThreshold(1024 * 1024);
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        InputStream in = null;
//        try {
//            List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
//            List<FileEntity> fileList = new ArrayList<FileEntity>(list.size());
//            FileEntity fileEntity;
//            String value;
//            String fieldName;
//            for (FileItem item : list) {
//                fileEntity=new FileEntity();
//                fieldName = item.getFieldName();
//                //文件格式不对  返回异常
//                if (!FileUtil.checkFileType(fieldName, allowFiles)) {
//                    Response response=Response.fail("文件格式不对", ErrorCode.FILE_TYPE_UNMATCH);
//                    throw new FileFoulException(response);
//                }
//                //文件大小不对  返回异常
//                if (maxSize < item.getSize()) {
//                    throw new FileFoulException(Response.fail("文件格式不对", ErrorCode.FILE_SIZE_UNMATCH));
//                }
//                in = item.getInputStream();
//                byte[] buf = new byte[(int) item.getSize()];
//                in.read(buf);
//                System.out.println(new String(buf));
//                fileEntity.setContents(buf);
//                fileEntity.setFileName(fieldName);
//                fileList.add(fileEntity);
//            }
//            ApplicationContext.CTX.setFileList(fileList);
//        } catch (Exception ex) {
//            logger.error("上出文件出现错误", ex);
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException ex) {
//                    logger.error("上出文关闭出现错误", ex);
//                }
//            }
//        }
//    }
//
//}
