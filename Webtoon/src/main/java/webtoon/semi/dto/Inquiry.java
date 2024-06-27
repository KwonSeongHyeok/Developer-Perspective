package webtoon.semi.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Inquiry {
	private String inquiry_title;
	private String inquiry_writer;
	private String inquiry_email;
	private String inquiry_massage;
}