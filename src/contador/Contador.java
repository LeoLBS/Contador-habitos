package contador;

import contador.timer.TelaTimer;

import java.awt.*;

public class Contador {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaTimer tela = new TelaTimer();
                tela.iniciarTela();
            }
        });

    }
}
