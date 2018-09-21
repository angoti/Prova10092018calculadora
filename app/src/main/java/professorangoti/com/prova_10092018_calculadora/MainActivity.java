package professorangoti.com.prova_10092018_calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    EditText visor;
    double operando1, operando2, resultado;
    boolean controle = false;
    String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = (EditText) findViewById(R.id.visor);
    }

    public void operacao(View botao) {
        switch (botao.getId()) {
            case R.id.b0:
            case R.id.b1:
            case R.id.b2:
            case R.id.b3:
            case R.id.b4:
            case R.id.b5:
            case R.id.b6:
            case R.id.b7:
            case R.id.b8:
            case R.id.b9:
                visor.setText(visor.getText().append(((Button) botao).getText()));
                break;
            case R.id.divisao:
            case R.id.multiplcação:
            case R.id.soma:
            case R.id.subtração:
                operando1 = Double.parseDouble((visor.getText().toString()));
                operador = ((Button) botao).getText().toString();
                visor.setText("");
                break;
            case R.id.bC:
                visor.setText("");
                break;
            case R.id.bM:
                if (controle)
                    visor.setText(operando1 + operador + operando2 + " = " + resultado);
                break;
            case R.id.igual:
                operando2 = Integer.parseInt((visor.getText().toString()));
                NumberFormat nf = NumberFormat.getNumberInstance();
                switch (operador) {
                    case "+":
                        visor.setText(nf.format(resultado = operando1 + operando2));
                        break;
                    case "-":
                        visor.setText(nf.format(resultado = operando1 - operando2));
                        break;
                    case "*":
                        visor.setText(nf.format(resultado = operando1 * operando2));
                        break;
                    case "/":
                        visor.setText(nf.format(resultado = operando1 / operando2));
                        break;
                }
                controle = true;
                break;
        }
    }

}
