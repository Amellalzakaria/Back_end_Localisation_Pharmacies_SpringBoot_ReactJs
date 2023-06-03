package ma.projet.demo.controller;

import ma.projet.demo.entities.Photo;
import ma.projet.demo.repositories.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @GetMapping
    public List<Photo> getAllImages() {
        return imageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Photo getImageById(@PathVariable int id) {
        return imageRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Photo createImage(@RequestBody Photo image) {
        return imageRepository.save(image);
    }

    @PutMapping("/{id}")
    public Photo updateImage(@PathVariable int id, @RequestBody Photo updatedImage) {
        Photo existingImage = imageRepository.findById(id).orElse(null);
        if (existingImage != null) {
            existingImage.setUrl(updatedImage.getUrl());
            return imageRepository.save(existingImage);
        }
        return null;
    }

    
    @GetMapping("/pharmacie/{pharmacieId}")
    public List<Photo> getImagesByPharmacieId(@PathVariable int pharmacieId) {
        return imageRepository.findByPharmacieId(pharmacieId);
    }
    
    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable int id) {
        imageRepository.deleteById(id);
    }
}
