package za.co.wethinkcode.model;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;

public class Market {
	private String _serverAddress = "127.0.0.1";
	private int _PORT = 5001;
	private Socket _socket;
	private Scanner _in;
	private PrintWriter _out;
	private int _marketId;
	
	public Market() {
		return ;
	}

	private void getMarketId() {
		String line = _in.nextLine();
		System.out.println(line);
		this._marketId = Integer.parseInt(line.substring(19));
		return ;
	}

	public void run() throws IOException {
		try {
			this._socket = new Socket(_serverAddress, _PORT);
			this._in = new Scanner(_socket.getInputStream());
			this._out = new PrintWriter(_socket.getOutputStream(), true);

			getMarketId();
			while (_in.hasNextLine()) {
				String line = _in.nextLine();
				// do something with this input
				System.out.println("message from broker " + line);
			}
		} finally {}
	}
}
