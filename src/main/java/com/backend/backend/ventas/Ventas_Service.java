package com.backend.backend.ventas;


import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.backend.Cliente.Cliente;
import com.backend.backend.Cliente.Cliente__Repository;
import com.backend.backend.Color.Color;
import com.backend.backend.Color.Color_Repository;
import com.backend.backend.Producto.Producto;
import com.backend.backend.Producto.Producto_Repository;
import com.backend.backend.Producto_Tamaño.Product_Tamaño;
import com.backend.backend.Producto_Tamaño.Product_Tamaño_Repository;
import com.backend.backend.Tamaño.Tamaño;
import com.backend.backend.Tamaño.Tamaño_Repository;
import com.backend.backend.detalleventas.DetalleVenta;
import com.backend.backend.detalleventas.DTO.DetalleVenta_DTO;
import com.backend.backend.ventas.Dto.Ventas_DTO;

@Service
public class Ventas_Service {
    
    private final Ventas_Repository ventas_Repository;
    private final Cliente__Repository cliente_Repository;
    private final Producto_Repository producto_Repository;
    private final Tamaño_Repository tamaño_Repository;
    private final Color_Repository color_Repository;
    private final Product_Tamaño_Repository product_Tamaño_Repository;

    public Ventas_Service(Ventas_Repository ventas_Repositoryy, Cliente__Repository cliente_Repositoryy,
                          Producto_Repository producto_Repositoryy, Tamaño_Repository tamaño_Repositoryy,
                          Color_Repository color_Repositoryy, Product_Tamaño_Repository product_Tamaño_Repositoryy) {
        this.ventas_Repository = ventas_Repositoryy;
        this.cliente_Repository = cliente_Repositoryy;
        this.producto_Repository = producto_Repositoryy;
        this.tamaño_Repository = tamaño_Repositoryy;
        this.color_Repository = color_Repositoryy;
        this.product_Tamaño_Repository = product_Tamaño_Repositoryy;
    }


    public Ventas createVenta(Ventas_DTO ventas_DTO) {
        // Obtener el cliente
        Cliente cliente = cliente_Repository.findById(ventas_DTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        // Crear la venta
        Ventas venta = Ventas.builder()
                .cliente(cliente)
                .fechaRegistro(ventas_DTO.getFechaRegistro())
                .montoTotal(ventas_DTO.getMontoTotal())
                .estado(1) // Estado inicial de la venta (puedes cambiarlo según la lógica)
                .build();

        // Guardar la venta
        venta = ventas_Repository.save(venta);

        // Crear los detalles de venta
        for (DetalleVenta_DTO detalleDTO : ventas_DTO.getDetalles()) {
            Producto producto = producto_Repository.findById(detalleDTO.getIdProducto())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

            Tamaño tamaño = tamaño_Repository.findById(detalleDTO.getIdTamaño())
                    .orElseThrow(() -> new IllegalArgumentException("Tamaño no encontrado"));

            Color color = color_Repository.findById(detalleDTO.getIdColor())
                    .orElseThrow(() -> new IllegalArgumentException("Color no encontrado"));

            DetalleVenta detalleVenta = DetalleVenta.builder()
                    .ventas(venta)
                    .producto(producto)
                    .tamaño(tamaño)
                    .color(color)
                    .cantidad(detalleDTO.getCantidad())
                    .precio(detalleDTO.getPrecio())
                    .build();

            // Agregar el detalle a la lista y a la venta
            venta.add(detalleVenta);
        }

        // Guardar los detalles en la venta
        Ventas savedventa = ventas_Repository.save(venta);

        // Actualizar la cantidad en el inventario para cada producto
        for (DetalleVenta detalle : savedventa.getDetalles()) {
            Product_Tamaño productoTamaño = product_Tamaño_Repository.findByProductoAndTamañoAndColor(
                    detalle.getProducto(),
                    detalle.getTamaño(),
                    detalle.getColor())
                    .orElseThrow(() -> new IllegalArgumentException("Registro de inventario no encontrado"));

            // Aquí se asume que se está restando la cantidad vendida del inventario
            productoTamaño.setCantidad(productoTamaño.getCantidad() - detalle.getCantidad());
            product_Tamaño_Repository.save(productoTamaño);
        }

        return savedventa;
    }


    public List<Ventas> getAllventas(){
        List<Ventas> ventas=ventas_Repository.findAll();
        return ventas;
    }
}
