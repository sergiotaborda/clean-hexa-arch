package com.github.reference.application.services;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.reference.application.model.Author;
import com.github.reference.application.model.AuthorKey;

public interface AuthorApplicationService {

	public List<Author> findAll ();
	public Optional<Author> findByKey (AuthorKey key);
	public Author save (Author author);
	public List<Author> saveAll (List<Author> authors);
	public void deleteByKey (AuthorKey key);
	public void deleteAllByKeys (Set<AuthorKey> keys);
}
