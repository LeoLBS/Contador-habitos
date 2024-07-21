package contador.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaTimer {
    JLabel contadorTempo;
    Cronometro cronometro;

    private boolean rodando = false;

    public void iniciarTela(){
        JFrame janela = new JFrame("Cronometro");

        janela.setSize(500,400);
        janela.setAlwaysOnTop(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());

        contadorTempo = new JLabel("00:00:00");
        contadorTempo.setFont(new Font(contadorTempo.getName(),Font.PLAIN, 80));
        janela.add(contadorTempo, BorderLayout.CENTER);

        JPanel painel  = new JPanel();
        painel.setLayout((new GridLayout(2,1)));

        JButton botaoIniciar = new JButton("Iniciar");
        botaoIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometro = new Cronometro();
                if(!rodando) {
                    cronometro.iniciarCronometro();
                    contadorTempo.setText(String.format("%02d:%02d:%02d",cronometro.getHora(),cronometro.getMinutos(),cronometro.getSegundos()));
                }
            }
        });

        JButton botaoParar = new JButton("Parar");
        botaoParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometro = new Cronometro();
                if (rodando){
                    cronometro.finalizarCronometro();
                }
            }
        });

        painel.add(botaoIniciar);
        painel.add(botaoParar);

        janela.add(painel);
        janela.pack();
    }
}
