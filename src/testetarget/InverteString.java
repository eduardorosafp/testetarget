package testetarget;

public class InverteString {
    public static void main(String[] args) {
        String original = "exemplo";
        String invertida = "";
        
        // Faz um loop pela string original de trás para frente
        for (int i = original.length() - 1; i >= 0; i--) {
            // Adiciona cada caractere ao início da string invertida
            invertida += original.charAt(i);
        }
        
        System.out.println("String original: " + original);
        System.out.println("String invertida: " + invertida);
    }
}
