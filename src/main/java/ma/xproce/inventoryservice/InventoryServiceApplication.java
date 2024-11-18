package ma.xproce.inventoryservice;
import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
@SpringBootApplication
public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            // Création de créateurs
            List<Creator> creators = List.of(
                    Creator.builder().name("Creator 1").email("creator1@example.com").build(),
                    Creator.builder().name("Creator 2").email("creator2@example.com").build(),
                    Creator.builder().name("Creator 3").email("creator3@example.com").build()
            );
            creatorRepository.saveAll(creators);
            // Création de vidéos en associant un créateur à chaque vidéo
            List<Video> videos = List.of(
                    Video.builder().name("Video 1").url("http://example.com/video1").description("Description 1")
                            .datePublication("2024-10-28").creator(creators.get(0)).build(),
                    Video.builder().name("Video 2").url("http://example.com/video2").description("Description 2")
                            .datePublication("2024-10-29").creator(creators.get(1)).build(),
                    Video.builder().name("Video 3").url("http://example.com/video3").description("Description 3")
                            .datePublication("2024-10-30").creator(creators.get(2)).build()
            );
            videoRepository.saveAll(videos);
        };
    }
}
