package game;

import game.net.GameClient;
import game.net.GameServer;

import javax.swing.JOptionPane;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame implements Runnable {
	public static final String gamename = "Gambit";
	public static final int menu = 0;
	public static final int play = 1;
	public boolean running = false;

	private GameServer socketServer;
	private GameClient socketClient;
	private Thread thread;

	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}

	public void initSatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}

	
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
	}
	

	public void init()
	{
		if(socketClient != null)
		socketClient.sendData("ping".getBytes());
	}

	public synchronized void start() {
		running = true;
		
		// thread.start();
		String s = JOptionPane.showInputDialog("Do you want to start a server?\n[1] = yes \t\t[2] = no ");
		if (s.equals("1") || s.equalsIgnoreCase("yes")) {
			socketServer = new GameServer(this);
			socketServer.start();
			System.out.println("got to here 1");
		}
		socketClient = new GameClient(this, "10.0.0.2");
		socketClient.start();
		System.out.println("got to here 2");
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	@Override
	public void run() {
		init();
		while (running) {
			//System.out.println("hello World");
		}
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		new Game(gamename).start();
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(1400, 800, false);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}
}