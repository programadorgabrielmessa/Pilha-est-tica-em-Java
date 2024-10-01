// Aplicação de Filas - Colorir Regiões Gráficas
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;

public class RegGrafica {
    private static Queue<Integer> F; // Fila para a aplicação
    private static int x, y; // Coordenadas do ponto
    private static String[][] imagem; // Matriz da imagem
    private static int MAX; // Tamanho da matriz

    // Inicia o vetor imagem com uma configuração padrão
    private static void inicio() {
        String A, B, C;
        // Solicita as 3 cores da imagem da cadeira
        A = JOptionPane.showInputDialog("Qual a cor 0?");
        B = JOptionPane.showInputDialog("Qual a cor 1?");
        C = JOptionPane.showInputDialog("Qual a cor 2?");
        // Inicializa a matriz com uma cor padrão
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                imagem[i][j] = " ";
            }
        }
        // Atribui as cores às posições
        imagem[0][0] = imagem[1][3] = imagem[2][1] = imagem[2][2] = imagem[2][3] = imagem[3][1] = imagem[3][3] = imagem[4][2] = B;
        imagem[0][1] = imagem[1][1] = imagem[1][0] = imagem[0][2] = A;
        imagem[0][3] = imagem[0][4] = imagem[1][2] = imagem[1][4] = imagem[2][0] = imagem[2][4] = imagem[3][0] = C;
        imagem[3][2] = imagem[3][4] = imagem[4][0] = imagem[4][1] = imagem[4][3] = imagem[4][4] = C;
    }

    // Insere um ponto na Fila (x e y)
    private static void qIns(int novo_x, int novo_y) {
        F.add(novo_x);
        F.add(novo_y);
    }

    // Remove um ponto da Fila (x e y)
    private static void qRem() {
        x = F.poll();
        y = F.poll();
    }

    // Imprime o conteúdo da Matriz
    private static void imprime() {
        StringBuilder saida = new StringBuilder("..:: Estado da Matriz ::..\n\n");
        for (int lin = 0; lin < MAX; lin++) {
            for (int col = 0; col < MAX; col++)
                saida.append(imagem[lin][col]).append(" ");
            saida.append("\n");
        }
        JOptionPane.showMessageDialog(null, saida.toString());
    }

    public static void main(String[] args) {
        String cor_original, nova_cor;
        MAX = 5;
        F = new LinkedList<>();
        // Cria a matriz da imagem
        imagem = new String[MAX][MAX];
        // Atribui cores iniciais
        inicio();
        // Imprime estado inicial
        imprime();
        // Solicita o ponto inicial P0
        try {
            x = Integer.parseInt(JOptionPane.showInputDialog("Entre com a coordenada X (0 a " + (MAX - 1) + "):"));
            y = Integer.parseInt(JOptionPane.showInputDialog("Entre com a coordenada Y (0 a " + (MAX - 1) + "):"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida!");
            return;
        }
        // Valida as coordenadas
        if (x < 0 || x >= MAX || y < 0 || y >= MAX) {
            JOptionPane.showMessageDialog(null, "Coordenadas fora do intervalo!");
            return;
        }
        // Captura a cor original da imagem C0
        cor_original = imagem[x][y];
        // Verifica se a cor original é nula
        if (cor_original == null || cor_original.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma cor definida nesta posição!");
            return;
        }
        // Solicita nova cor
        nova_cor = JOptionPane.showInputDialog("Entre com a Nova Cor (exceto " + cor_original + "):");
        // Verifica se a nova cor é válida
        if (nova_cor.equals(cor_original)) {
            JOptionPane.showMessageDialog(null, "A nova cor deve ser diferente da cor original!");
            return;
        }
        // Insere o ponto na Fila
        qIns(x, y);
        // Enquanto a Fila não estiver vazia
        while (!F.isEmpty()) {
            // Remove um ponto da Fila
            qRem();
            // Verifica se o ponto atual ainda tem a cor original
            if (imagem[x][y] != null && imagem[x][y].equals(cor_original)) {
                // Troca a cor do ponto para a nova cor
                imagem[x][y] = nova_cor;
                // Insere os pontos conectados com a mesma cor
                if (x < MAX - 1 && imagem[x + 1][y] != null && imagem[x + 1][y].equals(cor_original))
                    qIns(x + 1, y);
                if (y > 0 && imagem[x][y - 1] != null && imagem[x][y - 1].equals(cor_original))
                    qIns(x, y - 1);
                if (x > 0 && imagem[x - 1][y] != null && imagem[x - 1][y].equals(cor_original))
                    qIns(x - 1, y);
                if (y < MAX - 1 && imagem[x][y + 1] != null && imagem[x][y + 1].equals(cor_original))
                    qIns(x, y + 1);
            }
        }
        // Imprime a matriz de imagem após a mudança
        imprime();
        // Fim
        System.exit(0);
    }
}
