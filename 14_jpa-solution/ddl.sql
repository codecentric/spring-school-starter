create table Article (
	id bigint not null, 
	created timestamp not null, 
	updated timestamp not null, 
	exitCount integer not null, 
	exitRate numeric(19,2), 
	pageDurationAvg numeric(19,2), 
	pageImpressionsCount integer not null, 
	socialMediaCount integer not null, 
	socialMediaRate numeric(19,2), 
	statisticsCreationDate date, 
	videoViewCount integer not null, 
	videoViewRate numeric(19,2), 
	contentId bigint not null, 
	href varchar(255) not null, 
	section varchar(255), title 
	varchar(255) not null, 
	articleScore_id bigint, 
	primary key (id))

create table ArticleScore (
	id bigint not null, 
	created timestamp not null, 
	updated timestamp not null, 
	exitScore integer not null, 
	lengthOfStayScore integer not null, 
	pageImpressionScore integer not null, 
	score integer not null, 
	socialMediaScore integer not null, 
	videoViewsScore integer not null, 
	primary key (id))
