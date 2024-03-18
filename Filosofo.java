


public class Filosofo extends Thread{
    private int id;
    private Object tenedorIzquierdo;
    private Object tenedorDerecho;
    

    public Filosofo(int id, Object tenedorIzquierdo, Object tenedorDerecho){
        this.id = id;
        this.tenedorDerecho = tenedorDerecho;
        this.tenedorIzquierdo = tenedorIzquierdo;
    }


    public void run(){
        while(true){
            
                pensar();
                tomarTenedor();
                comer();
                soltarTenedores();
            
        }
    }

    public void pensar(){
        try{
            System.out.println("El filósofo " + id + " está pensando");
            Thread.sleep((long) (Math.random() * 1000));
        }catch(InterruptedException exception){
            System.err.println(exception.getMessage());
        }
    }

    public void comer(){
        try{
            System.out.println("El filósofo número " + id + " está comiendo");
            Thread.sleep((long) (Math.random() * 1000));        
        }catch(InterruptedException exception){
            System.err.println(exception.getMessage());
        }

    }

    public void tomarTenedor(){
        try {
            if (id != 5) {
                synchronized (tenedorIzquierdo) {
                    System.out.println("El filósofo "+ id + " ha tomado su tenedor izquierdo");
                    synchronized (tenedorDerecho) {
                        System.out.println("El filósofo "+ id + " ha tomado su tenedor derecho");
                    }
                }
            } else {
                synchronized (tenedorDerecho) {
                    System.out.println("El filósofo "+ id + " ha tomado su tenedor derecho");

                    synchronized (tenedorIzquierdo) {
                        System.out.println("El filósofo "+ id + " ha tomado su tenedor izquierdo");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    private void soltarTenedores(){
        synchronized (tenedorIzquierdo) {
            synchronized (tenedorDerecho) {
                System.err.println("El filosofo "+ id +" ha dejado de comer");
            }
        }
    }


}