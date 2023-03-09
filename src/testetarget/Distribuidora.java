package testetarget;

import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Distribuidora {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        List<Double> faturamentos = new ArrayList<>();

        try {
            // Lendo o arquivo JSON
            Object obj = parser.parse(new FileReader("faturamento.json"));
            JSONObject jsonObj = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObj.get("faturamento");

            // Armazenando os valores de faturamento em uma lista
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject dia = (JSONObject) jsonArray.get(i);
                Double faturamento = (Double) dia.get("valor");
                faturamentos.add(faturamento);
            }

            // Calculando o menor valor de faturamento
            Double menorFaturamento = faturamentos.get(0);
            for (Double faturamento : faturamentos) {
                if (faturamento < menorFaturamento) {
                    menorFaturamento = faturamento;
                }
            }
            System.out.println("Menor faturamento di�rio: " + menorFaturamento);

            // Calculando o maior valor de faturamento
            Double maiorFaturamento = faturamentos.get(0);
            for (Double faturamento : faturamentos) {
                if (faturamento > maiorFaturamento) {
                    maiorFaturamento = faturamento;
                }
            }
            System.out.println("Maior faturamento di�rio: " + maiorFaturamento);

            // Calculando a m�dia mensal de faturamento
            Double somaFaturamentos = 0.0;
            int numDias = 0;
            for (Double faturamento : faturamentos) {
                if (faturamento > 0) { // Ignorando dias sem faturamento
                    somaFaturamentos += faturamento;
                    numDias++;
                }
            }
            Double mediaMensal = somaFaturamentos / numDias;

            // Calculando o n�mero de dias com faturamento superior � m�dia mensal
            int numDiasAcimaMedia = 0;
            for (Double faturamento : faturamentos) {
                if (faturamento > mediaMensal) {
                    numDiasAcimaMedia++;
                }
            }
            System.out.println("N�mero de dias com faturamento acima da m�dia: " + numDiasAcimaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}