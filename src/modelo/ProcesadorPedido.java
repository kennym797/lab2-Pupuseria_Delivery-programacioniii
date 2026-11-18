package modelo;

    public class ProcesadorPedido implements Runnable {

        private Pedido pedido;

        public ProcesadorPedido(Pedido pedido) {
            this.pedido = pedido;
        }

        @Override
        public void run() {

            System.out.println("================================");
            System.out.println("PROCESANDO PEDIDO");
            System.out.println("Hilo: " + Thread.currentThread().getName());
            System.out.println("================================");

            System.out.println(pedido.generarTicket());

            System.out.println("Pedido procesado correctamente.");
        }
    }
