import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00");
    private int customerNumber;
    private int pinNumber;
    private String Name;
    private double savingBalance = 0;
    private double primaryBalance= 0;



    public Account(int customerNumber, int pinNumber, String Name) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }



    public int getCustomerNumber(){
        return customerNumber;
    }


    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }



    public int getPinNumber(){
        return pinNumber;
    }



    public double getSavingBalance(){
        return savingBalance;
    }



    public double getPrimaryBalance(){
        return primaryBalance;
    }


    public double calcCheckingWithdraw(double amount){
        primaryBalance= (primaryBalance- amount);
        return primaryBalance;
    }



    public double calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }



    public double calcCheckingDeposit(double amount){
        primaryBalance= (primaryBalance+ amount);
        return primaryBalance;
    }



    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }



    public void getCheckingWithdrawInput(){
        System.out.println("Checking account balance: " + moneyFormat.format(primaryBalance));
        System.out.println("Amount you want to withdra from checking account: ");
        double amount = input.nextDouble();

        if((primaryBalance - amount) >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(primaryBalance));
        }else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }


    public void getSavingWithdrawInput(){
        System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from saving account: ");
        double amount = input.nextDouble();

        if((savingBalance - amount) >= 0){
            calcSavingWithdraw(amount);
            System.out.println("New saving account balance: " + savingBalance + "\n");
        }else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }



    public void getCheckingDepositInput(){
        System.out.println("Primary account balance: " + moneyFormat.format(primaryBalance));
        System.out.println("Amount you want to deposit in primary account: ");
        double amount = input.nextDouble();

        if (amount >= 0){
            calcCheckingDeposit(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(primaryBalance));
        }else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }



    public void getSavingDepositInput(){
        System.out.println("Saving account balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit from saving account: ");
        double amount = input.nextDouble();

        if (amount >= 0){
            calcSavingDeposit(amount);
            System.out.println("New saving account balance: " + moneyFormat.format(savingBalance));
        }else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }


}
