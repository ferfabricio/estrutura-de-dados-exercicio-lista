public class No {
    private int valor;
    private No proximoElemento;

    public No(int valor){
        this.setValor(valor);
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public void setProximoElemento(No el){
        this.proximoElemento = el;
    }

    public No getProximoElemento() {
        return this.proximoElemento;
    }
}
