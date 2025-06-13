package URSS_SUBMARINE;
//Declara que esta classe (SUBMARINE.java) pertence ao pacote 'URSS_SUBMARINE'.
// Isso significa que o arquivo SUBMARINE.java deve estar localizado
// dentro de uma pasta chamada 'URSS_SUBMARINE', que por sua vez
// estará dentro da sua Source Folder (geralmente 'src' ou 'Portifolio/src').
//
import javax.swing.*; // Importa todas as classes do pacote 'javax.swing'.
// Este pacote é a base para criar interfaces gráficas de usuário (GUIs)
// em aplicações desktop Java (elementos como janelas, botões, painéis, etc.).    

import java.awt.*; // Importa todas as classes do pacote 'java.awt' (Abstract Window Toolkit).
// Contém classes fundamentais para gráficos, cores, fontes,
// e elementos gráficos de baixo nível usados pelo Swing.

import java.awt.event.ActionEvent;// Importa a classe 'ActionEvent', que representa um evento de ação.
// Por exemplo, um clique de botão, um tick de um Timer, etc.

import java.awt.event.ActionListener;// Importa a interface 'ActionListener'.
// Classes que implementam esta interface são capazes de "ouvir" e
// responder a eventos de ação, executando o método 'actionPerformed'.
//Declaração da classe principal do seu radar.
//'public class SUBMARINE' : Define uma classe pública chamada SUBMARINE.
//'extends JPanel' : Indica que SUBMARINE é um tipo de JPanel. JPanel é um componente leve
//                 do Swing que pode ser usado para agrupar outros componentes ou para desenhar.
//'implements ActionListener' : Declara que esta classe se compromete a fornecer uma implementação
//                             para todos os métodos definidos na interface ActionListener.
//                             Neste caso, ela implementará o método 'actionPerformed'.

//Define a cor de fundo deste JPanel como preto.
// Isso cria o fundo escuro típico de um radar.
public class submarine extends JPanel implements ActionListener {
	
    private static final long serialVersionUID = 1L; 

    // --- Configurações Básicas ---
    private double anguloAtual = 0; // Onde o feixe do radar está apontando
    private Timer timerDeAnimacao;  // O "relógio" que faz o feixe girar

    // --- Construtor (Isso é o que inicia o radar quando você cria um) ---
    public submarine() {
        setBackground(Color.BLACK); // Fundo preto
        timerDeAnimacao = new Timer(50, this); // Atualiza a cada 50 milissegundos
        timerDeAnimacao.start(); // Começa a animação
    }

    // --- Como Desenhar o Radar na Tela ---
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa o painel
        Graphics2D g2d = (Graphics2D) g; // Prepara para desenhar melhor

        int largura = getWidth();
        int altura = getHeight();
        int raio = Math.min(largura, altura) / 2 - 20; // Tamanho do radar, com margem
        int centroX = largura / 2;
        int centroY = altura / 2;

        g2d.setColor(Color.GREEN); // Cor verde para o radar
        g2d.setStroke(new BasicStroke(2)); // Linhas mais grossas

        // Desenha os círculos (anéis)
        for (int i = 0; i < 4; i++) {
            int raioDoAnel = raio - (i * raio / 4);
            g2d.drawOval(centroX - raioDoAnel, centroY - raioDoAnel, 2 * raioDoAnel, 2 * raioDoAnel);
        }

        // Desenha as linhas que dividem o radar
        for (int i = 0; i < 360; i += 45) {
            double rad = Math.toRadians(i);
            int x = centroX + (int) (raio * Math.cos(rad));
            int y = centroY + (int) (raio * Math.sin(rad));
            g2d.drawLine(centroX, centroY, x, y);
        }

        // Desenha o feixe verde que gira
        g2d.setColor(new Color(0, 255, 0, 100)); // Verde semi-transparente
        int feixeX = centroX + (int) (raio * Math.cos(anguloAtual));
        int feixeY = centroY + (int) (raio * Math.sin(anguloAtual));
        g2d.drawLine(centroX, centroY, feixeX, feixeY);
    }

    // --- O Que Acontece a Cada "Tick" do Relógio (Timer) ---
    @Override
    public void actionPerformed(ActionEvent e) {
        anguloAtual += Math.toRadians(2); // Gira o feixe 2 graus
        if (anguloAtual >= 2 * Math.PI) { // Mantém o ângulo "dentro" de uma volta completa
            anguloAtual -= 2 * Math.PI;
        }
        repaint(); // Pede pra tela redesenhar o radar (com o novo ângulo)
    }

    // --- Como Iniciar o Programa ---
    public static void main(String[] args) {
        // Isso é essencial para o Swing: faz a interface rodar corretamente
        SwingUtilities.invokeLater(() -> {
            JFrame janela = new JFrame("Radar do Submarino"); // Cria a janela principal
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
            janela.setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre em tela cheia
            janela.setUndecorated(true); // Tira as bordas da janela

            janela.add(new submarine()); // Adiciona o seu painel de radar à janela

            janela.setVisible(true); // Mostra a janela na tela
        });
    }
}
