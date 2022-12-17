import java.util.*;

public class Library
{
    private String name;
    private TreeSet<Book> bookList = new TreeSet<Book>();
    private LinkedList<Loan> loanList = new LinkedList<Loan>();
    private LinkedList<Loan> loanHistory = new LinkedList<Loan>();
    private HashSet<Borrower> borrowerList = new HashSet<Borrower>();
    public Library(String name)
    {
        this.name = name;
    }
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
        //책을 더 등록할지 물어보는 기능
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
        Borrower borrower = getBorrower(name);
        Book book = getBook(title, author);
        if (borrower.canLoan()==true & book.isItLoan() != true){
            Loan newLoan = new Loan(borrower,book);
            book.linkLoan(newLoan);
            borrower.linkLoan(newLoan);
            loanList.add(newLoan);
        }
        else{
            //대출이 불가능한경우
        }
    }
    public void returnBook(String name,String title,String author)
    {
        Loan loanObj = getLoan(name,title,author);
        Book bookObj = loanObj.getBook();
        Borrower borrowerObj = loanObj.getBorrower();
        bookObj.unlinkLoan();
        borrowerObj.unlinkLoan(loanObj);
        loanHistory.add(loanObj);
        loanList.remove(loanObj);
    }
    public Book getBook(String title,String author)
    {
        for(Book book : bookList){
            if (title == book.title & author == book.author & book.isItLoan() == false)
            {
                return book;
            }
        }
        return null;
    }
    public Borrower getBorrower(String name)
    {
        for(Borrower borrower : borrowerList){
            if (name == borrower.name & borrower.canLoan() == true)
            {
                return borrower;
            }
        }
        return null;
    }
    public Loan getLoan(String name,String title,String author)
    {
        for(Loan loan : loanList){
            if (name == loan.borrower.name)
            {
                if (title == loan.book.title & author == loan.book.author)
                {
                    return loan;
                }
                            }
        }
        return null;
    }
}
