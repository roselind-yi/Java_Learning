package chapter07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test13_新方法trycatch {
    public static void main(String[] args) {
        // 新式try-catch语法
        // try后面跟小括号和大括号
        // 小括号里面编写创建系统资源【流】的代码
        // 大括号里面编写使用的代码
        // 这种语法, 流用完后会自动关闭, 不需要手动close()关闭
        // 结尾不需要finally
        try (
                // 小括号里面创建流
                InputStream is = new FileInputStream("D:/hello.txt");
        ) {
            // 大括号里面使用流

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}