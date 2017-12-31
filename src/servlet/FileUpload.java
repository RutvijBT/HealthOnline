package servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.omg.CORBA.portable.InputStream;


@WebServlet("/file")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		try {
			List List = upload.parseRequest(request);
			Iterator iter = List.iterator();
			while (iter.hasNext()) {
			    FileItem item = (FileItem) iter.next();

			    /*if (item.isFormField()) {
			    //	System.out.print("form field");
			    	String name = item.getFieldName();//text1
			    	String value = item.getString();
			    	System.out.println(name);
			    	System.out.println(value);

			    } else {*/
			    	System.out.println("Fiel uploading");
			    	//yaaaaaaaaaaa
			    	int val=0;
			    	String saveFile="";
			    	String contentType = request.getContentType();
			    	DataInputStream in = new DataInputStream(request.getInputStream());
			    	int formDataLength = request.getContentLength();
			    	byte dataBytes[] = new byte[formDataLength];
			    	int byteRead = 0;
			    	int totalBytesRead = 0;
			    	while (totalBytesRead < formDataLength) {
			    		byteRead = in.read(dataBytes,totalBytesRead,formDataLength);
			    		totalBytesRead += byteRead;
			    	}
			    	String file = new String(dataBytes);
			    	saveFile = file.substring(file.indexOf("filename=\"") + 10);
			    	//System.out.println("saveFile=" + saveFile);
			    	//saveFile = saveFile.substring(saveFile.lastIndexOf("\\")+ 1,saveFile.indexOf("\""));
			    	//System.out.println("saveFile" + saveFile);
			    	//saveFile = file.substring(file.indexOf("filename=\"") + 10);
			    	saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			    	saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			    	int lastIndex = contentType.lastIndexOf("=");
			    	String boundary = contentType.substring(lastIndex + 1,contentType.length());
			    	int pos;
			    	pos = file.indexOf("filename=\"");
			    	pos = file.indexOf("\n", pos) + 1;
			    	pos = file.indexOf("\n", pos) + 1;
			    	pos = file.indexOf("\n", pos) + 1;
			    	int boundaryLocation = file.indexOf(boundary, pos) - 4;
			    	int startPos = ((file.substring(0, pos)).getBytes()).length;
			    	int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			    	saveFile="D:/study/Adv Java/HealthOnlineProject/files/"+saveFile;
			    	File ff = new File(saveFile);
			    	FileOutputStream fileOut = new FileOutputStream(ff);
			    	fileOut.write(dataBytes, startPos, (endPos - startPos));
			    	fileOut.flush();
			    	fileOut.close();
			    	//yaaaaaaaaaaaa
			    
			}
			
		} catch (FileUploadException e) {
			System.out.print(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
