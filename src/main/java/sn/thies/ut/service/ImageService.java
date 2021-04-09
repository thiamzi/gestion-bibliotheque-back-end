package sn.thies.ut.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.thies.ut.modeles.Image;
import sn.thies.ut.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private final ImageRepository imagerepository;

	public ImageService(ImageRepository imagerepository) {
		super();
		this.imagerepository = imagerepository;
	}
	
	public Image addImage(Image image) {
		return this.imagerepository.save(image);
	}
	
	public List<Image> getAllImage(){
		return this.imagerepository.findAll();
	}
	
	public void deleteImage(int id) {
		this.imagerepository.deleteById(id);
	}
	
	public Image findOneImage(int id) {
		return this.imagerepository.findById(id).get();
	}
	
	public Image updateImage(Image image) {
		return this.imagerepository.save(image);
	}
}
