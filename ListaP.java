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

public int descobrePosição(Time time, Partida partida){
    for(int i = 0; i<index; i++){
       if(lista_partidas[i].getCodigo3() == partida.getCodigo3()){
           if(lista_partidas[i].getCodigo1() == time.getCodigo()) return 1;
           if(lista_partidas[i].getCodigo2() == time.getCodigo()) return 2;
           
       }
       
    }
    return 0;
}


public int descobreGol(Time time, Partida partida){
    if(descobrePosição(time,partida) == 1) return partida.getPontuação1();
    else if(descobrePosição(time,partida) == 2) return partida.getPontuação2();
    else return 0;
    
}

public int somaGols(Time time, ListaP lista){
    int soma = 0;
    for(int i = 0; i<index; i++){
        if(lista.descobrePosição(time,lista_partidas[i]) == 1 || lista.descobrePosição(time,lista_partidas[i]) == 2){
          soma = soma + descobreGol(time, lista_partidas[i]); 
        }
    }
    return soma;
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



public boolean mudaPontuação(int num, int pontuação, int opcao){
    if(consultaPartida(num)== null || num!=1 && num!=2)return false;
    if(opcao == 1)lista_partidas[num-1].setPontuação1(pontuação);
    if(opcao == 2)lista_partidas[num-1].setPontuação2(pontuação);
    return true;    
}

public char descobreResultado(Partida partida, Time time){
    for(int i=0;i<index;i++){
        if(lista_partidas[i] == partida){
            if(descobrePosição(time,lista_partidas[i] ) == 1){
                if(lista_partidas[i].getPontuação1()>lista_partidas[i].getPontuação2()) { return 'V'; }
                    else if(lista_partidas[i].getPontuação1()<lista_partidas[i].getPontuação2()) { return 'D'; }
                        else { return 'E';}
            }
            else if(descobrePosição(time, lista_partidas[i]) == 2){
                if(lista_partidas[i].getPontuação1()>lista_partidas[i].getPontuação2()) { return 'V'; }
                    else if(lista_partidas[i].getPontuação1()<lista_partidas[i].getPontuação2()) { return 'D'; }
                        else { return 'E'; }                    
            }
        }
    }
    return '.';
}

public int contaVitorias(Time time){
     int contV = 0;
    for(int i = 0;i<index;i++){
        if(lista_partidas[i].getCodigo1() == time.getCodigo() || lista_partidas[i].getCodigo2() == time.getCodigo()){
            if(descobreResultado(lista_partidas[i], time) == 'V'){ contV++;}
        }
    }
    return contV;
}

public int contaDerrotas(Time time){
     int contD = 0;
    for(int i = 0;i<index;i++){
        if(lista_partidas[i].getCodigo1() == time.getCodigo() || lista_partidas[i].getCodigo2() == time.getCodigo()){
            if(descobreResultado(lista_partidas[i], time) == 'D'){ contD++; }
        }
    }
    return contD;
}

public int contaEmpates(Time time){
    
    int contE = 0;
    
    for(int i = 0;i<index;i++){
        if(lista_partidas[i].getCodigo1() == time.getCodigo() || lista_partidas[i].getCodigo2() == time.getCodigo()){
            if(descobreResultado(lista_partidas[i], time) == 'E'){ contE++; }
        }
    }
    return contE;
}

public int contaPontos(Time time){
    int contP = 0, v =contaVitorias(time) * 3 , e =contaEmpates(time) ;
    
    contP = v;
    contP = contP + e;
    return contP;
    
}
public int contaJogos(Time time){
    
    int contJ = 0;
    
    for(int i = 0;i<index;i++){
        if(lista_partidas[i].getCodigo1() == time.getCodigo() || lista_partidas[i].getCodigo2() == time.getCodigo()){ contJ++ }
    }
    return contJ;
}
public int golsPro(Time time){
    contGP = 0;
    for(int i = 0; i < index; i++){
        if(lista_partidas[i].getCodigo1() == time.getCodigo() || lista_partidas[i].getCodigo2() == time.getCodigo()){
            if(descobrePosição(time,lista_partidas[i] ) == 1){
                contGP += lista_partidas[i].getPontuação1();
            }       
            else{
                contGP += lista_partidas[i].getPontuação2();            
            }
        }
    }
    return GP;
}
public int golsContra(Time time){
    contGC = 0;
    for(int i = 0; i < index; i++){
        if(lista_partidas[i].getCodigo1() == time.getCodigo() || lista_partidas[i].getCodigo2() == time.getCodigo()){
            if(descobrePosição(time,lista_partidas[i] ) == 1){
                contGC += lista_partidas[i].getPontuação2();
            }       
            else{
                contGC += lista_partidas[i].getPontuação1();            
            }
        }
    }
    return GC;
}
public int saldoGols(Time time){
    int GP = golsPro(time), int GC = golsContra(time), saldo = (GP-GC);
    return saldo;
}
public int aproveitamento(Time time){
    int v = contaVitorias(time), int j = contaJogos(time), aproveitamento = ((v/j)*100);
    return aproveitamento;
}
}
