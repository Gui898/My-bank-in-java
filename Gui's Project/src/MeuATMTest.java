import javax.swing.*;

/*Não mexam por favor, essa é
 minha única diversão na aula 
 de algoritmos!*/

public class MeuATMTest {

    public static void main(String[] args){
    	
    	Pessoa1 p1 = new Pessoa1(500, "Gui");
    	Pessoa2 p2 = new Pessoa2(0, "Felipão");
    	
    	JOptionPane.showConfirmDialog(null, "Usuário: Gui");
    	p1.allMethods(p1, p2);
    	//JOptionPane.showConfirmDialog(null, "Usuário: Fellipão");
    	//p2.allMethods(p2, p1);
    	
    	
 
    }
}
