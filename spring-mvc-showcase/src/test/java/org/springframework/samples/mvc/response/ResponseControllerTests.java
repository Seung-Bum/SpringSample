package org.springframework.samples.mvc.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ResponseControllerTests {

	// perform :
	// 가상의 요청을 처리한다.
	// return값으로 ResultActions 객체를 받으며,
	// 이 객체는 리턴 값을 검증하고 확인할 수 있는 andExpect()를 제공한다.

	//	andExpect : 응답을 검증하는 역할을 한다.
	//	상태 코드 검증 ( status() )
	//	응답 본문 내용 검증 ( content() )
	//	스프링 MVC 모델 상태 검증 ( model() )

	//	andDo
	//	전체 결과 출력 ( print() )

	private MockMvc mockMvc;

	// 테스트에 사용할 파라미터의 세팅을 반드시 해줘야한다.
	// 테스트할 컨트롤러의 MockMvc객체 생성
	@BeforeEach
	public void setup() {
		this.mockMvc = standaloneSetup(new ResponseController()).build();
	}

	@Test
	public void responseBody() throws Exception {
		this.mockMvc.perform(get("/response/annotation"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string("The String ResponseBody"));
	}

	@Test
	public void responseCharsetAccept() throws Exception {
		this.mockMvc.perform(
				get("/response/charset/accept")
					.accept(new MediaType("text", "plain", Charset.forName("UTF-8"))))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string(
						"\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)"));
	}

	@Test
	public void responseCharsetProduce() throws Exception {
		this.mockMvc.perform(get("/response/charset/produce"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string(
						"\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)"));
	}

	@Test
	public void responseEntityStatus() throws Exception {
		this.mockMvc.perform(get("/response/entity/status"))
				.andExpect(status().isForbidden())
				.andDo(print())
				.andExpect(content().string(
						"The String ResponseBody with custom status code (403 Forbidden)"));
	}

	@Test
	public void responseEntityHeaders() throws Exception {
		this.mockMvc.perform(get("/response/entity/headers"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string(
						"The String ResponseBody with custom header Content-Type=text/plain"));
	}

}
