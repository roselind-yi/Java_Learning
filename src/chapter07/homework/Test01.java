package chapter07.homework;

import java.io.File;
import java.io.*;
import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("===1.递归搜索文件===");
        File startDir=new File("D:/");
        search(startDir,".mp4");

        System.out.println("===2.字节流复制视频===");
        copyVideoWithPlainStream("D:/【哲风壁纸】新疆草原-新疆风光.mp4", "E:/copy_新疆草原.mp4");

        System.out.println("===3.老式finally复制===");
        copyWithFinally("D:/【哲风壁纸】新疆草原-新疆风光.mp4", "E:/copy_finally.mp4");

        System.out.println("===3.新式try-with-resourses方式复制===");
        copyWithTryResourses("D:/【哲风壁纸】新疆草原-新疆风光.mp4", "E:/copy_try.mp4");

        System.out.println("===4.按行读取文本并分词===");
        readAndTokenize("D:/hello.txt");
    }

    static void search(File file,String type){
        if(file.isFile()){
            String fileName=file.getName();

            if(fileName.endsWith(type)){
                System.out.println(file.getAbsolutePath());
            }
            return;
        }
        if (file.isDirectory()) {
            File[] files=file.listFiles();
            if(files==null|| files.length==0){
                return;
                }
            for (File f : files) {
                search(f, type);
            }
        }
    }

    static void copyVideoWithPlainStream(String from,String to){
        try{
            InputStream is=new FileInputStream(from);
            OutputStream os=new FileOutputStream(to);
            byte[] data=new byte[1024*128];
            int len =-1;
            long start=System.currentTimeMillis();
            while((len=is.read(data))!=-1){
                os.write(data,0,len);
            }
            long end=System.currentTimeMillis();
            System.out.println("复制成功！耗时："+(end-start)+"ms");
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void copyWithFinally(String from,String to){
        InputStream is=null;
        OutputStream os=null;
        try{
            is=new FileInputStream(from);
            os=new FileOutputStream(to);
            byte[] data=new byte[1024*128];
            int len =-1;
            long start=System.currentTimeMillis();
            while((len=is.read(data))!=-1){
                os.write(data, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println("复制成功！耗时：" + (end - start) + "毫秒");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (is == null) {
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("输入流关闭失败。");
                }
            }
            if (os == null) {
                try{
                    os.close();
                }catch(IOException e){
                    System.out.println("输入流关闭失败。");
                }
            }
        }
    }
    static void copyWithTryResourses(String from,String to){
        try(
            InputStream is=new FileInputStream(from);
            OutputStream os=new FileOutputStream(to);) {
            byte[] data=new byte[1024* 128];
            int len=-1;
            long start=System.currentTimeMillis();
            while((len=is.read(data))!=-1){
                os.write(data,0,len);
        }
            long end=System.currentTimeMillis();
            System.out.println("复制成功！耗时："+(end-start)+"ms");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void readAndTokenize(String path){
        File file=new File(path);
        if(!file.exists()){
            System.out.println("文件不存在："+path);
            return;
        }
        try(
                Reader r=new FileReader(file);
                BufferedReader br=new BufferedReader(r);
                ){
            String line;
            int lineNum=0;
            while((line=br.readLine())!=null){
                lineNum++;
                String[] words =line.split("\\s+");
                System.out.print("第" +lineNum + "行（词数：）" +words.length + "）：");
            for(String word: words){
                System.out.print("["+word+"]");
            }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

