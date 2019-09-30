#VotreBanqueJEE

Application JEE qui permet de gérer des comptes bancaire avec Spring Boot JPA Hibernate Restful SOAP RMI AngularJS


-	Exigences fonctionnelles:
		L’application doit permettre de :
		
			•	Gérer des les clients :
			
					Ajouter un client.
					Consulter tous les clients.
					Consulter les clients dont le nom contient un mot clé.
					
			•	Gérer les comptes :
			
					Ajouter un compte.
					Consulter un compte.
			•	Gérer les opérations :
			
					Effectuer un versement d’un montant dans un compte.
					Effectuer un retrait d’un montant dans un compte.
					Effectuer un virement d’un montant d’un compte vers un autre.
					Consulter les opérations d’un compte page par page.
					
		Les opérations nécessitent une opération d’authentification.
		
		Exigences Techniques:

		Les données sont stockées dans une base de données MySQL.

			•	 L’application se compose de trois couches :
			
					La couche DAO qui est basée sur Spring Data, JPA, Hibernate et JDBC.
					La couche Métier.
					La couche Web basée sur MVC coté Serveur en utilisant Thymeleaf.
					
					
			•	 La sécurité est basée sur Spring Security.			
			•	 Etablir une architecture technique du projet.
			•	 Etablir un diagramme de classes qui montre les entités, la couche DAO et la couche métier.
			
			•	 On va Créer un projet SpringBoot qui contient les éléments suivants :
					
					Les entités.
					La couche DAO (Interfaces Spring data).
					La couche métier (Interfaces et implémentations).
					La couche web :
					Les contrôleurs Spring MVC.
					Les Vue basée sur Thymeleaf.
					
			•	Sécuriser l’application en utilisant un système d’authentification basé sur Spring Security.

			•	Chaque compte est défini un code, un solde et une date de création.
			•	Un compte courant est un compte qui possède en plus un découvert.
			•	Un compte épargne est un compte qui possède en plus un taux d’intérêt.
			•	Chaque compte appartient à un client.
			•	Chaque client est défini par son code et son nom.
			•	Chaque compte peut subir plusieurs opérations.
			•	Une opération est définie par un numéro, une date et un montant.
			•	Il existe deux types d’opérations : Versement et Retrait.
