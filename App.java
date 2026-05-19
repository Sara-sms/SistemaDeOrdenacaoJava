import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;

public class App{
    public static void main(String args[]){
        
        // Checa se os arquivos já foram criados ou não
        boolean precisaGerar = false;
        if (!new File("produtos_1000.txt").exists() ||
            !new File("produtos_10000.txt").exists() ||
            !new File("produtos_100000.txt").exists() ||
            !new File("produtos_1000000.txt").exists()) {
            
            precisaGerar = true;
        }
        if(precisaGerar==true){
            GeradorProduto.main(new String[0]);
        }

        LeitorArquivos leitor = new LeitorArquivos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo que voce deseja ordenar: ");
        String caminho = scanner.next();
        File arquivo = new File(caminho);

        leitor.lendoArquivo(caminho);
        leitor.converterListaParaVetor();
        
        Ordenacoes ordenacao = new Ordenacoes();
        Produto[] produtosFinal = leitor.getProdutosFinal();
        System.out.println("Voce deseja ordenar de que forma?\n ");
        System.out.println("1 - Ordenar por nome com ShellSort\n");
        System.out.println("2 - Ordenar por preco com QuickSort\n");
        System.out.println("3 - Ordenar por nome com InsertSort\n");
        int escolha = scanner.nextInt();

        System.out.println("Tamanho do vetor: " + produtosFinal.length);
        System.out.println("-----------------");

        
        if(escolha == 1){
            ordenacao.ordenacaoPorNomeShell(produtosFinal);
            for(int i = 0;i < produtosFinal.length-1;i++){
                System.out.println("Nome:" +produtosFinal[i].getNomeDoProduto()+"Fabricante:"+produtosFinal[i].getFabricante() + "| Preco: " + produtosFinal[i].getPreço() + "| Validade: "+produtosFinal[i].getDataDeValidade());
        
            }
            
        }else if(escolha==2){
            ordenacao.ordenacaoPorPrecoQuicksort(produtosFinal, 0, produtosFinal.length-1);
            for(int i = 0;i < produtosFinal.length-1;i++){
                System.out.println("Nome:" +produtosFinal[i].getNomeDoProduto()+"Fabricante:"+produtosFinal[i].getFabricante() + " | Preco: " + produtosFinal[i].getPreço() + " | Validade: "+produtosFinal[i].getDataDeValidade());
        
            }
        }else if(escolha==3){
            LinkedList<Produto> listaOrdenada = ordenacao.ordenaPorInsertSort(produtosFinal);
            for(Produto p : listaOrdenada){
                System.out.println("Nome: " + p.getNomeDoProduto()+"Fabricante:" +p.getFabricante()+" | Preco: " + p.getPreço()+" | Validade: "+ p.getDataDeValidade());
        
            }
        
        }       
    }     
}
    
