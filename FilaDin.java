// Implementação de uma Fila Dinâmica com uma lista simplesmente encadeada
public class FilaDin {
    Node comeco; //Comeco da Fila
    Node fim; //Fim da Fila
    int total; //Contador de elementos
    public FilaDin() {
    comeco = null;
    fim = null;
    total = 0;
    }
    public boolean qIsEmpty() {
    return(total==0);
    }
    public void enqueue(Object x) {
    Node novo = new Node();
    //Cria um novo nó
    novo.setDado(x);
    //Coloca o dado dentro do nó
    novo.setProx(null);
    //Como esse será o último, não tem próximo
    if(qIsEmpty()) {
    comeco = novo;
    //Como estava vazia, esse nó será começo e fim
    fim= comeco;
    }
    else {
    fim.setProx(novo);
    //Depois do fim da fila atual, o novo nó
    fim = novo;
    //O novo fim é o novo nó
    }
    total++;
    //Incrementa o número de elementos
    }
    public Object dequeue() {
    Object resp = null;
    if(!qIsEmpty()) {
    resp = comeco.getDado();
    //Captura o dado do começo da Fila
    comeco = comeco.getProx();
    //O começo anda para o próximo
    total--;
    //Decrementa número de elementos
    return resp;
    }
    return resp;
    }
    public void qPrint() {
    if(qIsEmpty())
    System.out.println("Fila Vazia!");
    else {
    Node aux;
    String saida = "";
    aux = comeco;
    while(aux!=null) {
    saida += aux.getDado().toString() + ", ";
    aux = aux.getProx();
    }
    System.out.println("F:[ "+saida+"]");
    }
    }
    }
    