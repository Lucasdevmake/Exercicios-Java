import java.util.ArrayList;

public class CarrinhoDeCompras {

//  private ArrayList<String> produtos = new ArrayList<String>();
    private ArrayList<Produtos> produto; // cria array produto

    public CarrinhoDeCompras() {   // construtor da classe que adiciona objeto no array
        produto = new ArrayList<Produtos>();
    }

    public void adicionaProduto(Produtos produtoAserAdd) { //metodo adiciona produto
        produto.add(produtoAserAdd);
    }
    public void removerProduto(Produtos produtoAserRemovido) { //metodo remove produto
        produto.remove(produtoAserRemovido);
    }


}
