CREATE TABLE webtoon (
 web_code NUMBER PRIMARY KEY,
 web_name VARCHAR2(100) NOT NULL,
 web_author VARCHAR2(50) NOT NULL,
 web_genre VARCHAR2(20) NOT NULL,
 web_summary VARCHAR2(255) NOT NULL,
 web_story CLOB NOT NULL,
 web_image_path VARCHAR2(100),
 web_score NUMBER(2, 1),
 web_day VARCHAR2(20) NOT NULL,
 web_year DATE,
 web_finishYN CHAR(1),
 web_completed_date VARCHAR2(30)
);

CREATE SEQUENCE web_seq;
