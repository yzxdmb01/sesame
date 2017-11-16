package com.sesame.controller;

import com.sesame.bean.User;
import com.sesame.http.ResponseObj;
import com.sesame.service.TestService;
import com.sesame.utils.JsonUtils;
import com.sesame.utils.L;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

@Controller
public class TestController {

	@Autowired
	TestService testService;

	@ResponseBody
	@RequestMapping(value = "test")
	public String testStr(@RequestParam(required = false) String s) {
		testService.testSth();
		L.i("杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭");
		L.e("eeeeeeeeeeeeeeeeeeeee");
		return "{\"key\":\"123abc小明\"}";
	}

	@ResponseBody
	@RequestMapping(value = "result")
	public String testJson() {
		User user = new User();
		user.setName("小李子");
		user.setLoginId("a0000001");
		user.setPwd("000000");
		ResponseObj<User> responseObj = new ResponseObj<>();
		responseObj.setCode(ResponseObj.SUCCESS);
		responseObj.setMsg("测试成功");
		String result = JsonUtils.toJson(responseObj);
		return result;
	}

	@RequestMapping("abc")
	public String testABC(Model model) {
		System.out.println("these's abc method");
		return "abc";
	}

	@RequestMapping("testUpload")
	public String toUpload() {
		return "test_upload";
	}

	/**
	 * 多文件上传 name必须重复并且和接收的参数一致，这里都叫uploadFile
	 * <input type="file" name="uploadFile"><br><br>
	 *
	 * @param uploadFile
	 * @param session
	 * @return
	 */
	@RequestMapping("upload")
	public String doUpload(@RequestParam MultipartFile[] uploadFile, HttpSession session) {
		System.out.println("执行多文件上传-------------");
		System.out.println("uploadFile:" + uploadFile.length);
		for (MultipartFile mf : uploadFile) {
			System.out.println("OriginalFilename:" + mf.getOriginalFilename());
			System.out.println("Name" + mf.getName());
		}

//		System.out.println("name:"+uploadFile.getName());
//		System.out.println("getOriginalFilename:"+uploadFile.getOriginalFilename());
//		String leftPath = session.getServletContext().getRealPath("/save_img");
//		String fileName = uploadFile.getOriginalFilename();
//		File file = new File(leftPath,fileName);
//		try {
//			uploadFile.transferTo(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "test_upload";
//		}

		return "home";
	}

	/**
	 * 多文件上传另一种写法:jsp中name不能重复///
	 * <input type="file" name="uploadFile1"><br><br>
	 *
	 * @param multiRequest
	 * @return
	 */
	@RequestMapping("uploads")
	public String doUploads(MultipartHttpServletRequest multiRequest) {
		Iterator<String> names = multiRequest.getFileNames();
		while (names.hasNext()) {
			System.out.println("name:" + names.next());
		}
		return "test_upload";
	}

	/**
	 * 文件下载
	 *
	 * @return
	 */
	@RequestMapping("download")
	public ResponseEntity<byte[]> download() {
		System.out.println("开始文件下载");
		File file = new File("C:\\Users\\yzxdm\\Pictures\\img_nuk.jpg");
		if (file.exists()) {
			HttpHeaders headers = new HttpHeaders();
			try {
				String fileName = new String("中文.jpg".getBytes("UTF-8"), "iso-8859-1");
				headers.setContentDispositionFormData("attachment", fileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				System.out.println("异常了");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IO异常了");
			}
		} else {
			System.out.println("木有找到文件");
		}

		return null;
	}

	@ResponseBody
	@RequestMapping("test_path/{id}/end")
	public String testPathVariable(@PathVariable("id") String id) {


		return "id:" + id;
	}

	@RequestMapping(value = "method/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseObj testGet(@PathVariable("id") String id) {
		ResponseObj responseObj = new ResponseObj();
		responseObj.setCode(ResponseObj.SUCCESS);
		responseObj.setMsg("this is get method, parameter is id:" + id);
		return responseObj;
	}

	@RequestMapping(value = "method", method = RequestMethod.POST)
	@ResponseBody
	public ResponseObj testPost(String id) {
		ResponseObj responseObj = new ResponseObj();
		responseObj.setCode(ResponseObj.SUCCESS);
		responseObj.setMsg("this is post method, parameter is id:" + id);
		return responseObj;
	}

	@RequestMapping(value = "method/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseObj testDel(@PathVariable("id") String id) {
		ResponseObj responseObj = new ResponseObj();
		responseObj.setCode(ResponseObj.SUCCESS);
		responseObj.setMsg("this is del method, parameter is id:" + id);
		return responseObj;
	}


}
