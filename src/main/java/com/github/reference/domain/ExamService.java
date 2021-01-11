package com.github.reference.domain;

import com.github.reference.domain.model.BookEntity;
import com.github.reference.domain.model.AuthorEntity;

public interface ExamService {

	
	public BookEntity save(BookEntity laboratory);

	public void delete(BookEntity laboratory);

	public BookEntity associate(BookEntity exam, AuthorEntity laboratory);

	public void desassociate(BookEntity exam, AuthorEntity laboratory);
}

