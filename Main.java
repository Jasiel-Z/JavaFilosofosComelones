public class Main {
    
    public static void main(String[] args){


        Object[] tenedores = new Object[5];
        for (int i = 0; i < tenedores.length; i++) {
            tenedores[i] = new Object();
        }

        Filosofo[] comelones = new Filosofo[5];
        for (int i = 0; i < comelones.length; i++) {
            
            comelones[i] = new Filosofo(i, tenedores[i], tenedores[(i + 1) % 5]);
        }

        for (Filosofo comelon : comelones) {
            comelon.start();
        }
    }
}
