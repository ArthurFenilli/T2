//eai blz?
/**
 * Escreva uma descrição da classe tester aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import  java.util.Scanner;
public class tester
{
   public static void main(String args[]){
      Scanner teclado = new Scanner(System.in);
      Scanner in = new Scanner(System.in);
      ListaT teste = new ListaT(5);
      
      int opcao;
        do{
            System.out.println("\n\n---- MENU ----");
            System.out.println("1 - Incluir time");
            System.out.println("2 - Listar times");
            System.out.println("3 - Excluir time");
            System.out.println("4 - Operacoes em conta");
            System.out.println("0 - Sair");
            System.out.print("Informe uma opcao:");
            opcao = teclado.nextInt();
            
            switch(opcao){
                case 0: System.out.println("Fim do programa"); break;
                
                case 1: System.out.println(">>>Incluir time");
                        String pais = in.nextLine();
                        if(teste.incluirTime(pais)==true)
                           System.out.println("Time incluido com sucesso");
                        else System.out.println("Time nao incluido");
                        break;
                        
                case 2: System.out.println(">>>Listar times");
                        System.out.println(teste.toString());
                        break;
                
                case 3: System.out.println(">>>Excluir time");
                        System.out.println("Informe o numero do time.");
                        int num = teclado.nextInt();
                        if(teste.excluiTime(num) == false)System.out.println("Time não existente.");
                        else System.out.println("Time excluído com sucesso.");
                        
                        break;
                case 4: System.out.println("Não implementado.");
                        break;
                default: System.out.println("Opcao invalida");
            }
            
        }while(opcao!=0);
      
   }
}
