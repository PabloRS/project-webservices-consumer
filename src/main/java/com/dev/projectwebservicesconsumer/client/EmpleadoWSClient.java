/**
 * 
 */
package com.dev.projectwebservicesconsumer.client;

import java.time.LocalDateTime;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.dev.projectwebservicesconsumer.dto.EmpleadoDTO;

/**
 * @author pablo
 *
 */
public class EmpleadoWSClient {
	
	public static void main(String[] args) {
		/*
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/project-webservices/dev/empleadosWS").path("consultarEmpleado").path("123");
		
		Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocation.get();
		
		if(response.getStatus() == 204) {
			System.out.println("No se encontro el empleado");
		}
		
		if(response.getStatus() == 200) {
			EmpleadoDTO empleado = response.readEntity(EmpleadoDTO.class);
			
			System.out.println("Nombre empleado: " + empleado.getNombre());
			System.out.println("Fecha creacion: " + empleado.getFechaCreacion());
		}
		*/
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/project-webservices/dev/empleadosWS").path("guardarEmpleado");
		
		EmpleadoDTO empleado = new EmpleadoDTO();
		empleado.setNumeroEmpleado("111");
		empleado.setNombre("Fabian");
		empleado.setPrimerApellido("Flores");
		empleado.setSegundoApellido("Arvizu");
		empleado.setEdad(26);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocation.post(Entity.entity(empleado, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() == 400) {
			String error = response.readEntity(String.class);
			System.out.println(error);
		}
		
		if(response.getStatus() == 200) {
			EmpleadoDTO empl = response.readEntity(EmpleadoDTO.class);
			
			System.out.println(empl.getNumeroEmpleado());
			System.out.println(empl.getNombre());
			System.out.println(empl.getPrimerApellido());
			System.out.println(empl.getSegundoApellido());
			System.out.println(empl.getEdad());
			System.out.println(empl.getFechaCreacion());
		}
		
		
		
		
		
	}

}
