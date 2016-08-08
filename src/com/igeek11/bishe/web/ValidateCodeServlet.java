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
	//根据chars生成一个随机的整数
	public String generateRandomString(){
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		
		for(int i=0;i<4;i++){
			sb.append(chars[r.nextInt(chars.length)]);//r.nextInt(chars.length),生成一个随机整数，比chars的长度小
		}
		return sb.toString();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取一个随机字符串
		String vc = generateRandomString();
		req.getSession().setAttribute("vc", vc);
		//将这个字符串以图片的形式发送到客户端
		// 设置响应头 Content-type类型  
        resp.setContentType("image/jpeg");  
        // 以下三句是用于设置页面不缓存  
        resp.setHeader("Pragma", "No-cache");  
        resp.setHeader("Cache-Control", "No-cache");  
        resp.setDateHeader("Expires", 0);  
  
        OutputStream os = resp.getOutputStream();  
        int width = 83, height = 30;  
        // 建立指定宽、高和BufferedImage对象  
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);  
  
        Graphics g = image.getGraphics(); // 该画笔画在image上  
        Color c = g.getColor(); // 保存当前画笔的颜色，用完画笔后要回复现场  
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);  //画一个矩形
        g.setFont(new Font("宋体", Font.BOLD, 20));
        g.setColor(Color.black);
        g.drawString(vc, 20, 20);
        g.setColor(c);
        g.dispose();//销毁画笔
        
        ImageIO.write(image, "JPEG", os); //通过servlet的输出流将图片输出 
        
	}
}
