package gestao_cinco;

public class CalculadoraDeMedia {
    public static double calcularMedia(double[] vetor) {
        double soma = 0;
        for (double v : vetor) {
            soma += v;
        }
        return soma / vetor.length;
    }
}
