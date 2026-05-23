package homework51.middle;

import java.util.Scanner;

class Book{
    String name;
    String author;
    Book next;

    public Book(String name,String author){
        this.name=name;
        this.author=author;
        this.next=next;
    }
}

class BookList {
    private Book head;

    public void add(String name, String author) {
        Book newBook = new Book(name, author);

        if (head == null) {
            head = newBook;
        } else {
            Book current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newBook;
        }
    }

    public void print() {
        Book current = head;
        while (current != null) {
            System.out.println("《" + current.name + "》" + current.author);
            current = current.next;
        }
    }
}
public class h5简单图书管理 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BookList bookList=new BookList();

        System.out.println("请输入图书数量：");
        int n=scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<n;i++){
            System.out.println("请输入第"+(i+1)+"本书名：");
            String name=scanner.nextLine();

            System.out.println("请输入第"+(i+1)+"本书作者：");
            String author=scanner.nextLine();

            bookList.add(name,author);
        }
        System.out.println("\n图书列表：");
        bookList.print();

        scanner.close();
    }
}
