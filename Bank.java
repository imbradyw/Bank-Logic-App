package assignment1_200223057;


import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Brady
 */
public class Bank
{
    private String bankName;
    
    private final int minBankNameLength = 5;
    ArrayList<Account> accounts = new ArrayList();
    public static enum BranchLocations
    {
        BARRIE, TORONTO, MISSISSAUGA, ORO, STAYNER, ANGUS,
        BRAMPTON, LONDON, KITCHENER
    };
    private BranchLocations branchLocation;
    
    public Bank() {}
    public Bank(String bankName, String branchLocation)
    {
        setBankName(bankName);
        setBranchLocation(branchLocation);
    }
    public Bank(String bankName, BranchLocations branchLocation)
    {
        setBankName(bankName);
        setBranchLocation(branchLocation.toString());
    }

    public String getBankName()
    {
        return this.bankName;
    }

    public boolean setBankName(String bankName)
    {
        if(bankName.matches("[A-Za-z- ]+") && bankName.length() >= minBankNameLength)
        {
            this.bankName = bankName;
            return true;
        }
        return false;
    }

    public boolean setBranchLocation(String branchLocation)
    {
        String ucBranchLocation = branchLocation.toUpperCase();
        for(BranchLocations branch : BranchLocations.values())
        {
            if(ucBranchLocation.equals(branch.toString()))
            {
                this.branchLocation = branch;
                return true;
            }
        }
        return false;
    }

    public boolean setBranchLocation(BranchLocations branchLocation)
    {
        return setBranchLocation(branchLocation.toString());
    }
    
    public String getBranchLocation()
    {
        try
        {
            return this.branchLocation.toString();
        }
        catch(NullPointerException npe)
        {
            return null;
        }
    }

    public Account getAccountByNumber(String accountNumber)
    {
        for(Account account : accounts)
        {
            if(account.getAccountNumber().equals(accountNumber))
            {
                return account;
            }
        }
        return new Account();
    }

    public boolean addAccount(Account account)
    {
        try
        {
            for(Account otherAccount : accounts)
            {
                if(otherAccount.getAccountNumber().equals(account.getAccountNumber()))
                {
                    return false;
                }
            }
            accounts.add(account);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean addAccount(String accountName, String accountNumber, double accountBalance)
    {
        Account newAccount = new Account(accountName, accountNumber, accountBalance);
        if (newAccount.getAccountNumber().isEmpty() && newAccount.getAccountName().isEmpty() &&
                newAccount.getAccountBalance() == 0)
        {
            return false;
        }
        for(Account otherAccount : accounts)
        {
            if(otherAccount.getAccountNumber().equals(newAccount.getAccountNumber()))
            {
                return false;
            }
        }
        accounts.add(newAccount);
        return true;
    }
    
    //newAccount.getAccountBalance().compareTo(BigDecimal.ZERO) == 0);
    
    public Account viewAccount(String accountNumber)
    {
        for(Account account : accounts)
        {
            if(account.getAccountNumber().equals(accountNumber))
            {
                return account;
            }
        }
        return new Account();
    }

    public Account viewAccount(int index)
    {
        try
        {
            return accounts.get(index);
        }
        catch(IndexOutOfBoundsException e)
        {
            return new Account();
        }
    }

    public boolean modifyAccount(String accountNumber, String accountName)
    {
        Account modifiedAccount = viewAccount(accountNumber);
        try
        {
            if(modifiedAccount.getAccountNumber().isEmpty() || modifiedAccount.getAccountName().isEmpty() ||
                    modifiedAccount.getAccountBalance() == 0)
            {
                return false;
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        return modifiedAccount.setAccountName(accountName);
    }

    public boolean modifyAccount(String accountNumber, double accountBalance)
    {
        Account modifiedAccount = viewAccount(accountNumber);
        try
        {
            if(modifiedAccount.getAccountNumber().isEmpty() || modifiedAccount.getAccountName().isEmpty() ||
                    modifiedAccount.getAccountBalance() == 0)
            {
                return false;
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        return modifiedAccount.setAccountBalance(accountBalance);
    }

    public boolean modifyAccount(String accountNumber, String accountName, double accountBalance)
    {
        Account modifiedAccount = viewAccount(accountNumber);
        try
        {
            if(modifiedAccount.getAccountNumber().isEmpty() || modifiedAccount.getAccountName().isEmpty() ||
                    modifiedAccount.getAccountBalance() == 0)
            {
                return false;
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        return modifiedAccount.setAccountBalance(accountBalance) 
               && modifiedAccount.setAccountName(accountName);
    }

    public boolean modifyAccount(int index, String accountName)
    {
        Account modifiedAccount = viewAccount(index);
        try
        {
            if(modifiedAccount.getAccountNumber().isEmpty() || modifiedAccount.getAccountName().isEmpty() ||
                    modifiedAccount.getAccountBalance() == 0)
            {
                return false;
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        return modifiedAccount.setAccountName(accountName);
    }

    public boolean modifyAccount(int index, double accountBalance)
    {
        Account modifiedAccount = viewAccount(index);
        try
        {
            if(modifiedAccount.getAccountNumber().isEmpty() || modifiedAccount.getAccountName().isEmpty() ||
                    modifiedAccount.getAccountBalance() == 0)
            {
                return false;
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        return modifiedAccount.setAccountBalance(accountBalance);
    }

    public boolean modifyAccount(int index, String accountName, double accountBalance)
    {
        Account modifiedAccount = viewAccount(index);
        try
        {
            if(modifiedAccount.getAccountNumber().isEmpty() || modifiedAccount.getAccountName().isEmpty() ||
                    modifiedAccount.getAccountBalance() == 0)
            {
                return false;
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        return modifiedAccount.setAccountBalance(accountBalance)
               && modifiedAccount.setAccountName(accountName);
    }

    public boolean deleteAccount(String accountNumber)
    {
        for(Account account : accounts)
        {
            if(account.getAccountNumber().equals(accountNumber))
            {
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAccount(int index)
    {
        try
        {
            accounts.remove(index);
            return true;
        }
        catch(IndexOutOfBoundsException e)
        {
            return false;
        }
    }
}
