package org.jin.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.jin.domain.AttachFileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {

//	@Resource(name = "uploadPath")
	private String uploadPath = "F:\\testUpload";
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@RequestMapping(value = "uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		logger.info("���� ���ε� ȭ��");
	}

	@RequestMapping(value = "uploadForm", method = RequestMethod.POST)
	public void uploadForm(MultipartFile[] file, Model model) throws Exception {
		for (MultipartFile files : file) {
			
		
			
			logger.info("originalName : " + files.getOriginalFilename());
			logger.info("File Size : " + files.getSize());
			logger.info("ContentType : " + files.getContentType());
			logger.info("File ���� ��ġ : " + uploadPath);
			/*
			 * String saveName = uploadFile(files.getOriginalFilename(), files.getBytes());
			 */
			File saveFile = new File(uploadPath, files.getOriginalFilename());

			try {
				files.transferTo(saveFile);
			} catch (Exception e) {
				// TODO: handle exception
				logger.info(e.getMessage());
			}
		}

	}

	// ��/��/�� ���� ���� �޼���
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		
		System.out.println("���� ��¥ : " + str);
		
		return str.replace("-", File.separator);
	}

	@RequestMapping(value = "uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		logger.info("���� ���ε� ajax ȭ��");
	}
	
	// �̹��� ������ �Ǵ��� ���ְ� �ϴ� �޼���
	private boolean checkImageType(File file) {
		
		try {
			String contentType = Files.probeContentType(file.toPath());			
			return contentType.startsWith("image");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = "uploadAjax", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachFileDTO>> uploadAjax(MultipartFile[] file) throws Exception {
		File uploadFolder = new File(uploadPath,getFolder());
		logger.info("���� ���ε� ����" + uploadFolder);
		

		List<AttachFileDTO> list = new ArrayList<>();
		
		//���� ����
		// exists() : �ش� ��ΰ� �����ϴ��� �Ǻ�
		if(uploadFolder.exists() == false) {
			uploadFolder.mkdirs();	// ��ο� ������ ���ٸ� ����
		}
		for (MultipartFile files : file) {
			
			logger.info("originalName : " + files.getOriginalFilename());
			logger.info("File Size : " + files.getSize());
			logger.info("ContentType : " + files.getContentType());
			logger.info("File ���� ��ġ : " + uploadPath);
			
			AttachFileDTO attach = new AttachFileDTO();
			
			String fileName = files.getOriginalFilename();
			attach.setFileName(fileName);
			
			String uploadFileName = files.getOriginalFilename();
			
			UUID uid = UUID.randomUUID();
			
			uploadFileName = uid.toString()+"_"+uploadFileName;
			
			File saveFile = new File(uploadFolder, uploadFileName);
			try {
				files.transferTo(saveFile);
				
				attach.setUploadPath(getFolder());
				attach.setUuid(uid.toString());
				
				// ����� ������ִ� ����
				if(checkImageType(saveFile)) {
					
					attach.setImage(true);
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(files.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				list.add(attach);
			} catch (Exception e) {
				// TODO: handle exception
				logger.info(e.getMessage());
			}
		}

		return new ResponseEntity<>(list, HttpStatus.CREATED);
		//return new ResponseEntity<String>("Upload ����!", HttpStatus.CREATED);
	}

	@RequestMapping(value = "display", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getFile(String fileName) {
		logger.info("FileName = "+fileName);
		File file = new File("F:\\testUpload\\"+fileName);
		logger.info("file = "+file);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), 
															header,HttpStatus.OK);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return result;
	}
	@RequestMapping(value = "download", method = RequestMethod.GET,
				produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName){
		logger.info("Download File : " + fileName);
		
		Resource resource = new FileSystemResource("F:\\testUpload\\"+fileName);
		
		logger.info("resource : "+ resource);
		
		String resourceName = resource.getFilename();
		
		HttpHeaders header = new HttpHeaders();
		
		try {
			header.add("Content-Disposition", "attachment; filename=" +
											new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
		
	}
	@RequestMapping(value = "deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName, String type) {
		logger.info("fileName : " + fileName);
		logger.info("type : " + type);
		
		File file;
		
		try {
			file = new File("F:\\testUpload\\"+URLDecoder.decode(fileName,"UTF-8"));
			logger.info("file : "+file);
			file.delete();
			if(type.equals("image")) {
				String originalFile = file.getAbsolutePath().replace("s_", "");
				file = new File(originalFile);
				file.delete();
				
			}
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("delete",HttpStatus.OK);
	}

}
