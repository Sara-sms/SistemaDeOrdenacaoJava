import java.util.LinkedList;


public class Ordenacoes {
    
    //Métodos auxiliares a serem usados no shellSort:
    public Produto[] selectSort(Produto[] produto){
        for(int i = 0; i < produto.length-1; i++){
            int min = i;
            for(int j = i+1; j<produto.length; j++){
                if(produto[j].getNomeDoProduto().compareTo(produto[min].getNomeDoProduto())<0){
                    min = j;
                }
                
            }
            Produto temp = produto[min];
            produto[min] = produto[i];
            produto[i] = temp;
        }
        return produto;
    }

    public Produto[] insertionSort(Produto[] produto){
        int i, j;
        Produto chave;
        for(j = 1; j<produto.length-1; j++){
            chave = produto[j]; 
            i = j-1;
            while(i>=0 && produto[i].getNomeDoProduto().compareTo(chave.getNomeDoProduto())>0){
                produto[i+1] = produto[i];
                i--;
            }
            produto[i+1] = chave;
        }
        return produto;
    }
    
    //Método de ordenação por nome usando ShellSort junto com selectSort e insertionSort:
    public Produto[] ordenacaoPorNomeShell(Produto[] produto){
        int h;  
        for(h = 1; h < produto.length; h = (3*h)+1);

        while(h>0){
            h = (h-1)/3;
            if(h>1){
                selectSort(produto);
            }else{
                insertionSort(produto);
            }
        }
        return produto;
    }           

    // Método de ordenacao por preço usando QuickSort:
    public void ordenacaoPorPrecoQuicksort(Produto[] produto,int inicio, int fim){
        if(inicio<fim){
            int posicaoPivo = particiona(produto, inicio, fim);

            ordenacaoPorPrecoQuicksort(produto, inicio, posicaoPivo-1);
            ordenacaoPorPrecoQuicksort(produto, posicaoPivo+1, fim);
        }
    }

    public int particiona(Produto produto[], int inicio, int fim){
        int meio = inicio + (fim - inicio)/2;
        int indicePivo = medianaDeTres(produto,inicio,meio,fim);
        double pivo = produto[indicePivo].getPreço();

        Produto temp = produto[indicePivo];
        produto[indicePivo] = produto[fim];
        produto[fim] =temp;

        int i = inicio - 1;
        int j = inicio;
        while(j < fim){
            if(produto[j].getPreço() <= pivo){
                i++;
                Produto troca = produto[i];
                produto[i] = produto[j];
                produto[j] = troca;
                

            }
            j++;
        }
        Produto temp2 = produto[i+1];
        produto[i+1] = produto[fim];
        produto[fim] = temp2;

        return i+1;
    }

    // Calcula a mediana de 3 para ser usada como pivo
    public int medianaDeTres(Produto[] produto, int a, int b, int c){
        double valorA = produto[a].getPreço();
        double valorB = produto[b].getPreço();
        double valorC = produto[c].getPreço();

        if((valorA<=valorB && valorB <= valorC) || (valorC <= valorB && valorB <= valorA)) {
            return b;
        } else if ((valorB <= valorA && valorA <= valorC) || (valorC <= valorA && valorA <= valorB)) {
            return a;
        } else {
            return c;
        }
    }

    //Ordenação por nome em ordem alfabética(lexográfica) usando insertsort
    public LinkedList<Produto> ordenaPorInsertSort(Produto[] produtos){
        LinkedList<Produto> listaDeProdutos = new LinkedList<>();
        //Após a lista ser criada, o for adiciona os elementos do vetor na lista
        for(Produto produto: produtos){
            listaDeProdutos.add(produto);
        }

        int i,j;
        Produto chave;
        //Com todos os elementos na lista, inicia-se a ordenação por nome:
        for(j = 1; j<listaDeProdutos.size(); j++){
            chave = listaDeProdutos.get(j);
            i = j-1;

            while(i>=0 && listaDeProdutos.get(i).getNomeDoProduto().compareTo(chave.getNomeDoProduto())>0){
                listaDeProdutos.set(i+1,listaDeProdutos.get(i));
                i--;
            }
            listaDeProdutos.set(i+1, chave);
            
        }
        return listaDeProdutos;

    }
}
    