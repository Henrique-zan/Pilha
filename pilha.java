package pilha;
import java.util.Scanner;
class nodapilha {
    int dado;
    nodapilha proximo;

    public nodapilha(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class Pilha {
    private nodapilha topo;

    public Pilha() {
        this.topo = null;
    }

    public boolean vazia() {
        return topo == null;
    }

    public void insere(int dado) {
        nodapilha novoNo = new nodapilha(dado);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public int remove() {
        if (vazia()) {
            System.out.println("A pilha esta vazia. Nao e possivel remover elementos.");
            return -1; // Valor de erro
        }

        int valorRemovido = topo.dado;
        topo = topo.proximo;
        return valorRemovido;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("A pilha esta vazia.");
            return;
        }

        System.out.print("Elementos da pilha: ");
        nodapilha atual = topo;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner scanner = new Scanner(System.in);

         int escolha = -1; 

        while (escolha != 0) {
            System.out.println("...........................................");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Remover elemento");
            System.out.println("3 - Imprimir pilha");
            System.out.println("0 - Sair");
            System.out.println("...........................................");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite os numeros a serem inseridos (digite 0 para parar):");
                    int numeroInserir;
                    while ((numeroInserir = scanner.nextInt()) != 0) {
                        pilha.insere(numeroInserir);
                    }
                    pilha.imprime(); 
                    System.out.println("----------------------------------------------");
                    break;
                case 2:
                    int numeroRemovido = pilha.remove();
                    if (numeroRemovido != -1) {
                        System.out.println("Removido: " + numeroRemovido);
                    }
                    pilha.imprime(); 
                    System.out.println("----------------------------------------------");
                    break;
                case 3:
                    pilha.imprime();
                    break;
                case 0:
                    scanner.close();
                    break;
                
            }
        }
    }
}