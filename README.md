ARQUIVO README

Autor(a): Isadora Santos Rodrigues

Data: Outubro/2019

* Arquivo feito com objetivo de instruir a execução dos códigos postados para serem testados

//-------------------QUESTÃO 01 - POO - FAZENDA----------------------------------

1) O programa deve ser compilado e executado da forma padrão Java.
Dessa forma:
	 
	 javac Fazenda.java
	 
	 java Fazenda

2) O programa vai interagir com o usuário que estiver testando, então ele inicia esperando a informação de quantas vezes deseja rodar o programa, ou seja, quantos animais deseja saber todas as informações. Apenas digite um numero e pressione ENTER. 

Ex: 
	Quantas vezes deseja testar o programa? 4

3) O programa em seguida pedirá 3 informações:

	-Entre com o nome do animal: (O qual você tem 4 opcoes: Morcego, vaca, galinha ou pato)
	
	-Entre com a idade:  (O qual você deve informar um numero inteiro qualquer)
	
	-Entre com o tamanho: (Como podem ser centimetros ou metros, importante você colocar algo como: 10,0 ou 1,76 por exemplo)	

4) O programa pedirá essas informações sobre cada animal que você entrar, dependendo da quantidade de vezes que você disse inicialmente que gostaria de testar. Logo em seguida, todas as informações sobre cada um dos animais que você entrou aparecerá na tela, e o código será finalizado.

//------------------QUESTÃO 02 - WEB SCRAPER - CLASSWEB --------------------------

1) O programa utiliza a bibliote Jsoup, então é importante anteriormente garantir que você tenha essa biblioteca na sua máquina e na mesma pasta onde o código a ser executado se encontra. Uma vez que isso for garantido, o programa deve ser compilado e executado desta forma:
	
	javac ClassWeb.java -cp jsoup-1.12.1.jar
	
	java -classpath ".;jsoup-1.12.1.jar" ClassWeb

2) O programa extrairá as informações da seguinte pagina web: 

	"https://www.kabum.com.br/computadores/scanners"	

Você nao precisará interagir com o programa, ele irá printar na tela os dados extraídos da página.

3) Os dados que foram tratados e aparecerão na tela são:
	
	Nome do produto.
	
	Descrição do produto.
	
	Valor do produto.
	
	Avaliações.

O programa encerrará assim que todas as informações forem printadas. 


