import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ListaTest {

    @org.junit.jupiter.api.Test
    void testaListaVazia() {
        Lista lista = new Lista();
        assertTrue(lista.vazia());
    }

    @org.junit.jupiter.api.Test
    void testaListaComPrimeiroItemInserido() {
        Lista lista = new Lista();
        lista.inserePrimeiro(1);
        assertFalse(lista.vazia());
    }

    @org.junit.jupiter.api.Test
    void testaListaInserindoDuasVezesOPrimeiroItem() throws ListaVaziaException {
        Lista lista = new Lista();
        lista.inserePrimeiro(1);
        lista.inserePrimeiro(2);
        No no = lista.removePrimeiro();
        assertEquals(2, no.valor);
        assertEquals(1, no.proximoElemento.valor);
    }

    @org.junit.jupiter.api.Test
    void testarListaRemovendoOPrimeiroNoNumaListaCom1Item() throws ListaVaziaException {
        Lista lista = new Lista();
        lista.inserePrimeiro(1);
        No no = lista.removePrimeiro();
        assertEquals(1, no.valor);
        assertTrue(lista.vazia());
    }

    @org.junit.jupiter.api.Test
    void testarListaRemovendoOPrimeiroNoNumaListaVazia() {
        Lista lista = new Lista();
        assertThrows(ListaVaziaException.class, lista::removePrimeiro);
    }

    @org.junit.jupiter.api.Test
    void testarListaCom1ItemRemovendoUltimoItem() {
        Lista lista = new Lista();
        lista.inserePrimeiro(1);
        No no = lista.removeUltimo();
        assertEquals(1, no.valor);
    }

    @org.junit.jupiter.api.Test
    void testarListaComMultiplosItensRemovendoUltimoItem() {
        Lista lista = new Lista();
        lista.inserePrimeiro(1);
        lista.inserePrimeiro(2);
        lista.inserePrimeiro(3);
        No no = lista.removeUltimo();
        assertEquals(1, no.valor);
    }

    @org.junit.jupiter.api.Test
    void testarListaUmItemRemovendoUltimoItem() {
        Lista lista = new Lista();
        lista.inserePrimeiro(1);
        No no = lista.removeUltimo();
        assertEquals(1, no.valor);
        assertTrue(lista.vazia());
    }

    @org.junit.jupiter.api.Test
    void testarListaQuandoInserirUltimoComListaVazia() {
        Lista lista = new Lista();
        lista.insereUltimo(1);
        assertFalse(lista.vazia());
        No no = lista.removeUltimo();
        assertEquals(1, no.valor);
        assertTrue(lista.vazia());
    }

    @org.junit.jupiter.api.Test
    void testarListaQuandoInserirUltimoComMultiplosNos() {
        Lista lista = new Lista();
        lista.insereUltimo(1);
        lista.insereUltimo(2);
        lista.insereUltimo(3);
        assertFalse(lista.vazia());
        No no = lista.removeUltimo();
        assertEquals(3, no.valor);
    }

    @org.junit.jupiter.api.Test
    void testarListaInserindoDepoisListaCom1No() {
        Lista lista = new Lista();
        No no = lista.insereUltimo(1);
        No noTests = lista.insereDepois(no, 5);
        assertNull(noTests.proximoElemento);
        assertEquals(5, no.proximoElemento.valor);
    }

    @org.junit.jupiter.api.Test
    void testarListaInserindoDepoisDeItemEspecifico() {
        Lista lista = new Lista();
        lista.insereUltimo(1);
        lista.insereUltimo(2);
        lista.insereUltimo(3);
        lista.insereUltimo(4);
        lista.insereUltimo(5);
        No no = lista.insereUltimo(6);
        lista.insereUltimo(7);
        lista.mostrar();
        No noTests = lista.insereDepois(no, 8);
        assertEquals(7, noTests.proximoElemento.valor);
    }

    @org.junit.jupiter.api.Test
    void testarListaRemovendoNoQuandoExisteSomente1No() {
        Lista lista = new Lista();
        No no = lista.insereUltimo(1);
        assertFalse(lista.vazia());
        No noTests = lista.remove(no);
        assertTrue(lista.vazia());
        assertEquals(1, noTests.valor);
    }

    @org.junit.jupiter.api.Test
    void testarListaRemovendoNoQuandoExisteMultiplosNos() {
        Lista lista = new Lista();
        lista.insereUltimo(1);
        lista.insereUltimo(2);
        No no = lista.insereUltimo(3);
        lista.insereUltimo(4);
        No noTests = lista.remove(no);
        assertEquals(3, noTests.valor);

        No ultimo = lista.removeUltimo();
        assertEquals(4, ultimo.valor);
    }
}