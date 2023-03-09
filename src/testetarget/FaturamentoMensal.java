package testetarget;

public class FaturamentoMensal {
    public static void main(String[] args) {
        double total = 0;
        double[] valores = { 67836.43, 36678.66, 29229.88, 27165.48, 19849.53 };
        String[] estados = { "SP", "RJ", "MG", "ES", "Outros" };
        
        // Calcula o valor total do faturamento
        for (double valor : valores) {
            total += valor;
        }
        
        // Calcula e imprime o percentual de representação de cada estado
        for (int i = 0; i < valores.length; i++) {
            double percentual = (valores[i] / total) * 100;
            System.out.println(estados[i] + " - " + String.format("%.2f", percentual) + "%");
        }
    }
}