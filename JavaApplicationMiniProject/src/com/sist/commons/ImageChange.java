package com.sist.commons;
import java.awt.*;
import javax.swing.*;
public class ImageChange {
	
	public static Image getImage(ImageIcon icon, int width, int height)
	{
		return icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		//이미지 축소 / 확대 (프로그램에 맞춰서)
	}
	
	
}
