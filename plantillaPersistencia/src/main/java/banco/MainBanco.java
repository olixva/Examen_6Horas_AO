package banco;

import banco.activos.Prestamo;
import banco.enums.NotificacionesEnum;

public class MainBanco {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("Juan", "Avenida", "Casillas", 4,
                "1A", "611", NotificacionesEnum.SMS);

        Prestamo prestamo = new Prestamo("123");
        cliente.setPrestamo(prestamo);

        cliente.notificar();
    }

}
