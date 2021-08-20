package com.producto.demoProductos.producto.service;


import java.io.*;
import java.util.List;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.producto.demoProductos.producto.dto.ProductoDto;
import com.producto.demoProductos.producto.errors.CreadoException;
import com.producto.demoProductos.producto.errors.ProductoException;
import com.producto.demoProductos.producto.model.Producto;
import com.producto.demoProductos.producto.repo.ProductoRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public Producto add(ProductoDto producto) throws ProductoException {

        Producto product = new Producto();

        product.setNombre(producto.getNombre());
        product.setPrecio(Float.parseFloat(producto.getPrecio()));

        if (productoRepository.findByNombreIgnoreCase(product.getNombre()).isPresent()) {

            throw ProductoException.builder().build();
        } else {
            return productoRepository.save(product);
        }
    }

    public static void echoAsCSV(Sheet sheet) {
        Row row ;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print("\"" + row.getCell(j) + "\";");
            }
            System.out.println();
        }
    }

    public Object importProductos(MultipartFile productos) {

        InputStream inputStream = null;
        try {
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
        return productoRepository.findById(id);
    }

    public Producto update(int id, ProductoDto productodto) {
        Producto product = new Producto();
        product.setNombre(productodto.getNombre());
        product.setPrecio(Float.parseFloat(productodto.getPrecio()));
        return productoRepository.save(product);
    }

    public void delete(int id) {
        productoRepository.deleteById(id);
    }

}
