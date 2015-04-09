package com.hitemni.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hitemni.dao.UtilisateurDAO;
import com.hitemni.dao.UtilisateurI;
import com.hitemni.model.Utilisateur;

@Controller
@RequestMapping(value = "/")
public class UtilisateurController {

	@Autowired
	private UtilisateurI utilisateurI;
	
	@RequestMapping(value = "/api/utilisateur/getUtilisateurById", method = RequestMethod.GET)
	public @ResponseBody String getUtilisateurById(
			@RequestParam(required = true, value = "idUtilisateur") int idUtilisateur,
			ModelMap model) throws JSONException {
		
		Utilisateur utilisateur = utilisateurI.getUtilisateurById(idUtilisateur);

		JSONObject utilisateurJSON = new JSONObject();

		utilisateurJSON.put("id_utilisateur", utilisateur.getIdUtilisateur());
		utilisateurJSON.put("nom", utilisateur.getNom());
		utilisateurJSON.put("prenom", utilisateur.getPrenom());
		utilisateurJSON.put("mail", utilisateur.getMail());
		utilisateurJSON.put("mot_de_passe", utilisateur.getMotDePasse());
		utilisateurJSON.put("age", utilisateur.getAge());
		utilisateurJSON.put("sexe", utilisateur.getSexe());
		utilisateurJSON.put("promo", utilisateur.getPromo());
		utilisateurJSON.put("telephone", utilisateur.getTelephone());
		utilisateurJSON.put("adressePro", utilisateur.getAdressePro());
		utilisateurJSON.put("photo", utilisateur.getPhoto());
		utilisateurJSON.put("latitude", utilisateur.getLatitude());
		utilisateurJSON.put("longitude", utilisateur.getLongitude());
		utilisateurJSON.put("cv", utilisateur.getCv());
		utilisateurJSON.put("preference", utilisateur.getPreference());
		utilisateurJSON.put("utilisateur_personalite",
				utilisateur.getUtilisateurPersonnalite());
		//utilisateurJSON.put("evenement", utilisateur.getEvenements());

		return utilisateurJSON.toString();
	}

	@RequestMapping(value = "/api/utilisateur/listeUtilisateur", method = RequestMethod.GET)
	public @ResponseBody String listeUtilisateur(ModelMap model)
			throws JSONException {
		JSONArray utilisateurArray = new JSONArray();
		UtilisateurDAO utillisateurDAO = new UtilisateurDAO();

		for (Utilisateur utilisateur : utillisateurDAO.listeUtilisateur()) {
			JSONObject utilisateurJSON = new JSONObject();

			utilisateurJSON.put("id_utilisateur",
					utilisateur.getIdUtilisateur());
			utilisateurJSON.put("nom", utilisateur.getNom());
			utilisateurJSON.put("prenom", utilisateur.getPrenom());
			utilisateurJSON.put("mail", utilisateur.getMail());
			utilisateurJSON.put("mot_de_passe", utilisateur.getMotDePasse());
			utilisateurJSON.put("age", utilisateur.getAge());
			utilisateurJSON.put("sexe", utilisateur.getSexe());
			utilisateurJSON.put("promo", utilisateur.getPromo());
			utilisateurJSON.put("telephone", utilisateur.getTelephone());
			utilisateurJSON.put("adressePro", utilisateur.getAdressePro());
			utilisateurJSON.put("photo", utilisateur.getPhoto());
			utilisateurJSON.put("latitude", utilisateur.getLatitude());
			utilisateurJSON.put("longitude", utilisateur.getLongitude());
			utilisateurJSON.put("cv", utilisateur.getCv());
			utilisateurJSON.put("preference", utilisateur.getPreference());
			utilisateurJSON.put("utilisateur_personalite",
					utilisateur.getUtilisateurPersonnalite());
			utilisateurJSON.put("evenement", utilisateur.getEvenements());

			utilisateurArray.put(utilisateurJSON);
		}
		return utilisateurArray.toString();
	}
	
	@RequestMapping(value = "/api/utilisateur/authentication", method = RequestMethod.GET)
	public @ResponseBody String Authentication(@RequestParam(required = true, value = "email") String email,
			@RequestParam(required = true, value = "password") String password,
			ModelMap model)
			throws JSONException {
		//User user = utilisateurDAO.authentication(email, password);
		return "";
	}
	
}
