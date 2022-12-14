
public class Book implements Comparable<Book>
{
    public String title;
    public String author;
    public int catalogNumber;
    public Loan linkedLoan;

    public Book(String title,String author,int catalogNumber)
    {
        this.title = title;
        this.author = author;
        this.catalogNumber = catalogNumber;
    }
    @Override
    public int compareTo(Book book)
    {
        return (this.catalogNumber - book.catalogNumber);
    }
    public void linkLoan(Loan newLoan)
    {
        linkedLoan = newLoan;
    }
    public void unlinkLoan()
    {
        linkedLoan = null;
    }
    public boolean isItLoan()
    {
        if (linkedLoan == null){return false;}
        else{return true;}
    }
    public void display()
    {
        System.out.println("("+catalogNumber +"번)"+" 제목:"+title+" 저자:"+author);
    }
}
