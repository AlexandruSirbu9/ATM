import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionMenu {
    Scanner scanner = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private List<Account> database = new ArrayList<>();
    private int customerNumber;
    private int pinNumber;
    private Account loggedInAccount = null;



    public void getLogin() throws IOException {
        int x = 1;
        database.add(new Account(9876543,9876, "Iliescu Vasilache"));
        database.add(new Account(8989898,1890, "Marcel Ionescu"));
        database.add(new Account(89878898,1891,"Ion Ciolacu"));

        do {
            try {
                System.out.println("Welcome to the ATM Project!!");

                System.out.println("Enter your customer number: ");
                customerNumber = scanner.nextInt();

                System.out.println("Enter you pin number: ");
                pinNumber = scanner.nextInt();

            }catch (Exception e){
                System.out.println("\n" + "Invalid characters . Only numbers." + "\n");
                x = 2;
            }

            for (Account a: database) {
                if(a.getCustomerNumber() == customerNumber && a.getPinNumber() == pinNumber){
                    loggedInAccount = a;
                    System.out.println("Ne logam cu: " + loggedInAccount.getName());
                    getAccountType();
                }
            }
        }while (x == 1);
    }

    public void getAccountType(){
        System.out.println(loggedInAccount.getName() + " select the account you want to access: ");
        System.out.println("Type 1 - Primary Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");


        boolean nuEsteInt;
        do{
            nuEsteInt = false;
            scanner.nextLine();
            if(scanner.hasNextInt()){
                selection = scanner.nextInt();
            }else{
                System.out.println("\n" + "Invalid character! Please enter a valid option !" + "\n\n");
                System.out.println("Select the account you want to access: ");
                System.out.println("Type 1 - Primary Account");
                System.out.println("Type 2 - Saving Account");
                System.out.println("Type 3 - Exit");
                nuEsteInt = true;
            }
        }while(nuEsteInt);



        switch (selection){
            case 1:
                getPrimaryAccount();
                break;

            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM , bye.");
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getAccountType();
        }
    }



    public void getPrimaryAccount(){
        System.out.println("Primary Account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        boolean nuEsteInt;
        do{
            nuEsteInt = false;
            scanner.nextLine();
            if(scanner.hasNextInt()){
                selection = scanner.nextInt();
            }else{
                System.out.println("\n" + "Invalid character! Please enter a valid option !" + "\n\n");
                System.out.println("Primary Account: ");
                System.out.println("Type 1 - View balance");
                System.out.println("Type 2 - Withdraw funds");
                System.out.println("Type 3 - Deposit funds");
                System.out.println("Type 4 - Exit");
                System.out.println("Choice: ");
                nuEsteInt = true;
            }
        }while(nuEsteInt);

        switch (selection){
            case 1:
                System.out.println("Primary account balance: " + moneyFormat.format(loggedInAccount.getPrimaryBalance()));
                getAccountType();
                break;
            case 2:
                loggedInAccount.getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                loggedInAccount.getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getPrimaryAccount();

        }
    }

    public void getSaving(){
        System.out.println("Saving account: ");
        System.out.println("Type 1- View balance.");
        System.out.println("Typa 2- Withdraw funds.");
        System.out.println("Type 3- Deposit funds. ");
        System.out.println("Type 4- Exit.");
        System.out.println("Choice: ");

        boolean nuEsteInt;
        do{
            nuEsteInt = false;
            scanner.nextLine();
            if(scanner.hasNextInt()){
                selection = scanner.nextInt();
            }else{
                System.out.println("\n" + "Invalid character! Please enter a valid option !" + "\n\n");
                System.out.println("Saving account: ");
                System.out.println("Type 1- View balance.");
                System.out.println("Typa 2- Withdraw funds.");
                System.out.println("Type 3- Deposit funds. ");
                System.out.println("Type 4- Exit.");
                System.out.println("Choice: ");
                nuEsteInt = true;
            }
        }while(nuEsteInt);

        switch (selection){
            case 1:
                System.out.println("Saving account balance: " + moneyFormat.format(loggedInAccount.getSavingBalance()));
                getAccountType();
                break;
            case 2:
                loggedInAccount.getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                loggedInAccount.getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getSaving();
        }
    }

    int selection;

}
