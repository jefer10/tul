package com.tul.market.domain.service;

import com.tul.market.persistence.ProductoRepository;
import com.tul.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public List<Producto> getAll() {
        return (List<Producto>) productoRepository.getAll();
    }


    public Optional<Producto> getProducto(int productoId) {
        return productoRepository.getProducto(productoId);
    }


    public Producto save(Producto producto) {
        if(producto.getDescuento()){
            producto.setPrecioVenta((producto.getPrecioVenta())/2);
        }
        return productoRepository.save(producto);
    }


    public void delete(int productId) {
        productoRepository.delete(productId);
    }
}
