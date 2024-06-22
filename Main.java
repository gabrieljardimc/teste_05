package gestao_cinco;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		boolean clienteVIP = false;
		Produto p1 = new Produto("Arroz", 5, 18.75);
		Produto p2 = new Produto("Feijão", 1, 4.95);
		Produto p3 = new Produto("Leite", 1, 3.49);

		List<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(produtos, clienteVIP);
		double total = carrinho.calcularTotal();
		total = carrinho.aplicarDesconto(total);
		total = carrinho.adicionarTaxaDeEntrega(total);
		
		double[] vet1 = {90, 88, 78, 76};
        double[] vet2 = {865, 564, 43, 12};

        double media1 = CalculadoraDeMedia.calcularMedia(vet1);
        System.out.println("Média do vetor 1: " + media1);

        double media2 = CalculadoraDeMedia.calcularMedia(vet2);
        System.out.println("Média do vetor 2: " + media2);

		System.out.println(total);
	}
}
