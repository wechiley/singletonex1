package com.exemplo;



import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class CriptoMoedaTest {

    @Test
    public void testGetInstance() {
        CriptoMoeda cripto = CriptoMoeda.getInstance("Bitcoin", 30000.0);
        assertNotNull(cripto);
        assertEquals("Bitcoin", cripto.getNome());
        assertEquals(30000.0, cripto.getTaxaConversao(), 0.01);
    }

    @Test
    public void testAlterarInformacoes() {
        CriptoMoeda cripto = CriptoMoeda.getInstance("Bitcoin", 30000.0);
        cripto.setNome("Ethereum");
        cripto.setTaxaConversao(2000.0);
        assertEquals("Ethereum", cripto.getNome());
        assertEquals(2000.0, cripto.getTaxaConversao(), 0.01);
    }

    @Test
    public void testConverter() {
        CriptoMoeda cripto = CriptoMoeda.getInstance("Bitcoin", 30000.0);
        double valorConvertido = cripto.converter(1.0, 0.00005);
        assertEquals(600.0, valorConvertido, 0.01);
    }

    @Test
    public void testSingleton() {
        CriptoMoeda cripto1 = CriptoMoeda.getInstance("Bitcoin", 30000.0);
        CriptoMoeda cripto2 = CriptoMoeda.getInstance("Ethereum", 2000.0);
        assertSame(cripto1, cripto2);
        assertEquals("Bitcoin", cripto1.getNome());
        assertEquals(30000.0, cripto1.getTaxaConversao(), 0.01);
    }
}
