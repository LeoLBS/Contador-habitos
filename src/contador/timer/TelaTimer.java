package contador.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import contador.dados.Salvar;

public class TelaTimer {
    JLabel contadorTempo;
    Cronometro cronometro;
    Salvar salvar;

    private boolean rodando = false;
    private Timer timerPainel;

    public void iniciarTela(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame janela = new JFrame("Cronometro");

        janela.setSize(300,200);
        janela.setAlwaysOnTop(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());

        contadorTempo = new JLabel("00:00:00");
        contadorTempo.setFont(new Font(contadorTempo.getName(),Font.PLAIN, 90));
        janela.add(contadorTempo, BorderLayout.CENTER);

        JPanel painel  = new JPanel();
        painel.setLayout(new GridLayout(5,4));

        JButton botaoIniciar = new JButton("Iniciar");
        botaoIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!rodando) {
                    cronometro = new Cronometro();
                    rodando = true;
                    cronometro.iniciarCronometro(rodando);
                    iniciarPainelNumerico();
                }
            }
        });

        JButton botaoParar = new JButton("Parar");
        botaoParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rodando){
                    cronometro.finalizarCronometro(rodando);
                    rodando = false;
                    pararPainelNumerico();
                }
            }
        });

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar = new Salvar();

                String dadosContador = String.format("%02d:%02d:%02d", cronometro.getHora(), cronometro.getMinutos(), cronometro.getSegundos());
                salvar.salvarContadores(dadosContador,"C:\\PROJETOS\\java-contador\\Contador-habitos\\src\\salvos\\Novo_arqui.txt");
            }
        });

        painel.add(botaoIniciar);
        painel.add(botaoParar);
        painel.add(botaoSalvar);

        janela.add(painel, BorderLayout.EAST);
        janela.pack();
        janela.setVisible(true);
    }

    private void iniciarPainelNumerico() {
        timerPainel = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorTempo.setText(String.format("%02d:%02d:%02d", cronometro.getHora(), cronometro.getMinutos(), cronometro.getSegundos()));
            }
        });
        timerPainel .start();
    }

    private void pararPainelNumerico() {
        if (timerPainel  != null) {
            timerPainel .stop();
        }
    }

}
