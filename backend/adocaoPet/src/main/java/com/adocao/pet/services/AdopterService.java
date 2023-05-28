package com.adocao.pet.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adocao.pet.entities.Adopter;
import com.adocao.pet.entities.AdopterPetAssociation;
import com.adocao.pet.entities.Pet;
import com.adocao.pet.entities.dtos.AdopterDTO;
import com.adocao.pet.repositories.AdopterPetAssociationRepository;
import com.adocao.pet.repositories.AdopterRepository;
import com.adocao.pet.repositories.PetRepository;
import com.adocao.pet.services.exceptions.IllegalFormatException;
import com.adocao.pet.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;

@Service // injetar instancias em outras partes do código
public class AdopterService {

	@Autowired // spring intancia objeto injetando dependência
	private AdopterRepository adopterRepository;
	@Autowired
	private AdopterPetAssociationRepository adopterPetAssociationRepository;
	@Autowired 
	private PetRepository petRepository;
	
	
	public List<Adopter> findAll() {
		return adopterRepository.findAll();
	}
	
	public Adopter findById(Integer id) {
		Optional<Adopter> adopter = adopterRepository.findById(id);
		
		return adopter.orElseThrow(() -> new ObjectNotFoundException("Adotante não encontrado pelo id " + id));
	}
	
	public Adopter findByEmail(String email) {
		Optional<Adopter> adopter = adopterRepository.findByEmail(email);

		return adopter.orElse(null);
	}
	
	// !! REVISAR ver se devo implementar no AdopterDTO e aqui o relacionamento com AdopterPetAssociation E ao invés do AdopterPetAssociation salvar uma nova linha, ele atualiza o e-mail daquele usuário se já existe o e-mail para aquele Pet no banco de dados
	// ADICIONA recurso no banco de dados
	public Adopter create(Integer idPet, @Valid AdopterDTO adopterDTO) {
		// UPDATE: Validar se já existe o adopter no banco de dados pelo e-mail, se sim, só atualizar os dados que o adopter enviou.
		Optional<Adopter> varAdopterOnDatabase = adopterRepository.findByEmail(adopterDTO.getEmail());
		
		if (adopterDTO != null && varAdopterOnDatabase.isPresent() && adopterDTO.getEmail().equalsIgnoreCase(varAdopterOnDatabase.get().getEmail())) { // verificar se existe o cadastro daquele e-mail
				return update(idPet, adopterDTO); // ATUALIZAR cadastro
				
		} else {
			Adopter varNewAdopter = new Adopter(adopterDTO); // CONVERTER DTO para Adopter
			
			// Converter DTO para Objeto e atribuir Objetos
			AdopterPetAssociation adopterPetAssociation = new AdopterPetAssociation(); // criar data e hora do request
			adopterPetAssociation.setAdopter(varNewAdopter);
			// Buscar no banco de dados
			Optional<Pet> varPet = petRepository.findById(idPet);
			adopterPetAssociation.setPet(varPet.get());
			// adopterPetAssociationRepository.save(adopterPetAssociation); // CREATE: salvar a classe associativa no banco de dados // ! CORRIGIR: PRIMEIRO SALVA RO OBJETO ADOPTER, DEPOIS A CLASSE ASSOCIATIVA
			
			return adopterRepository.save(varNewAdopter); // ADICIONAR cadastro: salvar no banco de dados pelo Repository	
		} 
	}
	
	// EDITA ou ADICIONA recurso no banco de dados: porque tenho só um botão para enviar o formulário
	public Adopter update(Integer idPet, @Valid AdopterDTO adopterDTO) {
		// Encontrar Adopter pelo email e validar exceptions
		Adopter newAdopter = findByEmail(adopterDTO.getEmail());
		Optional<Adopter> oldAdopter = adopterRepository.findByEmail(adopterDTO.getEmail());
		validateEmail(adopterDTO);
		validateIsPresentName(adopterDTO);
		validateTelephone(adopterDTO);
		
		// EDITAR
		if (oldAdopter.isPresent()) {
			Adopter editedAdopter = oldAdopter.get(); // Get(): retornar o objeto inteiro da classe
			editedAdopter.setName(adopterDTO.getName()); // Editar atributos
			editedAdopter.setTelephone(adopterDTO.getTelephone());
			
			return adopterRepository.save(editedAdopter);
		}
		
		// ADICIONAR: Criar objeto que vou adicionar no banco de dados		
		adopterDTO.setId(null); // Validação: garantir que o objDTO do parâmetro que estou adicionando não tenha id (evita alterar outro registro se tiver id na requisição)
		newAdopter = new Adopter(adopterDTO);		
		
		return adopterRepository.save(newAdopter); // CREATE: salvar no banco de dados
	}
	
	public AdopterPetAssociation addPetAdopter(Integer idPet, Adopter adopterObj) {
		// Buscar no banco de dados o Pet
		Optional<Pet> varPet = petRepository.findById(idPet);
		
		// ATUALIZAR DateRequest: buscar no banco de dados se já tem o Adopter na entity associativa. Se estiver, só atualizar o dateRequest (data e hora do pedido de adoção)
		Optional<AdopterPetAssociation> varAdopterDateRequest = adopterPetAssociationRepository.findByAdopterId(adopterObj.getId()); // buscar na classa associativa se existe o Adopter para atualizar o dateRequest
		if (varAdopterDateRequest.isPresent()) { 
			varAdopterDateRequest.get().changeDateRequest(Instant.now());
			
			return adopterPetAssociationRepository.save(varAdopterDateRequest.get()); // Salvar no banco de dados a classe de associação
			
			
		} else { // CRIAR REGISTRO: criar nova linha porque não tem esse usuário na classe associativa AdopterPet
			// Converter DTO para Objeto e atribuir Objetos
			AdopterPetAssociation adopterPetAssociation = new AdopterPetAssociation(); // criar data e hora do request
			adopterPetAssociation.setAdopter(adopterObj); // atribuir objeto Adopter

			Pet petObj = null;
			if (varPet.isPresent()) {
				petObj = varPet.orElse(null);
			}
			adopterPetAssociation.setPet(petObj); // atribuir objeto Pet
			
			return adopterPetAssociationRepository.save(adopterPetAssociation); // Salvar no banco de dados a classe de associação
		}	
	}
	
	
	// VALIDAÇÃO Obrigatória
	private void validateEmail(AdopterDTO adopterDTO) {
		if (adopterDTO == null) {
			throw new NullPointerException("O campo E-MAIL é obrigatório");
		}
		
		if(adopterDTO.getEmail().equalsIgnoreCase("teste@hotmail.com")) {
			throw new IllegalFormatException("Formato errado de E-MAIL. Exemplo: teste@hotmail.com. Não use o e-mail do exemplo.");
		}
		
		if (!adopterDTO.getEmail().contains("@")) {
			throw new IllegalFormatException("Formato errado de E-MAIL. Exemplo: teste@hotmail.com");
		}
	}
	
	
	// Validações Facultativas/'redundantes' por segurança no back-end (front já valida isso no html) para não persistir errado no banco de dados caso alguém altere o html
	
	private void validateIsPresentName(AdopterDTO adopterDTO) {
		
		if (adopterDTO.getName() == null) { // Validar se existe o nome do adotante no parâmetro para a requisição
			throw new NullPointerException("O campo NOME é obrigatório");
		}
	}
	
	// Validar o valor (formatação) do telefone. Admite repetição de telefone no banco de dados porque duas pessoas podem ter o mesmo telefone residencial ou celular
	private void validateTelephone(AdopterDTO adopterDTO) {
		if (adopterDTO == null) {
			throw new NullPointerException("O campo TELEFONE é obrigatório");
		}
		
		if (adopterDTO.getTelephone().equalsIgnoreCase("55 48 981784550") || adopterDTO.getTelephone().equalsIgnoreCase("5548981784550")) {
			throw new IllegalFormatException("Formato errado de TELEFONE. Exemplo: 55 48 981784550. Não use o telefone do exemplo.");
		}
		
		if (adopterDTO.getTelephone().matches("^((?=[A-Z|a-z]).)*$") == false && adopterDTO.getTelephone().length() > 19) { // Regex validate telephone's value.
			throw new IllegalFormatException("Formato errado de TELEFONE. Exemplo: 55 48 98178455");
		}
	}
	/* Casos de uso de telefone válido
	+55 51 98175.4550
	+55 5198175.4550
	+55 51 3075.4448
	+55 513075.4448
	+55 51 98175-4550
	+55 5198175-4550
	+55 51 3075-4448
	+55 513075-4448
	+5551 98175.4550
	+555198175.4550
	+5551 3075.4448
	+55513075.4448
	+5551 98175-4550
	+555198175-4550
	+5551 3075-4448
	+55513075-4448
	55 48 981784550
	+55 (51) 98175.4550
	+55 (51)98175.4550
	+55 (51) 3075.4448
	+55 (51)3075.4448
	+55 (51) 98175-4550
	+55 (51)98175-4550
	+55 (51) 3075-4448
	+55 (51)3075-4448
	(51) 98175.4550
	(51)98175.4550
	(51) 3075.4448
	(51)3075.4448
	(51) 98175-4550
	(51)98175-4550
	(51) 3075-4448
	(51)3075-4448
	51 981754550
	51 30754448
	51981754550
	5130754448
	*/
	
}
