import java.util.*;

public class Loan
{
    public Borrower borrower;
    public Book book;
    public Date loanedDate;

    public Loan(Borrower borrower,Book book)
    {
        this.borrower = borrower;
        this.book = book;
        this.loanedDate = new Date();
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
