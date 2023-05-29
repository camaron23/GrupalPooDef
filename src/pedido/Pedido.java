package pedido;

import java.util.List;

public class Pedido {
    private
        int id;
        List<Venta> pedido;
        double precioTotal;

    public
        Pedido(int id, List<Venta> pedido, double precioTotal) {
            this.id = id;
            this.pedido = pedido;
            this.precioTotal = precioTotal;
        }

        Pedido() {
            this.id = 0;
            this.pedido = null;
            this.precioTotal = 0.0;
        }

        int getId() {
            return id;
        }

        List<Venta> getPedido() {
            return pedido;
        }

        double getPrecioTotal() {
            return precioTotal;
        }

        void setId(int id) {
            this.id = id;
        }

        void setPedido(List<Venta> pedido) {
            this.pedido = pedido;
        }

        void setPrecioTotal(double precioTotal) {
            this.precioTotal = precioTotal;
        }


}
