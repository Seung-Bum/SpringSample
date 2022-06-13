package org.springframework.samples.mvc.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RestController
@RequestMapping(value="/response", method=RequestMethod.GET)
public class ResponseController {

	@GetMapping("/annotation")
	public String responseBody() {
		return "The String ResponseBody";
	}

	@GetMapping("/charset/accept")
	public String responseAcceptHeaderCharset() {
		return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)";
	}

	// produces : 서버에서 브라우저로 데이터를 보낼 때 설정한 charset만 나오게 거르는 것이다.
	@GetMapping(value="/charset/produce", produces="text/plain;charset=UTF-8")
	public String responseProducesConditionCharset() {
		return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)";
	}

	@GetMapping("/entity/status")
	public ResponseEntity<String> responseEntityStatusCode() {
		return new ResponseEntity<String>("The String ResponseBody with custom status code (403 Forbidden)",
				HttpStatus.FORBIDDEN);
	}

	@GetMapping("/entity/status1")
	public ResponseEntity<String> responseEntityStatusCode1() {
		return new ResponseEntity<String>("The server has processed the request.",
				HttpStatus.OK);
	}

	@GetMapping("/entity/headers")
	public ResponseEntity<String> responseEntityCustomHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/plain",
				headers, HttpStatus.OK);
	}

	@GetMapping("/entity/headers1")
	public ResponseEntity<String> responseEntityCustomHeaders1() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_XML);
		return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/xml",
				headers, HttpStatus.OK);
	}




}
