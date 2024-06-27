package webtoon.semi.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Webtoon {
	private int web_code;
	private String web_name;
	private String web_author;
	private String web_image_path;
	private String web_genre; //장르
	private String web_summary; // 소개내용
	private String web_day;
	private String web_year;
}
