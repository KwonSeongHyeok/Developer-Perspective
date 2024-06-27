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
}
