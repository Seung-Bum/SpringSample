package org.springframework.samples.mvc.mapping;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/class-mapping/*")
// RequestMapping : 공통파트가 있으면 위로 빼서 사용
public class ClasslevelMappingController {

	@GetMapping("/path")
	public String byPath() {
		return "Mapped by path!";
	}
	// @RestController를 붙이면 return 값이 전달
	// 페이지 리턴시 @Controller

	@GetMapping("/path/*")
	public String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@GetMapping("/method")
	public String byMethod() {
		return "Mapped by path + method";
	}

	@GetMapping(path="/parameter", params="foo")
	public String byParameter() {
		return "Mapped by path + method + presence of query parameter!";
	}

	@GetMapping(path="/parameter", params="!foo")
	public String byParameterNegation() {
		return "Mapped by path + method + not presence of query!";
	}

	@GetMapping(path="/header", headers="FooHeader=foo")
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}

	@GetMapping(path="/notheader", headers="!FooHeader")
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}


	@PostMapping(path="/consumes", consumes="application/json")
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}
	// @RequestParam => https://www.youtube.com/watch?v=2ifq3tHxBQQ => ? 뒤의 값을 가져온다.
	// @RequestBody => 키, 벨류로 이루어짐

	@GetMapping(path="/produces", produces="application/json")
	public JavaBean byProduces() {
		return new JavaBean();
	}

}
