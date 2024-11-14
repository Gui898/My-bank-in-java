import javax.swing.JOptionPane;

public abstract class MeuATM {

	protected double balance = 0;
	protected String nameATM;

	public void credit() {
		
		int optionDeposit = JOptionPane.showConfirmDialog(null, "Você quer depositar?", "Depósito", JOptionPane.YES_NO_OPTION);
		if(optionDeposit == JOptionPane.YES_OPTION) {
			double depositValue =  Double.parseDouble(JOptionPane.showInputDialog("Quanto você quer depositar?"));	
			if(depositValue > 0) {
				balance += depositValue;
			} else {
				JOptionPane.showMessageDialog(null, "Insira uma valor válido");
			}
			currentValue();	
		}
		
	}
	
	public void withdraw() {
			
		int optionWithdraw = JOptionPane.showConfirmDialog(null, "Você quer sacar?", "Saque", JOptionPane.YES_NO_OPTION);
		if(optionWithdraw == JOptionPane.YES_OPTION) {
			double withdrawValue = Double.parseDouble(JOptionPane.showInputDialog("Quanto você quer sacar?"));
			if(balance < withdrawValue) {
				JOptionPane.showMessageDialog(null, "Você não pode sacar mais do que tem!");
			}else {
				balance -= withdrawValue;
			}
			 currentValue();	
		} 
	}
	
	
	public void currentValue() {
		JOptionPane.showMessageDialog(null, "Seu saldo atual é R$" + this.balance + ", " + this.nameATM);
	}
	
	public void transference(Humans p1,Humans p2) {
		int optionTransference = JOptionPane.showConfirmDialog(null, "Você quer transferir?", "Transferência", JOptionPane.YES_NO_OPTION);
		if(optionTransference == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "A pessoa que está transferindo: " + this.nameATM);
			double transValue = Double.parseDouble(JOptionPane.showInputDialog("Quanto você quer transferir?"));
			if(transValue > 0 && transValue <= p1.balance) {
				p1.balance -= transValue;
				p2.balance += transValue;
			} else{
				JOptionPane.showConfirmDialog(null, "Você não pode transferir mais do que tem!");
			}
			currentValue();
		}
	}
	
	public void loan () {
		int optionLoan = JOptionPane.showConfirmDialog(null, "Você quer um empréstimo?", "Empréstimo", JOptionPane.YES_NO_OPTION);
		if(optionLoan == JOptionPane.YES_OPTION) {
			double loanValue = Double.parseDouble(JOptionPane.showInputDialog("Quanto você quer pedir ao banco?"));
			long start = System.currentTimeMillis();
			this.balance += loanValue;
			currentValue();
			
			int optionGiveBack = JOptionPane.showConfirmDialog(null, "Você quer devolver o empréstimo?", "Empréstimo", JOptionPane.YES_NO_OPTION);
			if(optionGiveBack == JOptionPane.YES_OPTION) {
				long finish = System.currentTimeMillis();
				long total = finish - start;
				
				this.balance -= loanValue + (loanValue * ((84/10000) * total)); //ARRUMA AQUI MAMACO
				currentValue();
			}
		}
	}
	
	
	public void allMethods(Humans tp1, Humans tp2) {
		
		currentValue();
		credit();
		withdraw();	
		transference(tp1, tp2);
		loan();
		
	}
	
}
