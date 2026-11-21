package modelo;

public class RecursoPedido implements AutoCloseable {

    public RecursoPedido() {
        System.out.println("Se inicia el procesamiento del pedido.");
    }

    public void procesar() {
        System.out.println("Procesando pedido...");
    }

    @Override
    public void close() {
        System.out.println("Se cierra el recurso del pedido.");
    }
}
