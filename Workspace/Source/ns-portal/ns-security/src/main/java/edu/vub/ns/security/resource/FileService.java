package edu.vub.ns.security.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import edu.vub.ns.webcore.bean.ResponseBean;



@Path("/fileupload") 
public class FileService {
	
	@Context ServletContext servletContext;
	private final String ROOT_FOLDER_IMAGES = "images";
	private final String UNIX_BACKUP_FOLDER_IMAGES = "/root/software/images";
	private final String WINDOWS_BACKUP_FOLDER_IMAGES = "D:/tmp";
	private String localPhotoServer = null;
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	@POST
	@Path("/upload") 
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ResponseBean uploadFile(@FormDataParam("file") InputStream is,	
			@FormDataParam("file") FormDataContentDisposition formData, 
			@QueryParam("folderName") String folderName) {
		ResponseBean response = new ResponseBean();
		String rootPath = servletContext.getRealPath(ROOT_FOLDER_IMAGES);
		File file = new File(rootPath + File.separator + folderName);
		try {
			if (isWindows()) {
				localPhotoServer = WINDOWS_BACKUP_FOLDER_IMAGES;
			} else if (isUnix()) {
				localPhotoServer = UNIX_BACKUP_FOLDER_IMAGES;
			} else {
				System.out.println("Your OS is not support to image backup!!!");
			}
			
			String fileName = saveFile(is, file, folderName, formData);
			response.setSuccess(true);
			response.setData("images/" + folderName +"/" + fileName);
			// return Response.status(Status.OK).entity("images/" + folderName +"/" + fileName).build();
		} catch (IOException e) {
			e.printStackTrace();
			// return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
 
	private String saveFile(InputStream is, File file, String folderName, FormDataContentDisposition formData) throws IOException {
		if(!file.exists()){
			file.mkdir();
		}
		String fileLocation = file.getAbsolutePath()+ File.separator + formData.getFileName();
		
		OutputStream os = new FileOutputStream(new File(fileLocation));
		byte[] buffer = new byte[256];
	    int bytes = 0;
	    while ((bytes = is.read(buffer)) != -1) {
	        os.write(buffer, 0, bytes);
	    }
	    os.close();
	    
	    String ext = FilenameUtils.getExtension(fileLocation);
		
		File oldfile = new File(fileLocation);
		File newfile = new File(file.getAbsolutePath()+ File.separator + UUID.randomUUID().toString()+"."+ext);
		oldfile.renameTo(newfile);
		
		File localFile = new File(localPhotoServer + File.separator + folderName + File.separator + newfile.getName());
		FileUtils.copyFile(newfile, localFile);
		
		return newfile.getName();
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
	}

	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}
	
	
}
 





