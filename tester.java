
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
      ListaP teste1 = new ListaP(5);
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
                
                case 5: System.out.println(teste1.somaGols(teste.consultarTime(1),teste1));
                
                case 6: int cod1 = teclado.nextInt();
                        int cod2 = teclado.nextInt();
                        int pont1 = teclado.nextInt();
                        int pont2 = teclado.nextInt();
                        String data = in.nextLine();
                        teste1.incluiPartida(cod1, cod2,data,pont1, pont2);                
                default: System.out.println("Opcao invalida");
            }
            
        }while(opcao!=0);
      
   }
}
