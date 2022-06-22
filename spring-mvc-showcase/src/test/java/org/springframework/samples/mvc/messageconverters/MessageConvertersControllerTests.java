package org.springframework.samples.mvc.messageconverters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
public class MessageConvertersControllerTests extends AbstractContextControllerTests {

	//  MockMVC 메서드

	//  perform :
	//  가상의 요청을 처리한다.
	//  return값으로 ResultActions 객체를 받으며,
	//  이 객체는 리턴 값을 검증하고 확인할 수 있는 andExpect()를 제공한다.

	//	andExpect : 응답을 검증하는 역할을 한다.
	//	상태 코드 검증 ( status() )
	//	응답 본문 내용 검증 ( content() )
	//	스프링 MVC 모델 상태 검증 ( model() )

	//	andDo
	//	전체 결과 출력 ( print() )

	//  MockMvcResultMatchers의 메서드
	//  print(), content()

	private static String URI = "/messageconverters/{action}";

	private MockMvc mockMvc;

	// Message Body에 들어가는 타입을 HTTP Header에 명시해줄 수 있는데 이때 명시해줄 수 있도록 해주는 필드가 바로 Content Type
	// Text타입으로는 text/css, text/javascript, text/html, text/plain 등이 있습니다.
	// file을 실어보내기 위해서는 multipart/form-data가 있고 Application 타입으로는
	// application/json, application/x-www-urlencoded등이 있습니다.

	@BeforeEach
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
	}


	// StringHttpMessageConverter
	// 반환해야하는 데이터가 문자열일 경우
	//
	@Test
	public void readString() throws Exception {
		this.mockMvc.perform(post(URI, "string")
						.characterEncoding("utf-8")
						.content("foo".getBytes())) // @RequestBody의 HttpBody 내용을 "foo"로 하겠다.
				.andDo(print())
				.andExpect(content().string("Read string 'foo'"));
	}
	@Test
	public void writeString() throws Exception {
		this.mockMvc.perform(get(URI, "string"))
				.andDo(print())
				.andExpect(content().string("Wrote a string"));
	}


	// Form encoded data (application/x-www-form-urlencoded)
	// html의 form의 기본 Content-Type으로 요즘은 자주 사용하지 않지만 여전히 사용하는 경우가 종종 존재합니다.
	//
	@Test
	public void readForm() throws Exception {
		this.mockMvc.perform(
				post(URI, "form")
					.contentType(MediaType.APPLICATION_FORM_URLENCODED) // from type
					.param("foo", "bar") // 여기서 bar와 apple 입력
					.param("fruit", "apple"))
				.andDo(print())
				.andExpect(content().string("Read x-www-form-urlencoded: JavaBean {foo=[bar], fruit=[apple]}"));
	}
	@Test
	public void writeForm() throws Exception {
		this.mockMvc.perform(get(URI, "form").contentType(MediaType.APPLICATION_FORM_URLENCODED))
//				.andExpect(content().contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andDo(print())
				.andExpect(content().string("foo=bar&fruit=apple"));
	}


	// Jaxb2RootElementHttpMessageConverter
	// (requires JAXB2 on the classpath - useful for serving clients that expect to work with XML)
	// @XmlRootElement를 JavaBean에 붙여놔야한다. => mapping
	//
	private static String XML =
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
			"<javaBean><foo>bar</foo><fruit>apple</fruit></javaBean>";

	@Test
	public void readXml() throws Exception {
		this.mockMvc.perform(
				post(URI, "xml")
					.contentType(MediaType.APPLICATION_XML)
					.content(XML.getBytes())) // XML 형태로 보내서 맵핑
					//.characterEncoding("utf-8")
				.andDo(print())
				.andExpect(content().string("Read from XML: JavaBean {foo=[bar], fruit=[apple]}"));
	}
	@Test
	public void writeXml() throws Exception {
		this.mockMvc.perform(get(URI, "xml")
						.accept(MediaType.APPLICATION_XML))
				.andDo(print())
				.andExpect(content().xml(XML));
	}


	// MappingJacksonHttpMessageConverter
	// (requires Jackson on the classpath -
	// particularly useful for serving JavaScript clients that expect to work with JSON)
	//
	@Test
	public void readJson() throws Exception {
		this.mockMvc.perform(
				post(URI, "json")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{ \"foo\": \"bar\", \"fruit\": \"apple\" }".getBytes()))
				.andDo(print())
				.andExpect(content().string("Read from JSON: JavaBean {foo=[bar], fruit=[apple]}"));
	}
	@Test
	public void writeJson() throws Exception {
		this.mockMvc.perform(get(URI, "json")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$.foo").value("bar"))
				.andExpect(jsonPath("$.fruit").value("apple"));
	}
	@Test
	public void writeJson2() throws Exception {
		this.mockMvc.perform(get(URI, "json")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$.foo").value("bar"))
				.andExpect(jsonPath("$.fruit").value("apple"));
	}


	// AtomFeedHttpMessageConverter (requires Rome on the classpath - useful for serving Atom feeds)
	// 데이터 피드는 일반적으로 클라이언트 응용 프로그램이 이해하는
	// 사용자에게 유용한 정보를 포함하는 정의 된 파일 형식입니다.
	//
	private static String ATOM_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			"<feed xmlns=\"http://www.w3.org/2005/Atom\"><title>My Atom feed</title></feed>";

	@Test
	public void readAtom() throws Exception {
		this.mockMvc.perform(
				post(URI, "atom")
					.contentType(MediaType.APPLICATION_ATOM_XML)
					.content(ATOM_XML.getBytes()))
				.andDo(print())
				.andExpect(content().string("Read My Atom feed"));
	}
	@Test
	public void writeAtom() throws Exception {
		this.mockMvc.perform(get(URI, "atom").accept(MediaType.APPLICATION_ATOM_XML))
				.andDo(print())
				.andExpect(content().xml(ATOM_XML));
	}


	// RssChannelHttpMessageConverter (requires Rome on the classpath - useful for serving RSS feeds)
	// 뉴스나 블로그 사이트에서 주로 사용하는 콘텐츠 표현 방식이다.
	// 웹 사이트 관리자는 RSS 형식으로 웹 사이트 내용을 보여 준다.
	// 이 정보를 받는 사람은 다른 형식으로 이용할 수 있다. RSS 리더에는 웹기반형과 설치형이 있다.
	// 웹기반형 리더는 간단한 계정등록으로 어디에서든 이용할 수 있다는 장점을 가지고 있다.
	//
	@Test
	public void readRss() throws Exception {

		String rss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <rss version=\"2.0\">" +
				"<channel><title>My RSS feed</title></channel></rss>";

		this.mockMvc.perform(
				post(URI, "rss")
					.contentType(MediaType.valueOf("application/rss+xml"))
					.content(rss.getBytes()))
				.andDo(print())
				.andExpect(content().string("Read My RSS feed"));
	}
	@Test
	public void writeRss() throws Exception {

		String rss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<rss version=\"2.0\"><channel><title>My RSS feed</title><link>http://localhost:8080/mvc-showcase/rss</link>" +
				"<description>Description</description></channel></rss>";

		this.mockMvc.perform(get(URI, "rss").accept(MediaType.valueOf("application/rss+xml"))).andDo(print())
				.andExpect(content().xml(rss));
	}

}
