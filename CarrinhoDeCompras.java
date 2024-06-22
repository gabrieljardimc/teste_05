package gestao_cinco;

import java.time.DayOfWeek;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> produtos;
    private boolean clienteVIP;

    public CarrinhoDeCompras(List<Produto> produtos, boolean clienteVIP) {
        this.produtos = produtos;
        this.clienteVIP = clienteVIP;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        System.out.println("Total calculado: " + total); // Debug
        return total;
    }

    public double aplicarDesconto(double total) {
        double desconto = clienteVIP ? total * 0.90 : total * 0.95;
        System.out.println("Total com desconto: " + desconto); // Debug
        return desconto;
    }

    public double adicionarTaxaDeEntrega(double total, DayOfWeek diaSemana) {
        double totalComTaxa = diaSemana == DayOfWeek.SUNDAY ? total + 10.00 : total + 5.00;
        System.out.println("Total com taxa de entrega: " + totalComTaxa); // Debug
        return totalComTaxa;
    }
}
