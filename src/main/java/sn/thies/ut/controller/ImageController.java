package sn.thies.ut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.thies.ut.modeles.Image;
import sn.thies.ut.service.ImageService;
@RestController
@RequestMapping("/api")
public class ImageController {
	
	private final ImageService imageService;

	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}

	@GetMapping("/allimages")
	public ResponseEntity<List<Image>> getAllimages(){
		List<Image> emprunts = imageService.getAllImage();
		return new ResponseEntity<List<Image>>(emprunts , HttpStatus.OK);
	}
	
	@GetMapping("/oneimage/{id}")
	public ResponseEntity<Image> findOneimage(@PathVariable int id){
		Image emprunt = imageService.findOneImage(id);
		return new ResponseEntity<Image>(emprunt , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteimage/{id}")
	public ResponseEntity<Image> deleteimage(@PathVariable int id){
		imageService.deleteImage(id);
		return new ResponseEntity<Image>(HttpStatus.OK);
	}
	
	@PostMapping("/addimage")
	public 	ResponseEntity<Image> addimage(@RequestBody Image image){
		Image newimage = imageService.addImage(image);
		return new ResponseEntity<Image>(newimage , HttpStatus.OK);
	}

	@PutMapping("/updateimage")
	public 	ResponseEntity<Image> updateimage(@RequestBody Image image){
		Image updatenewimage = imageService.updateImage(image);
		return new ResponseEntity<Image>(updatenewimage , HttpStatus.OK);
	}
}
