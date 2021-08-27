package com.producto.demoProductos.producto.domain.service;


import com.producto.demoProductos.producto.domain.dto.ProductoDto;
import com.producto.demoProductos.producto.errors.*;

import java.io.*;
import java.util.List;

import com.producto.demoProductos.producto.message.ApiError;
import com.producto.demoProductos.producto.persistence.model.Producto;
import com.producto.demoProductos.producto.persistence.model.repositorio.ProductoRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public static String TYPE = "text/csv";

    public Producto add(ProductoDto producto) throws FoundException, HttpMessageNotReadableException {
        Producto product = new Producto();
        product.setNombre(producto.getNombre());
        product.setPrecio(producto.getPrecio());
        if (productoRepository.findByNombreIgnoreCase(producto.getNombre()).isPresent()) {
            throw FoundException.builder()
                    .status(HttpStatus.FOUND)
                    .message("El producto " + producto.getNombre() + " ya esiste")
                    .errors("El producto ya existe").build();

        } else {
            return productoRepository.save(product);


        }


    }

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public Object importProductos(MultipartFile productos) {

        InputStream inputStream = null;
        try {
            if (hasCSVFormat(productos)) {
                inputStream = productos.getInputStream();

                final Reader reader = new InputStreamReader(inputStream, "UTF-8");
                final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
                try {
                    for (final CSVRecord record : parser) {
                        final String string = record.get("nombre");

                        System.out.println(string);
                    }
                } finally {
                    parser.close();
                    reader.close();
                }
            }
        } catch (IOException e) {
            return e.getMessage();
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                return ex.getMessage();
            }
        }
        return null;
    }

    public List<Producto> getAll() {

        return productoRepository.findAll();
    }

    public List<Producto> getProducto(int id) {


        if (productoRepository.findById(id) == null) {
            //excepciones a nivel generico
            throw NotFoundException.builder().message("No existe el producto con ID: " + id).build();
        } else {
            return productoRepository.findById(id);
        }
    }

    public Producto update(int id, ProductoDto productodto) throws NotFoundException {
        Producto product = new Producto();
        if (productoRepository.findById(id) == null) {
            throw NotFoundException.builder().message("No existe el producto con ID: " + id).build();
        } else {
            product.setId(id);
            product.setNombre(productodto.getNombre());
            product.setPrecio(productodto.getPrecio());
            return productoRepository.save(product);
        }

    }

    public void delete(int id) throws NotFoundException {

        if (productoRepository.findById(id) == null) {
            throw NotFoundException.builder().message("No existe el producto con ID: " + id).build();
        } else {
            productoRepository.deleteById(id);

        }
    }


}
