package com.producto.demoProductos.util;


import com.producto.demoProductos.producto.dto.ProductoDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ApacheCommonsCsvUtil {
    private static String csvExtension = "csv";


    public static List<ProductoDto> parseCsvFile(InputStream is) {
        BufferedReader fileReader = null;
        CSVParser csvParser = null;

        List<ProductoDto> productodto = new ArrayList<ProductoDto>();

        try {
            fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                ProductoDto productos = new ProductoDto();
                productos.setNombreProducto(csvRecord.get("nombre"));
                productos.setPrecioProducto(BigDecimal.valueOf(Long.parseLong(csvRecord.get("precio"))));
                productodto.add(productos);
            }

        } catch (Exception e) {
            System.getLogger("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvParser.close();
            } catch (IOException e) {
                System.getLogger("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }

        return productodto;
    }

    public static boolean isCSVFile(MultipartFile file) {
        String extension = file.getOriginalFilename().split("\\.")[1];

        if (!extension.equals(csvExtension)) {
            return false;
        }

        return true;
    }

}
