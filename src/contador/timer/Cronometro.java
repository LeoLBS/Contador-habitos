package contador.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
    Timer time = new Timer();

    private int contador = 0;
    private boolean executando = false;

    private int segundos;
    private int minutos;
    private int hora;

    public void iniciarCronometro(boolean executando) {
        this.executando = executando;
        if (this.executando) {
            time.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    contador++;
                    segundos = contador % 60;
                    minutos = contador / 60;
                    hora = minutos / 60;

                    minutos %= 60;
                }
            }, 1000, 1000);
        }
    }

    public int getSegundos() {
        return segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getHora() {
        return hora;
    }

    public void finalizarCronometro(boolean executando) {
        time.cancel();
        contador = 0;
        this.executando = executando;
    }
}
