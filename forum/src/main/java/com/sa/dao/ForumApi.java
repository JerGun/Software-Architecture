package com.sa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "*", allowedHeaders = "*")
@RestController
public class ForumApi {

	@Autowired
	ForumRepository forumRepository;
	
	@GetMapping("/forums")
	public List<Forum> getAllForums() { 
		return forumRepository.findAll();
	}
	
	@GetMapping("/forum/{id}")
	public Forum getForum(@PathVariable("id") Integer id) {
		return forumRepository.findById(id);
	}
	
	@PostMapping("/forum")
	public String addForum(@RequestBody Forum forum) {
		forumRepository.save(forum);
		return "Add Forum Successfully!";
	}
	
	@PutMapping("/forum")
	public String editForum(@RequestBody Forum forum) {
		Forum editForum = forumRepository.findById(forum.getForumId());
		editForum.setForumAuthor(forum.getForumAuthor());
		editForum.setForumDetail(forum.getForumDetail());
		editForum.setForumLove(forum.getForumLove());
		forumRepository.save(editForum);
		return "Edit Forum Successfully!";
	}
	
	@DeleteMapping("/forum/{id}")
	public String deleteForum(@PathVariable("id") Integer id) {
		forumRepository.delete(forumRepository.findById(id));
		return "Delete Forum Successfully!";	
	}
	
	@PutMapping("/love/{id}")
	public String editLove(@PathVariable("id") Integer id) {
		Forum editForum = forumRepository.findById(id);
		editForum.setForumLove(editForum.getForumLove() + 1);
		forumRepository.save(editForum);
		return "Forum " + id + " +1 Love";
	}
}
