public class Lista implements ILista {
    private No primeiroNo;

    @Override
    public boolean vazia() {
        return this.primeiroNo == null;
    }

    @Override
    public No inserePrimeiro(int info) {
        No no = new No(info);

        if (!this.vazia()) {
            no.setProximoElemento(this.primeiroNo);
        }

        this.primeiroNo = no;

        return no;
    }

    @Override
    public No insereDepois(No no, int info) {
        No novo = new No(info);

        if (this.primeiroNo == no) {
            this.primeiroNo.setProximoElemento(novo);
        } else {
            No check = this.primeiroNo.getProximoElemento();
            while (check != no) {
                check = check.getProximoElemento();
            }
            novo.setProximoElemento(check.getProximoElemento());
            check.setProximoElemento(novo);
        }

        return novo;
    }

    @Override
    public No insereUltimo(int info) {
        No novo = new No(info);

        if (this.primeiroNo == null) {
            this.primeiroNo = novo;
        } else {
            No no = this.primeiroNo;
            boolean ultimo = false;
            while (!ultimo) {
                if (no.getProximoElemento() != null) {
                    no = no.getProximoElemento();
                } else {
                    no.setProximoElemento(novo);
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

        if (no.getProximoElemento() != null) {
            this.primeiroNo = no.getProximoElemento();
        } else {
            this.primeiroNo = null;
        }

        return no;
    }

    @Override
    public No removeUltimo() {
        No anterior;
        No no = this.primeiroNo;

        if (this.primeiroNo.getProximoElemento() == null) {
            this.primeiroNo = null;
            return no;
        }
        anterior = no;
        boolean ultimo = false;
        while (!ultimo) {
            if (no.getProximoElemento() == null) {
                ultimo = true;
                anterior.setProximoElemento(null);
            } else {
                anterior = no;
                no = no.getProximoElemento();
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
            No check = this.primeiroNo.getProximoElemento();
            No anterior = this.primeiroNo;
            while (check != no) {
                anterior = check;
                check = check.getProximoElemento();
            }
            anterior.setProximoElemento(check.getProximoElemento());
            return check;
        }
    }

    @Override
    public void mostrar() {
        No no = this.primeiroNo;
        int i = 1;
        boolean ultimo = false;
        while(!ultimo) {
            System.out.printf("No: %d, Valor: %d, Existe proximo: %s\n", i, no.getValor(), no.getProximoElemento() == null ? "Nao" : "Sim");
            if (no.getProximoElemento() != null) {
                no = no.getProximoElemento();
            } else {
                ultimo = true;
            }

            i++;
        }
    }
}
