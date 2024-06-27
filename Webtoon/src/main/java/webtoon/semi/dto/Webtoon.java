package webtoon.semi.dto;

import lombok.*;

<<<<<<< HEAD
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
=======
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> 3bbc18d1291654b2667fedf4ec391617913f4491
public class Webtoon {
	private int web_code;
	private String web_name;
	private String web_author;
<<<<<<< HEAD
	private String web_image_path;
	private String web_genre; //장르
	private String web_summary; // 소개내용
	private String web_day;
	private String web_year;
=======
	private String web_genre;
	private String web_summary;
	private String web_story;
	private String web_image_path;
	private int score;
	private String web_day;
	private String web_year;
	private String web_finishYN;
	private String web_completed_date;
	private String web_challengeYN;
>>>>>>> 3bbc18d1291654b2667fedf4ec391617913f4491
}
