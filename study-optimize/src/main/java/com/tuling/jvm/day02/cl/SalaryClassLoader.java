package com.tuling.jvm.day02.cl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureClassLoader;

public class SalaryClassLoader extends SecureClassLoader {

    private String classPath;

    public SalaryClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String fileClassName) throws ClassNotFoundException {
        // 查找.class文件
        String filePath = this.classPath + fileClassName.replace(".", "/").concat(".myclass");
        int code;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((code = fileInputStream.read()) != -1) {
                byteArrayOutputStream.write(code);
            }
            // 将.myclass文件写入内容
            byte[] data = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return defineClass(fileClassName, data, 0, data.length);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }
}
