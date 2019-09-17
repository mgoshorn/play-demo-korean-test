create table speech_part (
	id SERIAL primary key,
	part VARCHAR(20) not null check (char_length(part) > 0)
)

create table dictionary (
	id SERIAL primary key,
	word VARCHAR(15) not null check (CHAR_LENGTH(word) > 0),
	definition VARCHAR(40) not null check (char_length(definition) > 0),
	speech_part_id INTEGER references speech_part(id) not null
)

insert into speech_part (part) values ('noun'), ('verb'), ('adjective'), ('adverb');

insert into dictionary (word, definition, speech_part_id) values
	('고양이', 'cat', 1),
	('강아지', 'puppy', 1),
	('오리', 'duck', 1),
	('뱀', 'snake', 1),
	('오늘', 'today', 1),
	('내일', 'tomorrow', 1),
	('어제', 'yesterday', 1),
	('지금', 'now', 1),
	('아까', 'a while ago', 1),
	('사막', 'desert', 1),
	('해변', 'beach', 1),
	('숲', 'forest', 1),
	('비', 'rain', 1),
	('가다', 'to go', 2),
	('오다', 'to come', 2),
	('주다', 'to give', 2),
	('받다', 'to receive, get, take', 2),
	('먹다', 'to eat', 2),
	('마시다', 'to drink', 2),
	('걷다', 'to walk', 2),
	('달리다', 'to run', 2),
	('하다', 'to do', 2),
	('공부하다', 'to study', 2),
	('좋아하다', 'to like [something]', 2),
	('싫어하다', 'to dislike, hate [something]', 2),
	('좋다', 'to be good', 3),
	('맑다', 'to be clean, to be clear (weather)', 3),
	('바쁘다', 'to be busy', 3),
	('복잡하다', 'to be complicated', 3),
	('심심하다', 'to be bored', 3),
	('기쁘다', 'to be happy, glad, pleased', 3),
	('즐겁다', 'to be pleasant, enjoyable, cheerful', 3),
	('다뜻하다', 'to be warm', 3),
	('시원하다', 'to be cool', 3),
	('피곤하다', 'to be tired, exhausted', 3),
	('졸리다', 'to be sleepy', 3);
