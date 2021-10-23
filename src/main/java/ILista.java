public interface ILista {
    boolean vazia();
    No inserePrimeiro(int info);
    No insereDepois(No no, int info);
    No insereUltimo(int info);
    No removePrimeiro() throws ListaVaziaException;
    No removeUltimo();
    No remove(No no);
    void mostrar();
}
