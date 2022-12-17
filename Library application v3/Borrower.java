
public class Borrower
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 바꾸십시오
    public String name;
    public Loan[] linkedLoan;
    
    public Borrower(String borrowerName)
    {
        name = borrowerName;
        linkedLoan = new Loan[10];
    }

    public void linkLoan(Loan newLoan)
    {
        for (int i = 0;i <= linkedLoan.length;i++){
            if (linkedLoan[i] == null)
            {
                linkedLoan[i] = newLoan;
            }
        }
    }
    public void unlinkLoan(Loan disConnectLoan)
    {
        for (int i = 0;i <= linkedLoan.length;i++){
            if (linkedLoan[i] == disConnectLoan)
            {
                linkedLoan[i] = null;
            }
        }
    }
    public boolean canLoan()
    {
        if (linkedLoan.length<10){return true;}
        else{return false;}
    }
}
