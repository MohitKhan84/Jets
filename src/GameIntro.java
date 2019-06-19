import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.ArrayList;

import sun.audio.*;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameIntro extends Applet implements Runnable, KeyListener
{
	Image    offscreen_img;
	Graphics offscreen_g;
	int score = 1;
	
	ImageLayer sky       = new ImageLayer(0, 0, 1, "galaxy.jpg");

	
	boolean up_pressed = false;
	boolean dn_pressed = false;
	boolean lt_pressed = false;
	boolean rt_pressed = false;
	
	Thread t;
	
	Rect r0   = new Rect(1, 1, 10000, 5);     //Upper Boundary Line
	Rect r00  = new Rect(1, 670, 10000, 5);   //Lower Boundary Line
	Rect r000 = new Rect(4050, 1, 5, 670);  //Finish Line
	Rect r0000 = new Rect(1, 1, 5, 670);      //Starting Line
	Rect r01 = new Rect(1022, 1, 5, 670);	//Front Boundary Line
	
	Rect r1   = new Rect(70, 263, 71, 75);
	
	Rect r2  = new Rect(1000, 300, 35, 50);
	Rect r3  = new Rect(900, 100, 35, 50);
	Rect r4  = new Rect(700, 500, 35, 50); 
	Rect r5  = new Rect(1200, 300, 35, 50); 
	Rect r6  = new Rect(1200, 200, 35, 50);
	Rect r7  = new Rect(1300, 200, 35, 50);
	Rect r8  = new Rect(1300, 400, 35, 50);
	Rect r9  = new Rect(1400, 300, 35, 50);
	Rect r10 = new Rect(1400, 500, 35, 50);
	Rect r11 = new Rect(1500, 200, 35, 50);
	
	Rect r12 = new Rect(4000, 200, 35, 50);
	Rect r13 = new Rect(3900, 500, 35, 50);
	Rect r14 = new Rect(3900, 50, 35, 50);
	Rect r15 = new Rect(3800, 400, 35, 50);
	Rect r16 = new Rect(3800, 100, 35, 50);
	Rect r17 = new Rect(3700, 200, 35, 50);
	Rect r18 = new Rect(3700, 60, 35, 50);
	Rect r19 = new Rect(3200, 500, 35, 50);
	Rect r20 = new Rect(3400, 80, 35, 50);
	Rect r21 = new Rect(3500, 300, 35, 50);
	
	Rect r22 = new Rect(6000, 200, 35, 50);
	Rect r23 = new Rect(5900, 500, 35, 50);
	Rect r24 = new Rect(5900, 50, 35, 50);
	Rect r25 = new Rect(5800, 400, 35, 50);
	Rect r26 = new Rect(5800, 100, 35, 50);
	Rect r27 = new Rect(5700, 200, 35, 50);
	Rect r28 = new Rect(5700, 60, 35, 50);
	Rect r29 = new Rect(5200, 500, 35, 50);
	Rect r30 = new Rect(5400, 80, 35, 50);
	Rect r31 = new Rect(5500, 300, 35, 50);
	
	
	FighterJet jet1 = new FighterJet(100, 300, 0);
	
	BadJet jet2  = new BadJet(1025, 325, 180);
	BadJet jet3  = new BadJet(925, 125, 180);
	BadJet jet4  = new BadJet(725, 525, 180);
	BadJet jet5  = new BadJet(1225, 325, 180); 
	BadJet jet6  = new BadJet(1225, 225, 180);
	BadJet jet7  = new BadJet(1325, 225, 180);
	BadJet jet8  = new BadJet(1325, 425, 180);
	BadJet jet9  = new BadJet(1425, 325, 180);
	BadJet jet10 = new BadJet(1425, 525, 180);
	BadJet jet11 = new BadJet(1525, 225, 180);
	
	BadJet1 jet12 = new BadJet1(4025, 225, 180);
	BadJet1 jet13 = new BadJet1(3925, 525, 180);
	BadJet1 jet14 = new BadJet1(3925, 75, 180);
	BadJet1 jet15 = new BadJet1(3825, 425, 180);
	BadJet1 jet16 = new BadJet1(3825, 125, 180);
	BadJet1 jet17 = new BadJet1(3725, 225, 180);
	BadJet1 jet18 = new BadJet1(3725, 85, 180);
	BadJet1 jet19 = new BadJet1(3225, 525, 180);
	BadJet1 jet20 = new BadJet1(3425, 105, 180);
	BadJet1 jet21 = new BadJet1(3525, 325, 180);
	
	BadJet2 jet22 = new BadJet2(6025, 225, 180);
	BadJet2 jet23 = new BadJet2(5925, 525, 180);
	BadJet2 jet24 = new BadJet2(5925, 75, 180);
	BadJet2 jet25 = new BadJet2(5825, 425, 180);
	BadJet2 jet26 = new BadJet2(5825, 125, 180);
	BadJet2 jet27 = new BadJet2(5725, 225, 180);
	BadJet2 jet28 = new BadJet2(5725, 85, 180);
	BadJet2 jet29 = new BadJet2(5225, 525, 180);
	BadJet2 jet30 = new BadJet2(5425, 105, 180);
	BadJet2 jet31 = new BadJet2(5525, 325, 180);

   
	public void init()
	{	
		
		
		offscreen_img = this.createImage(1024, 768);
		offscreen_g   = offscreen_img.getGraphics();
		
		new Picture (this);
		Picture.music.loop();
	
		
		requestFocus();
		
		addKeyListener(this);
		
		
		t = new Thread(this);
		
		t.start();
		
	
		
	}
	
	public void run()
	{
		
		while(true)
		{
	
			
			repaint();
			
			try
			{
			   t.sleep(16);
			}
			catch(Exception x) {};
		}
	}
	


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)     up_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)   dn_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)   lt_pressed = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)  rt_pressed = true;

	}
	
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)     up_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)   dn_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)   lt_pressed = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)  rt_pressed = false;
		
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
	public void update(Graphics g)
	{
		offscreen_g.clearRect(0, 0, 1024, 768);
		
		paint(offscreen_g);
		
		g.drawImage(offscreen_img, 0, 0, 1024, 768, null);
	}
	
	public void paint(Graphics g)
	{
	
		
	if ((r1.overlaps(r2))||(r1.overlaps(r3))||(r1.overlaps(r4))||(r1.overlaps(r5))||(r1.overlaps(r6))
		||(r1.overlaps(r7))||(r1.overlaps(r8))||(r1.overlaps(r9))||(r1.overlaps(r10))||(r1.overlaps(r11))
		||(r1.overlaps(r12))||(r1.overlaps(r13))||(r1.overlaps(r14))||(r1.overlaps(r15))||(r1.overlaps(r16))
		||(r1.overlaps(r17))||(r1.overlaps(r18))||(r1.overlaps(r19))||(r1.overlaps(r20))||(r1.overlaps(r21))
		||(r1.overlaps(r22))||(r1.overlaps(r23))||(r1.overlaps(r24))||(r1.overlaps(r25))||(r1.overlaps(r26))
		||(r1.overlaps(r27))||(r1.overlaps(r28))||(r1.overlaps(r29))||(r1.overlaps(r30))||(r1.overlaps(r31))
		
				||(r1.overlaps(r0))||(r1.overlaps(r00))||(r1.overlaps(r0000))) {
			
			g.drawString("Game Over", 500, 300);
			g.drawString("Your Score", 500, 400);
			g.drawString(Integer.toString(score), 600, 400);
						
		}
		
		else if(r1.overlaps(r000)){
			g.drawString("Stage Clear", 500, 300);
			g.drawString("Final Score", 500, 400);
			g.drawString(Integer.toString(score), 600, 400);
		}
	
		else if(r1.overlaps(r01)){
			r1. draw(g); r2. draw(g); r3. draw(g); r4. draw(g); r5. draw(g); r6. draw(g); r7. draw(g); 
			r8. draw(g); r9. draw(g); r10.draw(g); r11.draw(g); r12.draw(g); r13.draw(g); r14.draw(g);
			r15.draw(g); r16.draw(g); r17.draw(g); r18.draw(g); r19.draw(g); r20.draw(g); r21.draw(g);
			r22.draw(g); r23.draw(g); r24.draw(g); r25.draw(g); r26.draw(g); r27.draw(g); r28.draw(g);
			r29.draw(g); r30.draw(g); r31.draw(g);
						
			Camera.moveRight(10);
			
			if(up_pressed)   r1.moveUp(1);
			if(dn_pressed)   r1.moveDown(1);
			if(lt_pressed)   r1.moveLeft(1);
			if(rt_pressed)   r1.moveRight(0);
			
			if(up_pressed)   jet1.moveUp(1);
			if(dn_pressed)   jet1.moveDown(1);
			if(lt_pressed)   jet1.moveLeft(1);
			if(rt_pressed)   jet1.moveRight(0);
			score++;
			
			jet2.moveLeft(1); 
			r2.moveLeft(1);   
			
			jet3.moveLeft(1); 
			r3.moveLeft(1);   
			
			jet4.moveLeft(1); 
			r4.moveLeft(1);   
			
			jet5.moveLeft(1); 
			r5.moveLeft(1);   
			
			jet6.moveLeft(1); 
			r6.moveLeft(1);   
			
			jet7.moveLeft(1); 
			r7.moveLeft(1);   
			
			jet8.moveLeft(1); 
			r8.moveLeft(1);   
			
			jet9.moveLeft(1); 
			r9.moveLeft(1);   
			
			jet10.moveLeft(1); 
			r10.moveLeft(1);   
			
			jet11.moveLeft(1); 
			r11.moveLeft(1);   
			
			jet12.moveLeft(2);
			r12.moveLeft(2);
			
			jet13.moveLeft(2);
			r13.moveLeft(2);
			
			jet14.moveLeft(2);
			r14.moveLeft(2);
			
			jet15.moveLeft(2);
			r15.moveLeft(2);
			
			jet16.moveLeft(2);
			r16.moveLeft(2);
			
			jet17.moveLeft(2);
			r17.moveLeft(2);
			
			jet18.moveLeft(2);
			r18.moveLeft(2);
			
			jet19.moveLeft(2);
			r19.moveLeft(2);
			
			jet20.moveLeft(2);
			r20.moveLeft(2);
			
			jet21.moveLeft(2);
			r21.moveLeft(2);
			
			jet22.moveLeft(2);
			r22.moveLeft(2);
			
			jet23.moveLeft(2);
			r23.moveLeft(2);
			
			jet24.moveLeft(2);
			r24.moveLeft(2);
			
			jet25.moveLeft(2);
			r25.moveLeft(2);
			
			jet26.moveLeft(2);
			r26.moveLeft(2);
			
			jet27.moveLeft(2);
			r27.moveLeft(2);
			
			jet28.moveLeft(2);
			r28.moveLeft(2);
			
			jet29.moveLeft(2);
			r29.moveLeft(2);
			
			jet30.moveLeft(2);
			r30.moveLeft(2);
			
			jet31.moveLeft(2);
			r31.moveLeft(2);
			
		//	r000.moveLeft(1);
			
			sky.draw(g);
			
			jet1. draw(g); jet2. draw(g); jet3. draw(g); jet4. draw(g); jet5. draw(g); jet6. draw(g); 
			jet7. draw(g); jet8. draw(g); jet9. draw(g); jet10.draw(g); jet11.draw(g); jet12.draw(g);
			jet13.draw(g); jet14.draw(g); jet15.draw(g); jet16.draw(g); jet17.draw(g); jet18.draw(g);
			jet19.draw(g); jet20.draw(g); jet21.draw(g); jet22.draw(g); jet23.draw(g); jet24.draw(g);
			jet25.draw(g); jet26.draw(g); jet27.draw(g); jet28.draw(g); jet29.draw(g); jet30.draw(g);
			jet31.draw(g);
						
			r0.draw(g);
			r00.draw(g);
			r000.draw(g);
			r000.moveLeft(1);
			r0000.draw(g);
			r01.draw(g);
			
			g.drawString("Score", 850, 50);
			g.drawString(Integer.toString(score), 900, 50);
			
			
		}
		
			
		else{
			r1. draw(g); r2. draw(g); r3. draw(g); r4. draw(g); r5. draw(g); r6. draw(g); r7. draw(g); 
			r8. draw(g); r9. draw(g); r10.draw(g); r11.draw(g); r12.draw(g); r13.draw(g); r14.draw(g);
			r15.draw(g); r16.draw(g); r17.draw(g); r18.draw(g); r19.draw(g); r20.draw(g); r21.draw(g);
			r22.draw(g); r23.draw(g); r24.draw(g); r25.draw(g); r26.draw(g); r27.draw(g); r28.draw(g);
			r29.draw(g); r30.draw(g); r31.draw(g);
						
			Camera.moveRight(10);
			
			if(up_pressed)   r1.moveUp(1);
			if(dn_pressed)   r1.moveDown(1);
			if(lt_pressed)   r1.moveLeft(1);
			if(rt_pressed)   r1.moveRight(1);
			
			if(up_pressed)   jet1.moveUp(1);
			if(dn_pressed)   jet1.moveDown(1);
			if(lt_pressed)   jet1.moveLeft(1);
			if(rt_pressed)   jet1.moveRight(1);
			score++;
			
			jet2.moveLeft(1); 
			r2.moveLeft(1);   
			
			jet3.moveLeft(1); 
			r3.moveLeft(1);   
			
			jet4.moveLeft(1); 
			r4.moveLeft(1);   
			
			jet5.moveLeft(1); 
			r5.moveLeft(1);   
			
			jet6.moveLeft(1); 
			r6.moveLeft(1);   
			
			jet7.moveLeft(1); 
			r7.moveLeft(1);   
			
			jet8.moveLeft(1); 
			r8.moveLeft(1);   
			
			jet9.moveLeft(1); 
			r9.moveLeft(1);   
			
			jet10.moveLeft(1); 
			r10.moveLeft(1);   
			
			jet11.moveLeft(1); 
			r11.moveLeft(1);   
			
			jet12.moveLeft(2);
			r12.moveLeft(2);
			
			jet13.moveLeft(2);
			r13.moveLeft(2);
			
			jet14.moveLeft(2);
			r14.moveLeft(2);
			
			jet15.moveLeft(2);
			r15.moveLeft(2);
			
			jet16.moveLeft(2);
			r16.moveLeft(2);
			
			jet17.moveLeft(2);
			r17.moveLeft(2);
			
			jet18.moveLeft(2);
			r18.moveLeft(2);
			
			jet19.moveLeft(2);
			r19.moveLeft(2);
			
			jet20.moveLeft(2);
			r20.moveLeft(2);
			
			jet21.moveLeft(2);
			r21.moveLeft(2);
			
			jet22.moveLeft(2);
			r22.moveLeft(2);
			
			jet23.moveLeft(2);
			r23.moveLeft(2);
			
			jet24.moveLeft(2);
			r24.moveLeft(2);
			
			jet25.moveLeft(2);
			r25.moveLeft(2);
			
			jet26.moveLeft(2);
			r26.moveLeft(2);
			
			jet27.moveLeft(2);
			r27.moveLeft(2);
			
			jet28.moveLeft(2);
			r28.moveLeft(2);
			
			jet29.moveLeft(2);
			r29.moveLeft(2);
			
			jet30.moveLeft(2);
			r30.moveLeft(2);
			
			jet31.moveLeft(2);
			r31.moveLeft(2);
			
		//	r000.draw(g);
					
			sky.draw(g);
			
			jet1. draw(g); jet2. draw(g); jet3. draw(g); jet4. draw(g); jet5. draw(g); jet6. draw(g); 
			jet7. draw(g); jet8. draw(g); jet9. draw(g); jet10.draw(g); jet11.draw(g); jet12.draw(g);
			jet13.draw(g); jet14.draw(g); jet15.draw(g); jet16.draw(g); jet17.draw(g); jet18.draw(g);
			jet19.draw(g); jet20.draw(g); jet21.draw(g); jet22.draw(g); jet23.draw(g); jet24.draw(g);
			jet25.draw(g); jet26.draw(g); jet27.draw(g); jet28.draw(g); jet29.draw(g); jet30.draw(g);
			jet31.draw(g);
						
			r0.draw(g);
			r00.draw(g);
			r000.draw(g);
			r000.moveLeft(1);
			r0000.draw(g);
			r01.draw(g);
			
			g.drawString("Score", 850, 50);
			g.drawString(Integer.toString(score), 900, 50);
		}
	
	
		
	
		
		
		
	}
	
	
}