import java.util.*;

public class Loan
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 바꾸십시오
    private Borrower borrower;
    private Book book;
    private Date LoanedDate;

    public Loan(Borrower borrower,Book book)
    {
        this.borrower = borrower;
        this.book = book;
        
    }

    public Book getBook()
    {
        return book;
    }
    public Borrower getBorrower()
    {
        return borrower;
    }
}
