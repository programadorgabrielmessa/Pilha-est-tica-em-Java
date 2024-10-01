//TAD que implementa uma Pilha
public class Pilha {
    private int topo;    // Topo da Pilha
    private int MAX;     // Tamanho da Pilha
    private Object memo[]; // Elementos da Pilha (objeto genérico)

    // Método que inicializa a Pilha no estado vazia
    public Pilha() {
        topo = -1;
        MAX = 30;
        memo = new Object[MAX];
    }

    // Método que verifica se a Pilha está Vazia 
    public boolean isEmpty() {
        return (topo == -1);
    }

    // Método que verifica se a Pilha está cheia
    private boolean isFull() {
        return (topo == MAX - 1);
    }

    // Método para inserir um valor na Pilha
    public void push(Object x) {
        if (!isFull()) {
            topo++;
            memo[topo] = x;
        } else {
            System.out.println("Pilha Cheia!!");
        }
    }

    // Método para exibir o conteúdo da Pilha
    public void print() {
        if (!isEmpty()) {
            String msg = "";
            for (int i = 0; i <= topo; i++) {
                msg += memo[i].toString() + ", ";
            }
            System.out.println("P: [ " + msg + " ]");
        } else {
            System.out.println("Pilha Vazia!!");
        }
    }

    // Método para retornar o topo da Pilha e removê-lo
    public Object pop() {
        if (!isEmpty())
            return memo[topo--];
        else
            return null;
    }

    // Método que retorna o topo da pilha sem removê-lo
    public Object top() {
        if (!isEmpty())
            return memo[topo];
        else
            return null;
    }
}
