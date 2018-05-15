package com.yllt.utils;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class FileUtil {
    /**
     * 读取文件为byte[]
     *
     * @throws Exception
     */
    public static byte[] toByteArray(String filename) throws Exception {
        String path = AppConfig.getProperties().getProperty("uploadDir");
        String readfilename = path + filename;
        File f = new File(readfilename);
        if (!f.exists()) {
            throw new FileNotFoundException(readfilename);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    /**
     * 删除文件
     *
     * @param file
     * @throws Exception
     */
    public static void delFile(File file) throws Exception {
        if (!file.exists()) {
            throw new Exception("文件" + file.getName() + "不存在,请确认!");
        }
        if (file.isFile()) {
            if (file.canWrite()) {
                file.delete();
                return;
            }
            throw new Exception("文件" + file.getName() + "只读,无法删除,请手动删除!");
        }

        throw new Exception("文件" + file.getName() + "不是一个标准的文件,有可能为目录,请确认!");

    }

    /**
     * 向一个文本里面写文字
     * enc 编码方式一般是utf-8
     */
    public static boolean writeStringToFile(String filePath, String content, String enc) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStreamWriter os = null;
            if ((enc == null) || (enc.length() == 0))
                os = new OutputStreamWriter(new FileOutputStream(file, true));
            else {
                os = new OutputStreamWriter(new FileOutputStream(file, true), enc);
            }
            os.write(content);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 读取文本
     * enc 编码方式一般是utf-8
     */
    public static String readTxtFile(String filePath, String enc) {
        String strlineTxt = "";
        try {
            File file = new File(filePath);
            if ((file.isFile()) && (file.exists())) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), enc);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    strlineTxt = lineTxt;
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return strlineTxt;
    }

    /**
     * @param fileName  文件名
     * @param allowFiles    允许操作的文件名后缀
     * @return
     */
    public static boolean checkFileType(String fileName, String[] allowFiles) {
        Iterator<String> type = Arrays.asList(allowFiles).iterator();
        while (type.hasNext()) {
            String ext = type.next();
            if (fileName.toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param file
     * @return
     * @throws Exception
     */
    public static void checkNewFile(File file) throws IOException {
        if (!file.exists()) {
            if (file.getName().indexOf(".") > 0) {
                checkDir(file.getParentFile());
                file.createNewFile();
            } else {
                file.mkdirs();
            }
        } else if (file.isFile()) {
            file.delete();
            file.createNewFile();
        }
    }

    public static void checkDir(File dir) {
        if (!dir.isDirectory())
            dir.mkdirs();
    }

    /**
     * 删除dir目录下的文件和空文件夹
     */
    public static void clearDir(String dir) {
        File path = new File(dir);
        File[] fs = path.listFiles();
        if (null != fs) {
            for (int i = 0; i < fs.length; i++) {
                fs[i].delete();
            }
        }
    }
}
