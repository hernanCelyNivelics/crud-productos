package com.producto.demoProductos.producto.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerController {

	public static final String MENSAJE_SALIDA_MAP = "mensaje";

	@ExceptionHandler(value = {NegocioException.class})
	protected ResponseEntity<Map<String, Object>> negocioException(NegocioException ex, Model model) {
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put(MENSAJE_SALIDA_MAP, "El usuario ya existe");
		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {BadRequest.class})
	protected ResponseEntity<Map<String, Object>> badRequestException(BadRequest ex, Model model) {
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put(MENSAJE_SALIDA_MAP, "El producto ya existe");
		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = {NotFound.class})
	public ResponseEntity<?> notfound(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}