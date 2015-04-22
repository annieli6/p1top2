package javajame;
import javax.management.timer.Timer;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	Animation Shooter, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quit = false;
	int[] duration = {200,200};
	float shooterPositionX = 30;
	float shooterPositionY = 30;
	float shiftX=30;
	float shiftY= 30;
	public String mouse = "No Input yet..";
	public Play(int State){
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException{
		worldMap = new Image("res/GamePlay.png");
		Image[] walkUp = {new Image("res/rsNorth.png"),new Image("res/rsNorth.png")};
		Image[] walkDown = {new Image("res/rsSouth.png"),new Image("res/rsSouth.png")};
		Image[] walkLeft = {new Image("res/rsWest.png"),new Image("res/rsWest.png")};
		Image[] walkRight = {new Image("res/rsEast.png"),new Image("res/rsEast.png")};
		
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		Shooter = movingDown;
		
		
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) 
			throws SlickException{
		g.drawImage(worldMap,0,0);
		Shooter.draw(shooterPositionX,shooterPositionY);
		g.drawString("Shooter's X: "+shooterPositionX
				+"\nShooter's Y: "+ shooterPositionY,1200,30);
		g.drawString(mouse,23,660);
		
		
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		//Moving Up in Action Button
		if((xpos>872 && xpos<972)&&(ypos>620 && ypos<712))
		{
			if(input.isMouseButtonDown(0))
			{
				Shooter = movingUp;
				shooterPositionY-= delta * .3f ;
				//boundries of map
				if(shooterPositionY<25){
					shooterPositionY =25;
				}
			}
		}
		//Moving Down in Action Button
		if((xpos>995 && xpos<1095)&&(ypos>620 && ypos<712))
		{
			if(input.isMouseButtonDown(0))
			{
				Shooter = movingDown;
				shooterPositionY += delta * .3f;
				//boundries of map
				if(shooterPositionY>502){
					shooterPositionY =502;
				}
			}
		}
		//Moving Left in Action Button
		if((xpos>1121 && xpos<1225)&&(ypos>620 && ypos<712))
		{
			if(input.isMouseButtonDown(0))
			{
				Shooter = movingLeft;
				shooterPositionX -= delta * .3f;
				//boundries of map
				if(shooterPositionX<24){
					shooterPositionX =24;
				}
			}
		}
		//Moving Right in Action Button
		if((xpos>1246 && xpos<1350)&&(ypos>620 && ypos<712))
		{
			if(input.isMouseButtonDown(0))
			{
				Shooter = movingRight;
				shooterPositionX += delta * .3f;
				//boundries of map
				if(shooterPositionX>555){
					shooterPositionX =555;
				}
			}
		}
				
		//Ready Button
		if((xpos>896 && xpos<1184)&&(ypos>25 && ypos<134))
		{
			if(input.isMouseButtonDown(0))
			{
				System.out.println("Waiting for player");
				System.exit(0);
			}
		}
		//Quit Button
		if((xpos>1217 && xpos<1367)&&(ypos>45 && ypos<118))
		{
			if(input.isMouseButtonDown(0))
			{
				System.exit(0);
			}
		}
		//Mouse coordinate Position
		mouse = "Mouse position x: "+xpos + " y: "+ ypos;
		
	}
	
	public int getID(){
		return 1;
	}	
}
