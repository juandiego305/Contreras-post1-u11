package com.universidad.refactoring.service;

import com.universidad.refactoring.domain.DatosCliente;
import com.universidad.refactoring.domain.Pedido;
import com.universidad.refactoring.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repo;
    private final NotificacionService notificacionService;

    // Corrección: Inyección por Constructor
    public PedidoService(PedidoRepository repo, NotificacionService notificacionService) {
        this.repo = repo;
        this.notificacionService = notificacionService;
    }

    // Método orquestador limpio (CC muy baja)
    public String procesarPedido(DatosCliente cliente, List<Double> precios, 
                                 List<Integer> cantidades, boolean esUrgente, String descuento) {
        double total = calcularTotal(precios, cantidades);
        double totalConDescuento = aplicarDescuento(total, descuento);
        
        notificacionService.notificarPedido(cliente, esUrgente);
        return persistirPedido(cliente, totalConDescuento);
    }

    private double calcularTotal(List<Double> precios, List<Integer> cantidades) {
        double total = 0;
        for (int i = 0; i < precios.size(); i++) {
            total += precios.get(i) * cantidades.get(i);
        }
        return total;
    }

    private double aplicarDescuento(double total, String codigoDescuento) {
        if ("VIP10".equals(codigoDescuento)) return total * 0.90;
        if ("NEW20".equals(codigoDescuento)) return total * 0.80;
        return total;
    }

    private String persistirPedido(DatosCliente cliente, double total) {
        Pedido pedido = new Pedido(cliente.getId(), cliente.getNombre(), total);
        return "OK_" + repo.save(pedido).getId();
    }
}