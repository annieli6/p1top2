package javajame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
	Image menu, playButton, exitButton;
	//public String mouse = "No Input yet..";
	public Menu(int State){
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException{
		 menu = new Image("res/Menu.png");
		 playButton = new Image("res/PlayButton.png");
		 exitButton = new Image("res/exitButton.png");
		
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) 
			throws SlickException{
		//g.drawString(mouse,50,50);
		g.drawImage(menu,0,0);
		g.drawImage(playButton,521,450);
		g.drawImage(exitButton,580,680);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if((xpos>520 && xpos<920)&&(ypos>150 && ypos<350))
		{
			if(input.isMouseButtonDown(0))
			{
				sbg.enterState(1);
			}
		}
		if((xpos>580 && xpos<880)&&(ypos>18 && ypos<115))
		{
			if(input.isMouseButtonDown(0))
			{
				System.exit(0);
			}
		}
	//	mouse = "Mouse position x: "+xpos + " y: "+ ypos;
		
	}
	
	public int getID(){
		return 0;
	}	
}
