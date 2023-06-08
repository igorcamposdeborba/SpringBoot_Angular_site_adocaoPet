package com.adocao.pet.services;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adocao.pet.entities.Adopter;
import com.adocao.pet.entities.AdopterPetAssociation;
import com.adocao.pet.entities.Ong;
import com.adocao.pet.entities.Pet;
import com.adocao.pet.entities.enums.Gender;
import com.adocao.pet.entities.enums.Health;
import com.adocao.pet.entities.enums.Size;
import com.adocao.pet.repositories.AdopterPetAssociationRepository;
import com.adocao.pet.repositories.AdopterRepository;
import com.adocao.pet.repositories.OngRepository;
import com.adocao.pet.repositories.PetRepository;

@Service // injetar instancias em outras partes do código
public class DBService {

	@Autowired // spring intancia objeto injetando dependência
	private PetRepository petRepository;
	@Autowired
	private OngRepository ongRepository;
	@Autowired
	private AdopterRepository adopterRepository;
	@Autowired
	private AdopterPetAssociationRepository adopterPetRepository;
	
	
	public void instantiateDataBase() {
		// Definir atributos	
		Set<Health> healthPet1 = new HashSet<>();
		healthPet1.add(Health.CASTRADO);
		healthPet1.add(Health.VERMIFUGADO);
		
		Set<Health> healthPet2 = new HashSet<>();
		healthPet2.add(Health.VACINADO);
		
		Set<Health> healthPet3 = new HashSet<>();
		healthPet3.add(Health.CASTRADO);
		
		Set<Health> healthPet4 = new HashSet<>();
		healthPet4.add(Health.VERMIFUGADO);
		
		// Instanciar objetos para pré-popular o banco de dados
		Ong ong1 = new Ong(null, "Adote POA", "adotepoa@hotmail.com", "(51) 981789290", "www.instagram.com/adotepoa", "Carla da Silva");
		Ong ong2 = new Ong(null, "Garra", "ongagarra@yahoo.com.br", "(48) 30758967", "https://www.onggarra.com", "Eduardo Torres");
		Ong ong3 = new Ong(null, "Porto Filhote", "portofilhote@hotmail.com", "(51) 99874895", "https://www.portofilhote.com.br/", "Philip Kotler");
		
		 // Acessar imagem da url
		/*byte[] image1, image2;
		try {
			image1 = getImageUrl("https://images.squarespace-cdn.com/content/v1/53bb46d6e4b05c06d49b574b/1680731496553-PT8S8CQFJA7MUQERK2CE/Friday_crop.jpg");
			image2 = getImageUrl("https://spca.bc.ca/wp-content/uploads/cat-tabby-wearing-id-at-home-looking-up.jpg");
		} catch(IOException e ) {
			e.printStackTrace();
		} // codificar no formato Base64 para o front-end/Angular poder ler
		image1 = Base64.getEncoder().encode("abc1".getBytes());
		image2 = Base64.getEncoder().encode("cde2".getBytes());
		*/
		String image1 = "https://images.squarespace-cdn.com/content/v1/53bb46d6e4b05c06d49b574b/1680731496553-PT8S8CQFJA7MUQERK2CE/Friday_crop.jpg";
		String image2 = "https://spca.bc.ca/wp-content/uploads/cat-tabby-wearing-id-at-home-looking-up.jpg";
		String image3 = "https://img.freepik.com/fotos-premium/feche-o-retrato-de-um-jovem-cachorro-vira-lata-marrom-e-branco-avermelhado-olhando-para-cima-sentado-na-calcada-cinza-em-um-dia-ensolarado-de-verao-fundo-desfocado_222877-11483.jpg";
		String image4 = "https://cdn.wamiz.fr/cdn-cgi/image/format=auto,quality=80,width=776,height=388,fit=cover/article/main-picture/5f1ab523804ef449086633.jpg";
		String image5 = "https://i.pinimg.com/originals/15/87/30/158730c6d18724fd8ed04484912f48af.jpg";
		String image6 = "https://www.rover.com/blog/wp-content/uploads/2021/03/older-dog-960x540.jpg";
		String image7 = "https://www.patasdacasa.com.br/sites/patasdacasa/files/styles/webp/public/noticias/2021/02/gatos-sentem-energia-das-pessoas-conheca-algumas-historias-misticas-sobre-os-felinos.jpg.webp?itok=DBHUZQPm";
		String image8 = "https://image.cachorrogato.com.br/thumb/800/600/1/imagens/original/imagem115.jpg";
		String image9 = "https://media-cldnry.s-nbcnews.com/image/upload/t_fit-1500w,f_auto,q_auto:best/rockcms/2022-01/210602-doge-meme-nft-mb-1715-8afb7e.jpg";
		
		Pet pet1 = new Pet(null, "Rex", image1 , Size.M, Gender.MACHO, healthPet1, 4,  "Dócil e ativo", ong1);
		Pet pet2 = new Pet(null, "Flora", image2, Size.P, Gender.FEMEA, healthPet2, 0, "Ativa", ong3);
		Pet pet3 = new Pet(null, "Bidu", image3, Size.G, Gender.MACHO, healthPet3, 2, "Ativo, um pouco desconfiado e ama passear", ong2);
		Pet pet4 = new Pet(null, "Nina", image4, Size.M, Gender.FEMEA, healthPet4, 7, "Ativa e sociável", ong3);
		Pet pet5 = new Pet(null, "Max", image5, Size.M, Gender.MACHO, healthPet2, 12, null, ong2);
		Pet pet6 = new Pet(null, "Mike", image6, Size.P, Gender.MACHO, healthPet1, 5, "Ativo, dócil, não é acostumado a outros animais", ong1);
		Pet pet7 = new Pet(null, "Simba", image7, Size.G, Gender.MACHO, healthPet3, 7, null, ong3);
		Pet pet8 = new Pet(null, "Lili", image8, Size.G, Gender.FEMEA, healthPet4, 2, "Dócil e carinhosa", ong1);
		Pet pet9 = new Pet(null, "Fred", image9, Size.M, Gender.MACHO, healthPet1, 5, "Dócil, tranquilo e carinhoso", ong3);
		
		
		Adopter adopter1 = new Adopter(null, "Daniela da Silva", "daniela@yahoo.com.br", "55 51 981547895");
		Adopter adopter2 = new Adopter(null, "Bruno dos Santos", "bruno@hotmail.com", "55 14 34159768");
		
		AdopterPetAssociation adopterPet1 = new AdopterPetAssociation();
		adopterPet1.setPet(pet1);
		adopterPet1.setAdopter(adopter1);
		
		
		ongRepository.saveAll(Arrays.asList(ong1, ong2, ong3));
		petRepository.saveAll(Arrays.asList(pet1, pet2, pet3, pet4, pet5, pet6, pet7, pet8, pet9));
		adopterRepository.saveAll(Arrays.asList(adopter1, adopter2));
		adopterPetRepository.saveAll(Arrays.asList(adopterPet1));

	}
	
	// Pegar imagem de uma url
	/*public static byte[] getImageUrl(String imageUrl) throws IOException {
		URL url = new URL(imageUrl);
		
		try (InputStream inputStream = url.openStream();
			 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) { // imagem em stream de bytes
			
			byte[] buffer = new byte[4096];
			int bytesRead;
			while((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead); // salvar cada byte da imagem
			}
			
			return outputStream.toByteArray(); // converter em array de bytes
		}
		
	}*/
	
	
}
