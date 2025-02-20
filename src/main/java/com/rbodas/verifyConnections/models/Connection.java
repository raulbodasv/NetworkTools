package com.rbodas.verifyConnections.models;

import java.lang.reflect.Array;
import java.util.List;

public class Connection {

	private int puerto;
	private String respuestaPort;
	private List<Connection> respuestaPorts;
	private Array puertosAbiertos;
	
	public Connection(int puerto, String respuestaPort, List<Connection> respuestaPorts, Array puertosAbiertos) {
		super();
		this.puerto = puerto;
		this.respuestaPort = respuestaPort;
		this.respuestaPorts = respuestaPorts;
		this.puertosAbiertos = puertosAbiertos;
	}

	public Connection() {
		// TODO Auto-generated constructor stub
	}

	public int getPuerto() {
		return puerto;
	}
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public Array getPuertosAbiertos() {
		return puertosAbiertos;
	}

	public void setPuertosAbiertos(Array puertosAbiertos) {
		this.puertosAbiertos = puertosAbiertos;
	}

	public String getRespuestaPort() {
		return respuestaPort;
	}

	public void setRespuestaPort(String respuestaPort) {
		this.respuestaPort = respuestaPort;
	}

	public List<Connection> getRespuestaPorts() {
		return respuestaPorts;
	}

	public void setRespuestaPorts(List<Connection> respuestaPorts) {
		this.respuestaPorts = respuestaPorts;
	}

	@Override
	public String toString() {
		return "Connection [puerto=" + puerto + ", respuestaPort=" + respuestaPort + ", respuestaPorts="
				+ respuestaPorts + ", puertosAbiertos=" + puertosAbiertos + "]";
	}

	

}
