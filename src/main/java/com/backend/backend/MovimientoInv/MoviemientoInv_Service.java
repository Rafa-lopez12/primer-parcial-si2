package com.backend.backend.MovimientoInv;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Service;


import com.backend.backend.Color.Color;
import com.backend.backend.Color.Color_Repository;
import com.backend.backend.DetalleMov.DetalleMov;
import com.backend.backend.DetalleMov.DTO.DetalleMov_DTO;
import com.backend.backend.MovimientoInv.DTO.MovimientoInv_DTO;
import com.backend.backend.Producto.Producto;
import com.backend.backend.Producto.Producto_Repository;
import com.backend.backend.Producto_Tamaño.Product_Tamaño;
import com.backend.backend.Producto_Tamaño.Product_Tamaño_Repository;
import com.backend.backend.Proveedor.Proveedor;
import com.backend.backend.Proveedor.Proveedor_Repository;
import com.backend.backend.Sucursal.Sucursal;
import com.backend.backend.Sucursal.Sucursal_Repository;
import com.backend.backend.Tamaño.Tamaño;
import com.backend.backend.Tamaño.Tamaño_Repository;
import com.backend.backend.Usuario.Usuario;
import com.backend.backend.Usuario.Usuario_Repository;

import lombok.RequiredArgsConstructor;


@Service
//@RequiredArgsConstructor
public class MoviemientoInv_Service {
    
    private final MovimientoInv_Repository movimientoInv_Repository;
    private final Usuario_Repository usuario_Repository;
    private final Proveedor_Repository proveedor_Repository;
    private final Producto_Repository producto_Repository;
    private final Tamaño_Repository tamaño_Repository;
    private final Sucursal_Repository sucursal_Repository;
    private final Product_Tamaño_Repository product_Tamaño_Repository;
    private final Color_Repository color_Repository;


    
    public MoviemientoInv_Service(MovimientoInv_Repository movimientoInv_Repositoryy, Usuario_Repository usuario_Repositoryy,
                                Proveedor_Repository proveedor_Repositoryy, Producto_Repository producto_Repositoryy, Tamaño_Repository tamaño_Repositoryy,
                                Sucursal_Repository sucursal_Repositoryy, Product_Tamaño_Repository product_Tamaño_Repositoryy, Color_Repository color_Repositoryy){
            this.movimientoInv_Repository=movimientoInv_Repositoryy;
            this.product_Tamaño_Repository=product_Tamaño_Repositoryy;
            this.producto_Repository=producto_Repositoryy;
            this.proveedor_Repository=proveedor_Repositoryy;
            this.sucursal_Repository=sucursal_Repositoryy;
            this.tamaño_Repository=tamaño_Repositoryy;
            this.usuario_Repository=usuario_Repositoryy;
            this.color_Repository=color_Repositoryy;
    }


    public MovimientoInv createMov(MovimientoInv_DTO movimientoInv_DTO){
        System.out.println(movimientoInv_DTO);
        
        Usuario usuario = usuario_Repository.findById(movimientoInv_DTO.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        
        Proveedor proveedor = proveedor_Repository.findById(movimientoInv_DTO.getIdProveedor())
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado"));
        
        Sucursal sucursal = sucursal_Repository.findById(movimientoInv_DTO.getIdSucursal())
                .orElseThrow(() -> new IllegalArgumentException("Sucursal no encontrado"));

                
        MovimientoInv movimientoInv= MovimientoInv.builder()
            .usuario(usuario)
            .proveedor(proveedor)
            .sucursal(sucursal)
            .fechaColumna(movimientoInv_DTO.getFechaColumna())
            .montoTotal(movimientoInv_DTO.getMontoTotal())
            .build();

        movimientoInv = movimientoInv_Repository.save(movimientoInv);   
        

        for (DetalleMov_DTO detalleDTO : movimientoInv_DTO.getDetalles()) {
            
           

            Producto producto = producto_Repository.findById(detalleDTO.getIdProducto())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

            Tamaño tamaño = tamaño_Repository.findById(detalleDTO.getIdTamaño())
                    .orElseThrow(() -> new IllegalArgumentException("Tamaño no encontrado"));
            
            Color color = color_Repository.findById(detalleDTO.getIdColor())
                    .orElseThrow(() -> new IllegalArgumentException("Color no encontrado"));

           

            DetalleMov detalleMov= DetalleMov.builder()
                .movimientoInv(movimientoInv)
                .producto(producto)
                .color(color)
                .tamaño(tamaño)
                .cantidad(detalleDTO.getCantidad())
                .precio(detalleDTO.getPrecio())
                .build();

            
            movimientoInv.addDetalle(detalleMov);
            
        }
        
 
        
        MovimientoInv savedMovimientoInv = movimientoInv_Repository.save(movimientoInv);
        for (DetalleMov detalle : savedMovimientoInv.getDetalles()) {
           
            Product_Tamaño productoTamaño = product_Tamaño_Repository.findByProductoAndTamañoAndColor(
                    detalle.getProducto(),
                    detalle.getTamaño(),
                    detalle.getColor())
                    //detalle.getSucursal())
                    .orElseThrow(() -> new IllegalArgumentException("Registro de inventario no encontrado"));

            //Aquí se asume que estás restando la cantidad del inventario. Ajusta según la lógica de negocio.
            productoTamaño.setCantidad(productoTamaño.getCantidad() + detalle.getCantidad());
            product_Tamaño_Repository.save(productoTamaño);
        }
        return savedMovimientoInv;

        //return movimientoInv_Repository.save(movimientoInv);
        
        
    }

    public List<MovimientoInv> getAllMovimientos(){

        return movimientoInv_Repository.findAll();

    }
}
