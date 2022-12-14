import java.util.*;

public class Loan
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 바꾸십시오
    public Borrower borrower;
    public Book book;
    public Date LoanedDate;

    public Loan(Borrower borrower,Book book)
    {
        this.borrower = borrower;
        this.book = book;
        
    }
    public Book getBook(String title, String author)
    {
        // bookList컬렉션이 Library클래스 속성이다보니 이렇게 찾으려니까 bookList를 
        // 인식을 못합니다. 어떻게 Loan클래스에서 컬렉션에 접근할지 생각해봐야겠습니다.
        for (Book book : bookList){
            // 책 제목과 저자가 입력값과 일치하는 책 객체 반환
            if(book.title == title && book.author == author){
                return book;
            }
        }
    }
    public Borrower getBorrower(String name)
    {
        // 위랑 마찬가지입니다.
        for (Borrower borrower : borrowerList){
            // 이름이 입력값과 일치하는 대출자 객체 반환
            if(borrower.name == name){
                return borrower;
            }
        }
    }
}
