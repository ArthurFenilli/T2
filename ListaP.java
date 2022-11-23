
/**
 * Escreva uma descrição da classe ListaP aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ListaP
{
    private Partida[] lista_partidas;
    private int index;
    private int ordem;
    
    public ListaP(int quant_partidas){
        lista_partidas = new Partida[quant_partidas];
        index = 0;
        ordem = 1;
}


public boolean incluiPartida(int cod1, int cod2,String data, int pont1, int pont2){
    if(index == lista_partidas.length)return false;
    lista_partidas[index] = new Partida(cod1, cod2, data, pont1, pont2, ordem);
    index++;
    ordem++;
    return true;
}


public Partida consultaPartida(int num){
  for(int i = 0; i<index;i++){
    if(lista_partidas[i].getCodigo3() == num) return lista_partidas[i]; 
  }
  return null;
}


public boolean excluiPartida(int num){
    int diminui = Integer.MAX_VALUE;
    
    if(consultaPartida(num) == null) return false;
    lista_partidas[num - 1] = null;
    for(int i = 0; i<index; i++){
        if(lista_partidas[i] == null){
            diminui = i;
        }
        if(i>diminui){
            int j = i - 1;
            lista_partidas[j] = lista_partidas[i];
        }
    }
    lista_partidas[lista_partidas.length - 1] = null;
    index--;
    return true;
}


public boolean mudaData(int num, String novaData){
   return true; 
}


public boolean mudaPontuação(int num, int pontuação, int opcao){
    if(consultaPartida(num)== null || num!=1 && num!=2)return false;
    if(opcao == 1)lista_partidas[num-1].setPontuação1(pontuação);
    if(opcao == 2)lista_partidas[num-1].setPontuação2(pontuação);
    return true;    
}
}