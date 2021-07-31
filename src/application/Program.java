package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;
public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Date: (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		
		System.out.print("Contract value: ");
		Double amount = sc.nextDouble();
		
		Contract contract = new Contract(number, data, amount);
		
		System.out.print("Enter number of installments: ");
		int installments = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, installments);
		
		for(Installment x : contract.getList()) {
			System.out.println(x);
		}
		
		sc.close();

	}

}
