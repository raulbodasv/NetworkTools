package com.rbodas.verifyConnections.entities;

import java.io.IOException;
import java.lang.reflect.Array;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.rbodas.verifyConnections.models.Connection;

import org.springframework.stereotype.Service;

@Service 
public class VerificarPuertosAbiertos {

	public List<Connection> checkOpenPorts(){
		// Rango de puertos a comprobar
        int puertoInicio = 1;
        int puertoFin = 65535;

        List<Connection> puertos = new ArrayList<>();
        
        // Iterar sobre los puertos
        for (int puerto = puertoInicio; puerto <= puertoFin; puerto++) {
        	Connection c = new Connection();
            try (Socket socket = new Socket ("localhost", puerto)) {
                
                System.out.println("Puerto abierto: " + puerto);
                
                c.setPuerto(puerto);
                c.setRespuestaPort("Puerto abierto: " + puerto);
                puertos.add(c);
                
            } catch (IOException e) { 
            	System.out.println("El puerto "+puerto+" está cerrado o no se puede acceder");
            	//puertos.add(c);
            }
        }
        System.out.println("FIN PUERTOS ABIERTOS");
		return puertos;
		
	}
	
	public String checkOpenPort(int puerto){
		// Comprobar si el puerto está abierto
        try (Socket socket = new Socket ("localhost", puerto)) {
        	socket.setReuseAddress(true);
        	System.out.println("Puerto abierto: " + puerto);
        	return "Puerto abierto: " + puerto;
        } catch (IOException e) {
        	System.out.println("El puerto está cerrado o no se puede acceder");
        	return "El puerto está cerrado o no se puede acceder";
        }
	}
	
}
