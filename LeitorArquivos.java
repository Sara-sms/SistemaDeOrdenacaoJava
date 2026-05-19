import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class LeitorArquivos {
    private static Produto[] produtosFinal;
    
    static List<Produto> produtos = new ArrayList<>();
    
    public static  void adicionarProduto(Produto produto){
        produtos.add(produto);
    }
    
    //Método responsável pela leitura do arquivo
    public static void lendoArquivo(String caminho){           
        try{    
            BufferedReader leitor = new BufferedReader(new FileReader(caminho));
            
            String linha;
            //Loop que percorre cada linha do arquivo separando e atribuindo seus respectivos campos nas variaveis, criando o objeto produto e adicionando-os na lista:
            while((linha  = leitor.readLine())!= null){
                String [] quebraDeLinha = linha.split("#");
                String nomeProduto = quebraDeLinha[0];
                String fabricante = quebraDeLinha[1];
                double preço = Double.parseDouble(quebraDeLinha[2].trim().replace(",", "."));
                String dataDeValidade = quebraDeLinha[3];
                String tipo = quebraDeLinha[4];
                Produto produto = new Produto(nomeProduto, fabricante, preço, dataDeValidade, tipo);
                adicionarProduto(produto);
            }            
        }catch(IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
    }

    //Método que passa os elementos da lista para o vetor:
    public void converterListaParaVetor() {
        produtosFinal = new Produto[produtos.size()];
        produtosFinal = produtos.toArray(produtosFinal);
    }

    public static Produto[] getProdutosFinal() {
        return produtosFinal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
