import java.util.*;
import javax.swing.Box;

public class Library
{
    private String name;
    private TreeSet<Book> bookList;
    private LinkedList<Loan> loanList;
    private HashSet<Borrower> borrowerList;
    public void registerOneBorrower(String name)
    {
        if(borrowerList.checkBorrowerbeing(name)==false)
        {
            Borrower newBorrower = new Borrower(name);
            borrowerList.add(newBorrower);
            //dispatch complete
        }
        else
        {
            //dispatch impossible
        }
    }
    public void registerOneBook(String title,String author)
    {
        Book newBook = new Book(title,author);
        bookList.add(newBook);
        //askRegisterAnotherBook()
    }
    public void displayBooksLoanable()
    {
        for (Book book:bookList){
            if(book.isItLoan()==false)
            {
                book.display();
            }
        }
        /*
        Book book;
        for(int i = 0;i <= bookList.length;i++){
             book = bookList.getBook();
        }
        */
    }
    public void displayBooksLoaned()
    {
        for (Book book:bookList){
            if(book.isItLoan()==true)
            {
                book.display();
            }
        }
    }
    public void loanBook(String name,String title,String author)
    {
        Borrower borrower = borrowerList.getBorrower(name);
        Book book = bookList.getBook(title,author);
        if (borrower.canLoan()==true & book.isItLoan() != true){
            Loan newLoan = new Loan(borrower,book);
            book.linkLoan(newLoan);
            borrower.linkLoan(newLoan);
            loanList.add(newLoan);
        }
        else{
            //borrow failed
        }
    }
    public void returnBook(String name,String title,String author)
    {
        Loan loanObj = loanList.getLoan(name,title,author);
        Book bookObj = loanObj.getBook();
        Borrower borrowerObj = loanObj.getBorrower();
        bookObj.unlinkLoan();
        borrowerObj.unlinkLoan(loanObj);
        loanList.remove(loanObj);
    }
}
