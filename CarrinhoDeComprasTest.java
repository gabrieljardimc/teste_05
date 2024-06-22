package gestao_cinco;

import org.junit.Test;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CarrinhoDeComprasTest {

    @Test
    public void testCalcularTotal() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 5, 18.75));
        produtos.add(new Produto("Feijão", 1, 4.95));
        produtos.add(new Produto("Leite", 1, 3.49));
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(produtos, false);

        assertEquals(102.19, carrinho.calcularTotal(), 0.01);
    }

    @Test
    public void testAplicarDescontoClienteVIP() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 5, 18.75));
        produtos.add(new Produto("Feijão", 1, 4.95));
        produtos.add(new Produto("Leite", 1, 3.49));
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(produtos, true);

        double total = carrinho.calcularTotal();
        assertEquals(91.971, carrinho.aplicarDesconto(total), 0.01);
    }

    @Test
    public void testAplicarDescontoClienteNaoVIP() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 5, 18.75));
        produtos.add(new Produto("Feijão", 1, 4.95));
        produtos.add(new Produto("Leite", 1, 3.49));
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(produtos, false);

        double total = carrinho.calcularTotal();
        assertEquals(97.08, carrinho.aplicarDesconto(total), 0.01);
    }

    @Test
    public void testAdicionarTaxaDeEntrega() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 5, 18.75));
        produtos.add(new Produto("Feijão", 1, 4.95));
        produtos.add(new Produto("Leite", 1, 3.49));
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(produtos, false);

        double total = carrinho.calcularTotal();
        total = carrinho.aplicarDesconto(total);

        // Testando taxa de entrega no domingo
        assertEquals(107.08, carrinho.adicionarTaxaDeEntrega(total, DayOfWeek.SUNDAY), 0.01);
        // Testando taxa de entrega em outro dia
        assertEquals(102.08, carrinho.adicionarTaxaDeEntrega(total, DayOfWeek.MONDAY), 0.01);
    }
}