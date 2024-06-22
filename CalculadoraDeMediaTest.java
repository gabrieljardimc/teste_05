package gestao_cinco;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculadoraDeMediaTest {
    @Test
    public void testCalcularMediaVet1() {
        double[] vet1 = {90, 88, 78, 76};
        assertEquals(83.0, CalculadoraDeMedia.calcularMedia(vet1), 0.01);
    }

    @Test
    public void testCalcularMediaVet2() {
        double[] vet2 = {865, 564, 43, 12};
        assertEquals(371.0, CalculadoraDeMedia.calcularMedia(vet2), 0.01);
    }
}
