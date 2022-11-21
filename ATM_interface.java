package oasis;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.util.Scanner;


class AtmInterface {
	String transactionHistory="\t Your transaction History\n";
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	   LocalDateTime now = LocalDateTime.now();
	String Full_Name,Gender;
	private String dob,phoneNo;
	private String userName,Password,accountNumber,pin;
	double balance=0.0f;
	int Transactions=0;
	Scanner input=new Scanner(System.in);
	
	public void register() {
		System.out.println("\n========================================================");
		System.out.println("+----------+");
		System.out.println("| Register |");
		System.out.println("+--------=-+");
		System.out.print("Enter Full Name: ");
		Full_Name=input.nextLine();
		System.out.print("Enter Date of Birth(DD/MM/YYYY): ");
		dob=input.nextLine();
		System.out.print("Enter Gender(M/F): ");
		Gender=input.nextLine();
		Gender=Gender.toUpperCase();
		while(!(Gender.matches("[fmFM]"))) {
			System.out.print("!Error!-->Enter valid Gender(M/F): ");
			Gender=input.nextLine();
			Gender=Gender.toUpperCase();
		}
		System.out.print("Enter User Name: ");
		userName=input.nextLine();
		System.out.print("Enter Password: ");
		Password=input.nextLine();
		System.out.print("Enter Account Number(8 digit): ");
		accountNumber=input.nextLine();
		while(accountNumber.length()!=8) {
			System.out.print("!Error!-->Please Enter Valid 8 Digit Account Number: ");
			accountNumber=input.nextLine();
		}
		System.out.print("Enter 4 Digit pin: ");
		pin=input.nextLine();
		while(pin.length()!=4) {
			System.out.print("!Error!-->Please Enter Valid 4 Digit PIN: ");
			pin=input.nextLine();
		}
		System.out.print("Enter Your Phone Number: ");
		phoneNo=input.nextLine();
		while(phoneNo.length()!=10) {
			System.out.print("!Error!-->Please Enter Valid 10 Digit Phone Number: ");
			phoneNo=input.nextLine();
		}
		System.out.println("!!!!! You Are Successfully Registerd !!!!! ");
		System.out.println("!!!!! Kindly Login To Your Account !!!!!\n");
		
	}
	
	public void Profile() {
		System.out.println("========================================================");
		System.out.println("+---------+");
		System.out.println("| Profile |");
		System.out.println("+---------+");
		System.out.println("Full Name: "+Full_Name);
		System.out.println("Date of barth(DD/MM/YYYY): "+dob);
		System.out.println("Gender: "+Gender);
		System.out.println("User Name: "+userName);
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Password: "+Password);
		System.out.println("PIN: "+pin);
		System.out.print("Gender: ");
		if(Gender.matches("[fF]")) {
			System.out.println("Female");
		}else {
			System.out.println("Male");
		}
		System.out.println("Current Balance: "+balance);
		System.out.println("========================================================");
	}
	
	public boolean login() {
		System.out.println("========================================================");
		System.out.println("+-------+");
		System.out.println("| Login |");
		System.out.println("+-------+");
		boolean log=false;
		while(!log) {
			String Acc_no,p;
			System.out.print("Enter Account Number(8 Digit): ");
			Acc_no=input.nextLine();
			if(Acc_no.equals(accountNumber)) {
				System.out.print("Enter PIN(4 Digit): ");
				p=input.nextLine();
				while(!log) {
					if(p.equals(pin)) {
						System.out.println("\n#Logged in successfully!#");
						log=true;
					}else {
						System.out.println("!Error!-->Enter Correct Pin(4 Digit)!!");
						break;
					}
				}
			}else {
				System.out.println("!Error!-->Account does not exist please enter correct account number!!! ");
			}
		}
		return log;
	}
	public boolean checkDepositeAmount(double amount) {
		if(amount>100000) {
			return true;
		}else {
			return false;
		}
	}
	public boolean checkWithrawAmount(double amount) {
		double check=balance-amount;
		if(amount>100000) {
			System.out.println("!Error!-->Deposited amount can not be beyond 1-Lakes Or ");
		}
		if(check<0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void deposite() {
		System.out.println("========================================================");
		System.out.println("+----------+");
		System.out.println("| Deposite |");
		System.out.println("+----------+");
		double depositeAmount;
		System.out.print("Enter Amount to depsite into your account: ");
		depositeAmount=input.nextDouble();
		if(checkDepositeAmount(depositeAmount)) {
			System.out.println("!Error!-->Atm Will Not Deposte beyond 1Lakes!!");
		}else {
			balance=balance+depositeAmount;
			Transactions+=1;
			System.out.println("Successfully Deposited Rs "+depositeAmount+" into your account at "+ dtf.format(now));
			System.out.println("Your Current Balance is: "+balance);
			String History="";
			History="\nRs "+depositeAmount+ " Deposited at "+dtf.format(now)+" .";
			transactionHistory=transactionHistory.concat(History);
		}
		
	}
	public void withdraw() {
	System.out.println("========================================================");
	System.out.println("+---------+");
	System.out.println("| Withraw |");
	System.out.println("+---------+");
		double withdrwaAmount;
		System.out.print("Enter amount to withdraw: ");
		withdrwaAmount=input.nextDouble();
		if(checkWithrawAmount(withdrwaAmount)) {
			System.out.println("\n!Error!-->You do not have sufficient balance!");
		}else {
			balance=balance-withdrwaAmount;
			Transactions+=1;
			System.out.println("Successfully withdraw Rs "+withdrwaAmount+" from your account at "+ dtf.format(now));
			System.out.println("Your Current Balance is: "+balance);
			String History="";
			History="\nRs "+withdrwaAmount+ "Withdrawn at "+dtf.format(now)+" .";
			transactionHistory=transactionHistory.concat(History);
		}
		
	}
	public void transactionHistory() {
		System.out.println("========================================================");
		System.out.println("+----------------------+");
		System.out.println("| Transactions History |");
		System.out.println("+----------------------+\n");
		if(Transactions==0){
			System.out.println("No Transactions\n");
		}else {
			System.out.println(transactionHistory);
		}
	}
	public void checkBalance() {
		System.out.println("\nBalance amount is: "+balance+"\n");
	}
	
	
}


public class Atm_main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("\t\t\t\t+----------------------------------+");
		System.out.println("\t\t\t\t|  WELCOME TO ATM INTERFACE TASK-3 | ");
		System.out.println("\t\t\t\t+----------------------------------+");
		System.out.println("1.Register(New user register first)\n2.Exit\n");
		System.out.print("Enter choice: ");
		int choice=s.nextInt();
		if(choice==1) {
			AtmInterface atm=new AtmInterface();
			atm.register();
			while(choice==1) {
				System.out.println("Select any one options:");
				System.out.println("1.Login(if already register)\n2.Exit");
				System.out.print("Choice: ");
				int ch;
				ch=s.nextInt();
				if(ch==1) {
					if(atm.login()) {
						while(true) {
							System.out.println("\n");
							System.out.println("========================================================");
							System.out.println("+------+");
							System.out.println("| Menu |");
							System.out.println("+------+");
							System.out.print("1.View Profile\n2.Deposite\n3.Withraw\n4.Transaction History\n");
							System.out.println("5.Check Balance\n6.Exit");
							System.out.print("Enter Your Option: ");
							int select=s.nextInt();
							switch(select) {
								case 1: atm.Profile();
								break;
								case 2:atm.deposite();
								break;
								case 3: atm.withdraw();
								break;
								case 4: atm.transactionHistory();
								break;
								case 5:atm.checkBalance();
								break;
								case 6: System.out.println("Thank you----Visit again----- :)");
								System.exit(0);
								break;
								default:
									System.out.println("Invalid option----Enter Valid option");
							}
						}
					}
				}else {
					System.out.println("Thank you----Visit again----- :)");
					System.exit(0);
				}
				
			}
		}else {
			System.out.println("Thank you----Visit again----- :)");
			System.exit(0);
		}
		
	}

}
