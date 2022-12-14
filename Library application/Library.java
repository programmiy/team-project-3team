import java.util.*;

public class Library
{
    private String name;
    private TreeSet<Book> bookList = new TreeSet<Book>();
    private LinkedList<Loan> loanList = new LinkedList<Loan>();
    private HashSet<Borrower> borrowerList = new HashSet<Borrower>();
    public void registerOneBorrower(String name)
    {
        int count = 0;
        for (Borrower borrower : borrowerList)
        {
            if(borrower.name == name){
                count += 1;
                break;
            }
        }
        if (count == borrowerList.size())
        {
            Borrower newBorrower = new Borrower(name);
            borrowerList.add(newBorrower);
            System.out.println("신규 이용자등록이 완료되었습니다.");
        }
        else
        {
            System.out.println("신규 이용자 등록 불가");
        }
    }
    public void registerOneBook(String title,String author)
    {
        int catalogNumber = bookList.size();
        Book newBook = new Book(title,author,catalogNumber);
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
        // 이 부분 getBorrower메서드가 loan에 있으니까 loan클래스를 호출해야될 것같습니다.
        Borrower borrower = getBorrower(name);
        // 이 부분도 위랑 마찬가지.
        Book book = getBook(title, author);
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
        Loan loanObj = new Loan();
        loanObj = getLoan(name,title,author);
        Book bookObj = loanObj.getBook(title, author);
        Borrower borrowerObj = getBorrower();
        bookObj.unlinkLoan();
        borrowerObj.unlinkLoan(loanObj);
        loanList.remove(loanObj);
    }
}
