package com.backend.backend.Producto;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.backend.backend.Categoria.Categoria;
import com.backend.backend.Categoria.Categoria_Repository;
import com.backend.backend.Color.Color;
import com.backend.backend.Color.Color_Repository;
import com.backend.backend.Producto.DTO.Producto_DTO;
import com.backend.backend.Producto_Tamaño.Product_Tamaño;
import com.backend.backend.Producto_Tamaño.DTO.Product_Tamaño_DTO;
import com.backend.backend.Sucursal.Sucursal;
import com.backend.backend.Sucursal.Sucursal_Repository;
import com.backend.backend.Tamaño.Tamaño;
import com.backend.backend.Tamaño.Tamaño_Repository;
import com.backend.backend.producto_imagen.Producto_img;
import com.backend.backend.producto_imagen.Producto_img_Repository;

import lombok.RequiredArgsConstructor;


@Service
//@RequiredArgsConstructor
public class Producto_Service {
    
    private final Producto_Repository producto_Repository;
    private final Categoria_Repository categoria_Repository;
    private final Tamaño_Repository tamaño_Repository;
    private final Color_Repository color_Repository;
    private final Sucursal_Repository sucursal_Repository;
    private final Producto_img_Repository producto_img_Repository;

    public Producto_Service(Producto_Repository producto_Repositoryy, Tamaño_Repository tamaño_Repositoryy, Color_Repository color_Repositoryy, Categoria_Repository categoria_Repositoryy, Sucursal_Repository sucursal_Repositoryy, Producto_img_Repository producto_img_Repositoryy){
    this.producto_Repository=producto_Repositoryy;
    this.tamaño_Repository=tamaño_Repositoryy;
    this.color_Repository=color_Repositoryy;
    this.categoria_Repository=categoria_Repositoryy;
    this.sucursal_Repository=sucursal_Repositoryy;
    this.producto_img_Repository=producto_img_Repositoryy;

    }


    public Producto createProducto(Producto_DTO producto_DTO){
        System.out.println(producto_DTO);
        Categoria categoria = categoria_Repository.findById(producto_DTO.getIdCategoria())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
        Producto producto= Producto.builder()
                .nombre(producto_DTO.getNombre())
                .descripcion(producto_DTO.getDescripcion())
                .estado(1)
                .subcategoria(producto_DTO.getSubcategoria())
                .categoria(categoria)
                .build();
        producto= producto_Repository.save(producto);

        for (Product_Tamaño_DTO product_Tamaño_DTO : producto_DTO.getProduct_Tamaños()) {

            Tamaño tamaño = tamaño_Repository.findById(product_Tamaño_DTO.getTamañoId())
                    .orElseThrow(() -> new IllegalArgumentException("Tamaño no encontrado"));
            
            Color color = color_Repository.findById(product_Tamaño_DTO.getColorId())
            .orElseThrow(() -> new IllegalArgumentException("Tamaño no encontrado")); 

            
            Product_Tamaño product_Tamaño= Product_Tamaño.builder()
                    .producto(producto)
                    .tamaño(tamaño)
                    .color(color)
                    
                    .cantidad(product_Tamaño_DTO.getCantidad())
                    .precio(product_Tamaño_DTO.getPrecio())
                    .build();
            
            producto.addDetalle(product_Tamaño);
        }

        producto= producto_Repository.save(producto);
        if (producto_DTO.getImagenUrl() != null && !producto_DTO.getImagenUrl().isEmpty()) {
            for (String url : producto_DTO.getImagenUrl()) {
                Producto_img productoImg = Producto_img.builder()
                        .img_url(url)
                        .idProducto(producto)
                        .build();
                producto_img_Repository.save(productoImg);
            }
        }

        return producto;
    }



    // public Producto updateProducto(Integer id, Producto_DTO producto_DTO) {
    //     // Buscar el producto existente por ID
    //     Producto producto = producto_Repository.findById(id)
    //             .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con el id: " + id));
    
    //     // Actualizar los campos del producto
    //     producto.setNombre(producto_DTO.getNombre());
    //     producto.setDescripcion(producto_DTO.getDescripcion());
    //     producto.setSubcategoria(producto_DTO.getSubcategoria());
    
    //     // Actualizar la categoría si es necesario
    //     Categoria categoria = categoria_Repository.findById(producto_DTO.getIdCategoria())
    //             .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
    //     producto.setCategoria(categoria);
    
    //     // Limpiar la lista de detalles antes de agregar los nuevos detalles
    //     producto.getProductos().clear();
    
    //     // Volver a agregar los detalles de Product_Tamaño
    //     for (Product_Tamaño_DTO product_Tamaño_DTO : producto_DTO.getProduct_Tamaños()) {
    
    //         Tamaño tamaño = tamaño_Repository.findById(product_Tamaño_DTO.getTamañoId())
    //                 .orElseThrow(() -> new IllegalArgumentException("Tamaño no encontrado"));
    
    //         Color color = color_Repository.findById(product_Tamaño_DTO.getColorId())
    //                 .orElseThrow(() -> new IllegalArgumentException("Color no encontrado"));
    
    //         Sucursal sucursal = sucursal_Repository.findById(product_Tamaño_DTO.getSucursalId())
    //                 .orElseThrow(() -> new IllegalArgumentException("Sucursal no encontrada"));
    
    //         Product_Tamaño product_Tamaño = Product_Tamaño.builder()
    //                 .producto(producto)
    //                 .tamaño(tamaño)
    //                 .color(color)
    //                 .sucursal(sucursal)
    //                 .cantidad(product_Tamaño_DTO.getCantidad())
    //                 .precio(product_Tamaño_DTO.getPrecio())
    //                 .build();
    
    //         producto.addDetalle(product_Tamaño);
    //     }
    
    //     // Guardar el producto actualizado
    //     return producto_Repository.save(producto);
    // }

    public Producto updateProducto(Integer id, Producto_DTO producto_DTO) {
    // Obtener el producto existente
    Producto productoExistente = producto_Repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));

    // Actualizar los campos básicos del producto
    Categoria categoria = categoria_Repository.findById(producto_DTO.getIdCategoria())
        .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
    
    productoExistente.setNombre(producto_DTO.getNombre());
    productoExistente.setDescripcion(producto_DTO.getDescripcion());
    productoExistente.setSubcategoria(producto_DTO.getSubcategoria());
    productoExistente.setCategoria(categoria);

    // Obtener la lista actual de Product_Tamaño asociados al producto
    List<Product_Tamaño> detallesActuales = productoExistente.getProductos();

    // Crear una lista de los IDs de Tamaño y Sucursal enviados en la nueva solicitud
    Set<String> nuevosDetallesKeys = producto_DTO.getProduct_Tamaños().stream()
        .map(detalle -> detalle.getTamañoId() + "-" + detalle.getColorId())
        .collect(Collectors.toSet());

    // Eliminar los detalles (Product_Tamaño) que no están en la nueva lista
    detallesActuales.removeIf(detalle -> {
        String detalleKey = detalle.getTamaño().getId() + "-" + detalle.getColor().getId();
        return !nuevosDetallesKeys.contains(detalleKey);
    });

    // Añadir o actualizar los detalles nuevos
    for (Product_Tamaño_DTO product_Tamaño_DTO : producto_DTO.getProduct_Tamaños()) {
        Tamaño tamaño = tamaño_Repository.findById(product_Tamaño_DTO.getTamañoId())
            .orElseThrow(() -> new IllegalArgumentException("Tamaño no encontrado"));

        Color color = color_Repository.findById(product_Tamaño_DTO.getColorId())
            .orElseThrow(() -> new IllegalArgumentException("Color no encontrado"));

        // Sucursal sucursal = sucursal_Repository.findById(product_Tamaño_DTO.getSucursalId())
        //     .orElseThrow(() -> new IllegalArgumentException("Sucursal no encontrada"));

        // Verificar si ya existe una relación con ese Tamaño, Color y Sucursal
        Optional<Product_Tamaño> detalleExistente = detallesActuales.stream()
            .filter(detalle -> detalle.getTamaño().equals(tamaño) && detalle.getColor().equals(color))
            .findFirst();

        if (detalleExistente.isPresent()) {
            // Si existe, actualizamos los campos necesarios
            detalleExistente.get().setCantidad(product_Tamaño_DTO.getCantidad());
            detalleExistente.get().setPrecio(product_Tamaño_DTO.getPrecio());
        } else {
            // Si no existe, creamos un nuevo detalle
            Product_Tamaño nuevoDetalle = Product_Tamaño.builder()
                .producto(productoExistente)
                .tamaño(tamaño)
                .color(color)
                //.sucursal(sucursal)
                .cantidad(product_Tamaño_DTO.getCantidad())
                .precio(product_Tamaño_DTO.getPrecio())
                .build();
            productoExistente.addDetalle(nuevoDetalle);
        }
    }

    // Guardar el producto actualizado con los nuevos detalles
    return producto_Repository.save(productoExistente);
}




    public List<Producto> getAllProductos(){
        return producto_Repository.findAll();
    } 

    public Producto getProductoById(Integer id) {
        return producto_Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));
    }

     public Producto getProductoImg(Integer id){
         Optional<Producto> producto = producto_Repository.findById(id);
         return producto.get();
     }
}
