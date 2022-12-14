
public class Book
{
    String title;
    String author;
    int catalogNumber;
    Loan linkedLoan;

    public Book(String title,String author)
    {
        this.title = title;
        this.author = author;
        
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
        //System.out.println("");
    }
}
