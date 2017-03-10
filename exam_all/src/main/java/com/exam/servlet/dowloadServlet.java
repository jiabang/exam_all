package com.exam.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dowloadServlet")
public class dowloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public dowloadServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String img_id = request.getParameter("img_id");
		Integer id = Integer.parseInt(img_id);
		if (id == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if (id != 1) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {

			File src = new File(id + ".jpg");
			File dst = new File("copy_" + id + ".jpg");

			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			try {
				in = (BufferedInputStream) dowloadServlet.class.getClassLoader().getResourceAsStream(id + ".jpg");
				out = new BufferedOutputStream(new FileOutputStream(dst));
				String path1 = this.getClass().getResource("").getPath();
				System.out.println("path1:" + path1);

				int len = -1;
				byte[] b = new byte[10];
				while ((len = in.read(b)) != -1) {
					out.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("logined.jsp").forward(request, response);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}

			request.getRequestDispatcher("su.jsp").forward(request, response);

			/*
			 * if(dir.exists()){ if(dir.isDirectory()){ File img=new
			 * File(id+".jpg"); if(img.exists()){ if(dir.isFile()){
			 * System.out.println("文件已经存在！！！"); String e= "文件已经存在！！！" ;
			 * request.setAttribute("error", e); }else{
			 * 
			 * } }else { System.out.println("dir 文件夹出错！"); String e=
			 * "dir 文件夹出错！！" ; request.setAttribute("error", e);
			 * 
			 * } }
			 * 
			 * }
			 */
		}
	}
}
