package assignment1_200223057;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Brady
 */
public class Account
{
    private String accountNumber;
    private BigDecimal accountBalance;
    private String accountName;
    private final int minAccountNumLength = 5;
    private final int minAccountNameLength = 3;
    
    public Account()
    {
        this.accountBalance = BigDecimal.ZERO;
        this.accountNumber = "";
        this.accountName = "";
    }
    
    public Account(String accountName, String accountNumber, double accountBalance)
    {
        if(setAccountNumber(accountNumber) && setAccountBalance(accountBalance) && setAccountName(accountName))
        {}
        else
        {
            this.accountBalance = BigDecimal.ZERO;
            this.accountNumber = "";
            this.accountName = "";
        }
    }
    
    //Getters
    public String getAccountName()
    {
        return this.accountName;
    }
    
    public String getAccountNumber()
    {
        return this.accountNumber;
    }
    
    public double getAccountBalance()
    {
        BigDecimal bd = accountBalance.setScale(2, RoundingMode.CEILING);
        double bddouble = bd.doubleValue();
        return bddouble;
    }
    
    //Setters
    public boolean setAccountName(String accountName)
    {
        if(accountName.length() >= minAccountNameLength)
        {
            if(accountName.matches("[A-Za-z ]+"))
            {
                this.accountName = accountName;
                return true;
            }
        }
        return false;
    }
    
    public boolean setAccountNumber(String accountNumber)
    {
        if(accountNumber.length() >= minAccountNumLength)
        {
            if(accountNumber.matches("[a-zA-Z0-9]+"))
            {
                this.accountNumber = accountNumber;
                return true;
            }
        }
        return false;
    }
    
    public boolean setAccountBalance(double balance)
    {
        if(balance > 0)
        {
            BigDecimal checkBalance = BigDecimal.valueOf(balance);
            String testBalance = checkBalance.toPlainString();
            int index = testBalance.indexOf(".");
            
            if((testBalance.length() - 1) - index <= 2)
            {
                this.accountBalance = checkBalance;
                return true;
            }
        }
        return false;
    }
    
    //Overrides

    @Override
    public String toString()
    {
        return String.format("Account Name: %s\n"
                            + "Account Number: %s\n"
                            + "Balance: %s", accountName, accountNumber, accountBalance);
    }

    @Override
    public boolean equals(Object obj)
    {
        try
        {
            Account isEqual = (Account) obj;
            //return this.accountBalance.equals(isEqual.accountBalance);
            /*
            When I used the return statement below I ended up failing 3 Account tests anyway.*/
            return this.accountBalance.equals(isEqual.accountBalance)&&
                   (this.accountNumber.equals(isEqual.accountNumber))&&
                   this.accountName.equals(isEqual.accountName);
            //*/
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
}
