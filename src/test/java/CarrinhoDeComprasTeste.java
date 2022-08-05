import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarrinhoDeComprasTeste {

    @Test //função de teste não precisa retornar(void)
    public void DeveCalcularTotalComDoisProdutos() {

        //cenário
        Produtos produto1 = new Produtos("queijo", 10);
        Produtos produto2 = new Produtos("presunto", 30);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaProduto(produto1);
        carrinho.adicionaProduto(produto2);

        // ação
        double resultado = carrinho.CalcularValorTotalASerPago();

        // verificação
        Assertions.assertEquals(40, resultado);


        }

    @Test
    public void DeveCalcularValorTotalASerPagoQuandoOCarrinhoEstaVazio() {

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        // Ação
        double resultado = carrinho.CalcularValorTotalASerPago();

        // Validação
        Assertions.assertEquals(0,resultado);
        }

    @Test
    public void DeveCalcularValorTotalQuandoUmItemForCancelado() {
        //cenário
        Produtos produto1 = new Produtos("queijo",10);
        Produtos produto2 = new Produtos("presunto",30);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaProduto(produto1);
        carrinho.adicionaProduto(produto2);

        // ação
        double resultado = carrinho.CalcularValorTotalASerPago();

        // verificação
        Assertions.assertEquals(40, resultado);

        // ação
        carrinho.removerProduto(produto2);
        double resultadoAposRemocao = carrinho.CalcularValorTotalASerPago();

        // verificação
        Assertions.assertEquals(10,resultadoAposRemocao);


        }
    }



