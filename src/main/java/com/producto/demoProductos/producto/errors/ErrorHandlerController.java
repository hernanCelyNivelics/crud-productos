package com.producto.demoProductos.producto.errors;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice
public class ErrorHandlerController {

	public static final String MENSAJE_SALIDA_MAP = "mensaje";

	@ExceptionHandler(value = {NegocioException.class})
	protected ResponseEntity<Map<String, Object>> negocioException(NegocioException ex, Model model) {
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put(MENSAJE_SALIDA_MAP, "El usuario ya existe");
		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}
}