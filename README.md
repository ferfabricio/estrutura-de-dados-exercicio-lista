# ATENÇÃO!!!
Esta atividade será realizada em grupo de até 5 integrantes, sendo obrigatório a inscrição em algum grupo para a entrega das atividades somativas (avaliativas). Sem a inscrição em um grupo, o sistema não aceita a entrega da atividade.
___________________________________________

# Atividade

Uma Lista é uma estrutura de dados dinâmica, onde o número de nós de uma lista pode variar consideravelmente à medida que são inseridos e removidos os elementos.
Cada elemento de uma lista encadeada (nó) é constituído de dois campos: valor e próximo elemento. Conforme foi apresentado na semana 4 a estrutura de dados, lista, elabore em grupo (não esqueça de se inscrever na semana 3), uma lista dinâmica de números inteiros em Java.
A lista deverá possuir um objeto Nó (classe No) e ter os métodos listados abaixo.

## Entrega
Deverá comprimir a pasta src do projeto em .zip e realizar a entrega no Blackboard.

## Interface

```
boolean vazia()
void inserePrimeiro(int info)
void insereDepois(No no, int info)
void insereUltimo(int info)
No removePrimeiro()
No removeUltimo()
No remove(No no)
void mostrar()
```

## Observação

A interface proposta insere inteiros porém não retorna a referência do nó gerado. Para os métodos insereDepois e remove não teríamos a referência do Nó inserido para utilizar como parâmetro, desta forma alteramos a interface para ter o retorno do nó toda vez que é criado um novo elemento.

```
    boolean vazia();
    No inserePrimeiro(int info);
    No insereDepois(No no, int info);
    No insereUltimo(int info);
    No removePrimeiro() throws ListaVaziaException;
    No removeUltimo();
    No remove(No no);
    void mostrar();
```

