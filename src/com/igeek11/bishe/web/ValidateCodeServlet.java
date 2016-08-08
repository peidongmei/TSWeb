package com.igeek11.bishe.web;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateCode")
public class ValidateCodeServlet extends HttpServlet {
	private char chars[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i'};
	//����chars����һ�����������
	public String generateRandomString(){
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		
		for(int i=0;i<4;i++){
			sb.append(chars[r.nextInt(chars.length)]);//r.nextInt(chars.length),����һ�������������chars�ĳ���С
		}
		return sb.toString();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡһ������ַ���
		String vc = generateRandomString();
		req.getSession().setAttribute("vc", vc);
		//������ַ�����ͼƬ����ʽ���͵��ͻ���
		// ������Ӧͷ Content-type����  
        resp.setContentType("image/jpeg");  
        // ������������������ҳ�治����  
        resp.setHeader("Pragma", "No-cache");  
        resp.setHeader("Cache-Control", "No-cache");  
        resp.setDateHeader("Expires", 0);  
  
        OutputStream os = resp.getOutputStream();  
        int width = 83, height = 30;  
        // ����ָ�����ߺ�BufferedImage����  
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);  
  
        Graphics g = image.getGraphics(); // �û��ʻ���image��  
        Color c = g.getColor(); // ���浱ǰ���ʵ���ɫ�����껭�ʺ�Ҫ�ظ��ֳ�  
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);  //��һ������
        g.setFont(new Font("����", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString(vc, 20, 20);
        g.setColor(c);
        g.dispose();//���ٻ���
        
        ImageIO.write(image, "JPEG", os); //ͨ��servlet���������ͼƬ��� 
        
	}
}
