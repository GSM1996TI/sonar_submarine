package submarino;
// Declara que esta classe pertence ao pacote 'submarino'.
// Isso significa que o arquivo SubmarinoRadar.java deve estar localizado
// dentro de uma pasta chamada 'submarino', que por sua vez
// estará dentro da sua Source Folder (geralmente 'src' ou 'Portifolio/src').

import javax.swing.*; // Importa todas as classes do pacote 'javax.swing'.
// Este pacote é a base para criar interfaces gráficas de usuário (GUIs)
// em aplicações desktop Java (elementos como janelas, botões, painéis, etc.).    

import java.awt.*; // Importa todas as classes do pacote 'java.awt' (Abstract Window Toolkit).
// Contém classes fundamentais para gráficos, cores, fontes,
// e elementos gráficos de baixo nível usados pelo Swing.

import java.awt.event.ActionEvent; // Importa a classe 'ActionEvent', que representa um evento de ação.
// Por exemplo, um clique de botão, um tick de um Timer, etc.

import java.awt.event.ActionListener; // Importa a interface 'ActionListener'.
// Classes que implementam esta interface são capazes de "ouvir" e
// responder a eventos de ação, executando o método 'actionPerformed'.

// Declaração da classe principal do seu radar.
// 'public class SubmarinoRadar' : Define uma classe pública chamada SubmarinoRadar.
//                                 (Alterei o nome da classe para começar com maiúscula,
//                                  seguindo convenções de Java para nomes de classes).
// 'extends JPanel' : Indica que SubmarinoRadar é um tipo de JPanel. JPanel é um componente leve
//                  do Swing que pode ser usado para agrupar outros componentes ou para desenhar.
// 'implements ActionListener' : Declara que esta classe se compromete a fornecer uma implementação
//                              para todos os métodos definidos na interface ActionListener.
//                              Neste caso, ela implementará o método 'actionPerformed'.
public class SubmarinoRadar extends JPanel implements ActionListener {
	
    private static final long serialVersionUID = 1L; // Identificador de versão para serialização
    // Usado em serialização de objetos Java para garantir compatibilidade de classes.

    // --- Configurações Básicas ---
    private double anguloAtual = 0; // Onde o feixe do radar está apontando (em radianos).
                                    // Variável que controla a rotação do feixe do radar.
    private Timer timerDeAnimacao;  // O "relógio" que faz o feixe girar.
                                    // Um objeto Timer do Swing que dispara eventos periodicamente.

    // --- Construtor (Isso é o que inicia o radar quando você cria um) ---
    public <timerDeAnimacao> SubmarinoRadar() {
        setBackground(Color.BLACK); // Define a cor de fundo deste JPanel como preto.
                                    // Isso cria o fundo escuro típico de um radar.
        timerDeAnimacao = new Timer(50, this); // Cria um Timer que dispara a cada 50 milissegundos
                                              // e notifica esta classe (que é um ActionListener)
                                              // cada vez que o tempo expira.
        timerDeAnimacao.start(); // Inicia o Timer para começar a animação do radar.
    }

    // --- Como Desenhar o Radar na Tela ---
    // Este método é chamado automaticamente pelo Swing sempre que o componente precisa ser redesenhado.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Garante que o painel seja pintado corretamente (limpa o fundo).
                                 // Chamada obrigatória para que o JPanel seja desenhado corretamente.
        Graphics2D g2d = (Graphics2D) g; // Converte o objeto Graphics para Graphics2D para usar
                                         // recursos gráficos mais avançados, como espessura de linha.

        int largura = getWidth();  // Obtém a largura atual do painel.
        int altura = getHeight(); // Obtém a altura atual do painel.
        int raio = Math.min(largura, altura) / 2 - 20; // Calcula o raio máximo para o radar,
                                                      // garantindo que ele caiba no painel com uma margem.
        int centroX = largura / 2; // Calcula a coordenada X do centro do painel.
        int centroY = altura / 2;  // Calcula a coordenada Y do centro do painel.

        g2d.setColor(Color.GREEN); // Define a cor de desenho para verde, a cor clássica de radar.
        g2d.setStroke(new BasicStroke(2)); // Define a espessura da linha para 2 pixels para círculos e linhas.

        // Desenha os círculos (anéis) concêntricos do radar
        for (int i = 0; i < 4; i++) {
            int raioDoAnel = raio - (i * raio / 4); // Calcula o raio de cada anel (4 anéis no total).
            // Desenha um oval (que é um círculo quando largura = altura)
            g2d.drawOval(centroX - raioDoAnel, centroY - raioDoAnel, 2 * raioDoAnel, 2 * raioDoAnel);
        }

        // Desenha as linhas que dividem o radar (a cada 45 graus, como um relógio)
        for (int i = 0; i < 360; i += 45) {
            double rad = Math.toRadians(i); // Converte o ângulo de graus para radianos, necessário para funções trigonométricas.
            int x = centroX + (int) (raio * Math.cos(rad)); // Calcula a coordenada X do ponto final da linha na borda do radar.
            int y = centroY + (int) (raio * Math.sin(rad)); // Calcula a coordenada Y do ponto final da linha na borda do radar.
            g2d.drawLine(centroX, centroY, x, y); // Desenha a linha do centro até a borda do radar.
        }

        // Desenha o feixe verde que gira, simulando o "sweep" do radar
        g2d.setColor(new Color(0, 255, 0, 100)); // Define a cor para um verde semi-transparente (RGBA: Red, Green, Blue, Alpha).
                                                // O valor 100 para Alpha (0-255) torna o feixe um pouco transparente.
        // Calcula a coordenada X do ponto final do feixe (com base no anguloAtual).
        int feixeX = centroX + (int) (raio * Math.cos(anguloAtual));
        // Calcula a coordenada Y do ponto final do feixe (com base no anguloAtual).
        int feixeY = centroY + (int) (raio * Math.sin(anguloAtual));
        g2d.drawLine(centroX, centroY, feixeX, feixeY); // Desenha o feixe do centro até a borda do radar.
    }

    // --- O Que Acontece a Cada "Tick" do Relógio (Timer) ---
    // Este método é chamado automaticamente pelo objeto Timer a cada intervalo definido (50ms).
    @Override // Indica que este método está sobrescrevendo um método da interface ActionListener.
    public void actionPerformed(ActionEvent e) {
        anguloAtual += Math.toRadians(2); // Incrementa o ângulo atual em 2 graus (convertidos para radianos).
                                        // Isso faz o feixe girar.
        if (anguloAtual >= 2 * Math.PI) { // Verifica se o ângulo excedeu uma volta completa (2 * PI radianos, aprox. 360 graus).
            anguloAtual -= 2 * Math.PI; // Se sim, subtrai 2 * PI para manter o ângulo dentro de 0 e 2 * PI, evitando que cresça indefinidamente.
        }
        repaint(); // Solicita que o Swing redesenhe este JPanel.
                   // Isso é crucial para que as mudanças no 'anguloAtual' sejam refletidas visualmente.
    }

    // --- Como Iniciar o Programa ---
    // Este é o ponto de entrada da aplicação Java.
    public static void main(String[] args) {
        // Isso é essencial para o Swing: garante que a criação e atualização da GUI
        // ocorram na Event Dispatch Thread (EDT) para segurança e estabilidade.
        SwingUtilities.invokeLater(() -> {
            JFrame janela = new JFrame("Radar do Submarino"); // Cria a janela principal da aplicação Swing, com um título.
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação padrão ao fechar a janela (encerra o programa).
            janela.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela para preencher a tela inteira.
            janela.setUndecorated(true); // Remove a barra de título e as bordas da janela para um visual mais imersivo.

            janela.add(new SubmarinoRadar()); // Adiciona uma nova instância do seu painel de radar (SubmarinoRadar) à janela.
                                            // Este painel será o conteúdo principal da janela.

            janela.setVisible(true); // Torna a janela visível na tela, exibindo o radar.
        });
    }
}
