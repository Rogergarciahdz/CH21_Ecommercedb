package org.generation.ecommercedb;


import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.ecommercedb.model.Producto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;


@AutoConfigureMockMvc
@SpringBootTest
class EcommercedbApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("prueba del metodo PUT de productos ")
	@Disabled("se dehabilita temporalmente ")
	public void pruebaUpdate() throws Exception{
		this.mockMvc.perform(put("/api/productos/1").queryParam("pluma para escribir", "pluma para escribir.jpg")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("pluma para escribir.jpg")));
	}
	
	
	
	
	@Test
	@DisplayName("prueba del metodo DELETE de productos ")
	@Disabled("se dehabilita temporalmente parano borrar ")
	public void pruebaDELETE() throws Exception{
		this.mockMvc.perform(delete("/api/productos/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("pluma para escribir")));
	}
	
	
	
	@Test
	@DisplayName("prueba del metodo GET de productos ")
	public void pruebaGET() throws Exception{
		this.mockMvc.perform(get("/api/productos/1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("cuadernos/cuadernos pasta gruesa/cuaderno para escribir/50")));
	}


	@Test
	@DisplayName("prueba del metodo POST de productos ")
	
	public void pruebaPOST() throws Exception{

		Producto p = new Producto();
		p.setNombre("lapiz mirado/grafito");
		p.setDescripcion("lapiz clasico");
		p.setImagen("lapiz.jpg");
		p.setPrecio(10);
		
		this.mockMvc.perform(post("/api/productos/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(p))).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("producto_3.jpf")));
	}
	
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString

}
