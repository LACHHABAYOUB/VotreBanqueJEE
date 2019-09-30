package org.sid.web;
import org.sid.dao.ClientRepository;
import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanqueController {

	@Autowired
	private IBanqueMetier banqueMetier;
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping("/operations")
	public String index(){
		return "comptes";
	}
	
	
	@RequestMapping("/consulterCompte")
	public String consulter(Model model, String codeCompte,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		model.addAttribute("codeCompte", codeCompte);
		try{
			Compte cp = banqueMetier.consulterCompte(codeCompte);
			model.addAttribute("compte", cp);
			Page<Operation> pageOperations= banqueMetier.listOperation(codeCompte, page, size);
			model.addAttribute("listOperations", pageOperations.getContent());
			int[] pages = new int [pageOperations.getTotalPages()];
			model.addAttribute("pages",pages);
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}
		return "comptes";
	}

	@RequestMapping(value="/saveOperation", method=RequestMethod.POST)
	public String saveOperation(Model model, 
			String typeOperation, String codeCompte,
			double montant, String codeCompte2){
		
		try{
			if(typeOperation.equals("VERS")){
				banqueMetier.verser(codeCompte, montant);
			}
			else if(typeOperation.equals("RETR")){
				banqueMetier.retirer(codeCompte, montant);
			} 
			if (typeOperation.equals("VIR")){
				banqueMetier.virement(codeCompte, codeCompte2, montant);
			}
		} catch(Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consulterCompte?codeCompte="+codeCompte+
					"&error="+e.getMessage();
		}
		
		return "redirect:/consulterCompte?codeCompte="+codeCompte;
	}
	
	@RequestMapping(value="/clients")
	public String getClients(Model model,
			@RequestParam(name="page", defaultValue="0") int p,
			@RequestParam(name="size", defaultValue="5") int s,
			@RequestParam(name="motCle", defaultValue="") String mc) {
		Page<Client> pageClient = clientRepository.chercher("%"+mc+"%", new PageRequest(p, s));
		model.addAttribute("listClients", pageClient.getContent());
		int[] pages=new int[pageClient.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		
		return "clients";
	}

	@RequestMapping(value="/deleteClient", method=RequestMethod.GET)
	public String deleteClient(Long code, String motCle, int page, int size ) {
		clientRepository.delete(code);
		return "redirect:/clients?page="+"&size="+size+"&motCle="+motCle;
	}
}
