package co.kr.mono.studydb.model.music;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

	private String mstId  ;
	private String mstName  ;
	private String debutDate  ;
	private List<Album> album;

	@Override
	public String toString() {
/*
		return "Artist [mstId=" + mstId + ", mstName=" + mstName + ", debutDate=" + debutDate + ", album=" + album
				+ "]";
*/

		return "Artist [mstId=" + mstId + ", mstName=" + mstName + ", debutDate=" + debutDate +  "]";
	}






}
