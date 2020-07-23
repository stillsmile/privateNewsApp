package com.etc.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.etc.tool.VCodeGenerator;

public class VCodeAction {

	public String execute() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
        PrintWriter writer;
		try {
			
			//创建验证码生成器对象
			VCodeGenerator vcGenerator = new VCodeGenerator();
			//生成验证码
			String vcode = vcGenerator.generatorVCode();
			//将验证码保存在session域中,以便判断验证码是否正确
			request.getSession().setAttribute("vcode", vcode);
			//生成验证码图片
			BufferedImage vImg = vcGenerator.generatorRotateVCodeImage(vcode, true);
			//输出图像
			ImageIO.write(vImg, "gif", response.getOutputStream());
			
			getVCode(request, response);
			String randomMath = String.format("%04d",new Random().nextInt(9999));
			writer = response.getWriter();
			writer.print("" + vImg);
	        writer.flush();
	        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 获取验证码
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getVCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建验证码生成器对象
		VCodeGenerator vcGenerator = new VCodeGenerator();
		//生成验证码
		String vcode = vcGenerator.generatorVCode();
		//将验证码保存在session域中,以便判断验证码是否正确
		request.getSession().setAttribute("vcode", vcode);
		//生成验证码图片
		BufferedImage vImg = vcGenerator.generatorRotateVCodeImage(vcode, true);
		//输出图像
		ImageIO.write(vImg, "gif", response.getOutputStream());
	}
}
