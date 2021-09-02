package com.hcely.crudproductos.producto.service.impl;

import com.hcely.crudproductos.exception.NoDataFoundException;
import com.hcely.crudproductos.exception.ProductoExistException;
import com.hcely.crudproductos.exception.UsuarioExistException;
import com.hcely.crudproductos.producto.component.ProductoMapper;
import com.hcely.crudproductos.producto.dto.ProductoDto;
import com.hcely.crudproductos.producto.model.Producto;
import com.hcely.crudproductos.producto.repo.ProductoRepository;
import com.hcely.crudproductos.producto.service.ProductoService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    private static final String CAD1 = "El producto ";
    private static final String CAD2 = " no se encontro";

    @Override
    public ProductoDto add(ProductoDto productoDto) {
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        if (productoRepository.findByNombre(producto.getNombre()) != null) {
            throw new UsuarioExistException(CAD1 + producto.getNombre() + " ya existe.");
        }
        return ProductoMapper.mapper.modelToDto(productoRepository.save(producto));
    }

    @Override
    public ProductoDto getByNombre(ProductoDto productoDto) {
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        var productoBuscado = productoRepository.findByNombre(producto.getNombre());
        if (productoBuscado == null) {
            throw new NoDataFoundException(CAD1 + productoDto.getNombreProducto() + CAD2);
        }
        return ProductoMapper.mapper.modelToDto(productoRepository.findByNombre(producto.getNombre()));
    }

    @Override
    public List<ProductoDto> getAll() {
        var usuarios = productoRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new NoDataFoundException("No se encontraron productos");
        }
        return ProductoMapper.mapper.listModeltoDto(usuarios);
    }

    @Override
    public ProductoDto getById(ProductoDto productoDto) {
        var producto = productoRepository.getById(productoDto.getId());
        if (producto == null) {
            throw new NoDataFoundException(CAD1 + productoDto.getNombreProducto() + CAD2);
        }
        return ProductoMapper.mapper.modelToDto(producto);
    }

    @Override
    public ProductoDto update(int id, ProductoDto productoDto) {

        if (!productoRepository.findById(productoDto.getId()).isPresent()) {
            throw new NoDataFoundException(CAD1 + productoDto.getNombreProducto() + CAD2);
        }
        var producto = ProductoMapper.mapper.dtoToModel(productoDto);
        return ProductoMapper.mapper.modelToDto(productoRepository.save(producto));
    }

    @Override
    public void delete(int id) {
        var producto = productoRepository.getById(id);
        Logger.getLogger(producto.getId() + producto.getNombre());
        if (producto == null) {
            throw new NoDataFoundException("El usuario con ID: " + id + CAD2);
        }
        productoRepository.deleteById(id);

    }

    public void saveAllTransactional(List<Producto> productos) {
        for (Producto producto:productos
             ) {
            if (productoRepository.findByNombre(producto.getNombre())!=null){
                throw new ProductoExistException("No se pudieron agregar los productos, ya hay productos creados.");
            }else{
                productoRepository.saveAll(productos);
            }
        }
    }

    @Transactional
    public Object importProductos(MultipartFile productos) {

        List<Object> failed = new ArrayList();
        List<Producto> listProductos = new ArrayList();
        InputStream inputStream = null;
        try {
            inputStream = productos.getInputStream();
            final Reader reader = new InputStreamReader(inputStream, "UTF-8");
            final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.builder().setHeader("nombre", "precio")
                    .setSkipHeaderRecord(true).build());
            try {
                ProductoDto productoDto = new ProductoDto();
                for (final CSVRecord record : parser) {
                    if (record.get("nombre").isEmpty() || record.get("precio").isEmpty()) {
                        var cadena = "Error: " + "{nombre: " + record.get("nombre") + " precio: "
                                + record.get("precio") + " fila: " + record.getRecordNumber() + "}";
                        failed.add(cadena);
                    }else{
                        productoDto.setPrecioProducto(BigDecimal.valueOf(Double.parseDouble(record.get("precio"))));
                        productoDto.setNombreProducto(record.get("nombre"));
                        listProductos.add(ProductoMapper.mapper.dtoToModel(productoDto));
                    }
                }
                saveAllTransactional(listProductos);
                System.out.println(failed);
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
        return failed;
    }
}
