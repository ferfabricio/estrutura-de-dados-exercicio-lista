public class Lista implements ILista {
    private No primeiroNo;

    @Override
    public boolean vazia() {
        return this.primeiroNo == null;
    }

    @Override
    public No inserePrimeiro(int info) {
        No no = new No();
        no.valor = info;

        if (!this.vazia()) {
            no.proximoElemento = this.primeiroNo;
        }

        this.primeiroNo = no;

        return no;
    }

    @Override
    public No insereDepois(No no, int info) {
        No novo = new No();
        novo.valor = info;

        if (this.primeiroNo == no) {
            this.primeiroNo.proximoElemento = novo;
        } else {
            No check = this.primeiroNo.proximoElemento;
            while (check != no) {
                check = check.proximoElemento;
            }
            novo.proximoElemento = check.proximoElemento;
            check.proximoElemento = novo;
        }

        return novo;
    }

    @Override
    public No insereUltimo(int info) {
        No novo = new No();
        novo.valor = info;
        if (this.primeiroNo == null) {
            this.primeiroNo = novo;
        } else {
            No no = this.primeiroNo;
            boolean ultimo = false;
            while (!ultimo) {
                if (no.proximoElemento != null) {
                    no = no.proximoElemento;
                } else {
                    no.proximoElemento = novo;
                    ultimo = true;
                }
            }
        }
        return novo;
    }

    @Override
    public No removePrimeiro() throws ListaVaziaException {
        if (this.primeiroNo == null) {
            throw new ListaVaziaException();
        }
        No no = this.primeiroNo;
        this.primeiroNo = null;
        return no;
    }

    @Override
    public No removeUltimo() {
        No anterior;
        No no = this.primeiroNo;

        if (this.primeiroNo.proximoElemento == null) {
            this.primeiroNo = null;
            return no;
        }
        anterior = no;
        boolean ultimo = false;
        while (!ultimo) {
            if (no.proximoElemento == null) {
                ultimo = true;
                anterior.proximoElemento = null;
            } else {
                anterior = no;
                no = no.proximoElemento;
            }
        }

        return no;
    }

    @Override
    public No remove(No no) {
        if (this.primeiroNo == no) {
            this.primeiroNo = null;
            return no;
        } else {
            No check = this.primeiroNo.proximoElemento;
            No anterior = this.primeiroNo;
            while (check != no) {
                anterior = check;
                check = check.proximoElemento;
            }
            anterior.proximoElemento = check.proximoElemento;
            return check;
        }
    }

    @Override
    public void mostrar() {
        No no = this.primeiroNo;
        int i = 1;
        boolean ultimo = false;
        while(!ultimo) {
            System.out.printf("No: %d, Valor: %d, Existe proximo: %s\n", i, no.valor, no.proximoElemento == null ? "Nao" : "Sim");
            if (no.proximoElemento != null) {
                no = no.proximoElemento;
            } else {
                ultimo = true;
            }

            i++;
        }
    }
}
