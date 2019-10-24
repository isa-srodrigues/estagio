/**
* @author Isadora Santos Rodrigues
* Data de Entrega: 25/10/2019
* Exercício 1 - POO
*/

//Bibliotecas --------------------------------------------------------

import java.util.*;
import java.lang.*;
import java.io.*;

//--------------------------------------------------------------------
 abstract class Animal{
	double tamanho;
	int idade;

	
	//--------------Guetters and Setters-------------------------------

	public int getidade(){
		return idade;
	}
	public void setidade(int idade){
		this.idade = idade;
	}//end get e set idade

	public double gettamanho(){
		return tamanho;
	}
	public void settamanho(double tamanho){
		this.tamanho = tamanho;
	}//end get e set tamanho

	//------------End Guetters and Setters-------------------------------


	abstract void emitirSom();
		//declaramos o som na classe animal porque todos os animais emitem som, apenas qual que diferecia
		//setar o tipo de som em cada classe de determinado animal


	public void mostrar(){
		System.out.print(getidade()+" ano(s), "+gettamanho()+"cm/m, ");
	}

}//end class Animal


//-----------CLASSE E SUBCLASSES DOS MAMiFEROS-------------------

abstract class Mamifero extends Animal{
 	public void mostrar(){
 		System.out.print("amamenta, ");
 		super.mostrar(); 
 	}
}//end Class Mamifero


class Vaca extends Mamifero{
	public void mostrar(){
		System.out.print("\nVaca, ");
		super.mostrar();
	}

	public void emitirSom(){
		System.out.print("emite mugido.");
	}
}//end class Vaca

class Morcego extends Mamifero{
	public void mostrar(){
		System.out.print("\nMorcego, voa, ");
		super.mostrar();
	}
	public void emitirSom(){
		System.out.print("emite farfalho.");
	}
}//end class Morcego


//----------- CLASSE e SUBCLASSES DAS AVES------------------- 

abstract class Ave extends Animal{
 	public void mostrar(){
 		System.out.print("bota ovos, ");
 		super.mostrar();
 	}
}//end clas Ave
	
class Pato extends Ave{
	public void mostrar(){
		System.out.print("\nPato, voa, ");
		super.mostrar();
	}
	public void emitirSom(){
		System.out.print("emite grasnido.");
	}
}//end class Pato 

class Galinha extends Ave{
	public void mostrar(){
		System.out.print("\nGalinha, ");
		super.mostrar();
	}
	public void emitirSom(){
		System.out.print("emite cacarejo.");
	}

}//end class Galinha



class Fazenda{
	public static void main(String [] args){
		System.out.print("Quantas vezes deseja testar?: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Animal [] animal = new Animal[100];

		for(int i = 0; i < n; i++){
			Scanner s = new Scanner(System.in);
			System.out.print("\nEntre com o nome do animal: ");
			String nome = s.nextLine();
			System.out.print("Entre com a idade: ");
			int idade = s.nextInt();
			System.out.print("Entre com o tamanho: ");
			double tamanho = s.nextDouble();

			if(nome.equals("Morcego") || nome.equals("morcego")){
				animal[i] = new Morcego();
				animal[i].setidade(idade);
				animal[i].settamanho(tamanho);
			}
			else if(nome.equals("Vaca") || nome.equals("vaca")){
				animal[i] = new Vaca();
				animal[i].setidade(idade);
				animal[i].settamanho(tamanho);
			}
			else if(nome.equals("Pato") || nome.equals("pato")){
				animal[i] = new Pato();
				animal[i].setidade(idade);
				animal[i].settamanho(tamanho);
			}
			else if(nome.equals("Galinha") || nome.equals("galinha")){
				animal[i] = new Galinha();
				animal[i].setidade(idade);
				animal[i].settamanho(tamanho);
			}
			else{
				System.out.print("Dado(s) invalido(s)");
		    }
	    }

	    for(int i = 0; i < n; i++){
	    	animal[i].mostrar();
	    	animal[i].emitirSom();
	    }

    }//end main
}//end class Fazenda
