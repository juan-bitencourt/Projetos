# para importar o módulo de localização
# geopy tem que ser instalada usando: pip install geopy

from geopy.geocoders import Nominatim
from geopy.distance import distance
#API key
geolocator = Nominatim(user_agent="geoapiExercises")


print("Olá!\nEsse programa irá mostrar informações sobre os tipos de reciclável e onde descartá-los na cidade de Campinas!\n")
print("\n [1] PAPEL \n [2] PLÁSTICO \n [3] METAL \n [4] VIDRO \n [5] ORGÂNICO \n [0] IR PARA LOCALIZAÇÃO DOS ECO-PONTOS")
# Códigos para o usuário definir qual o material que ele deseja ter mais informações
print("")
mat = float(input("Insira o código do material para mais informações:")) #o usuário digitará um dos códigos especificados acima
print("")

while (mat != 1) or (mat != 2) or (mat != 3) or (mat != 4) or (mat != 5) or (mat != 0): #loop para o usuário não errar o código

	if mat == 1:
		print("PAPEL (Lixeira AZUL)\n Decomposição na Natureza: 4 a 6 meses;\n Armazenamento: o ideal é que seja feito em locais ventilados e longe de umidade; \n Pós-reciclagem: cadernos, agendas, livros e etc.  ")
		print("")
		print("Deseja saber sobre outro material? (0 para não)")

	elif mat == 2:
		print("PLÁSTICO (Lixeira VERMELHA)\n Decomposição na Natureza: 450 anos;\n Armazenamento: manter em locais ventilados mas longe da natureza; \n Pós-reciclagem: embalagens de plástico sustentáveis que demoram menos para se decompor")
		print("")
		print("Deseja saber sobre outro material? (0 para não)")
	elif mat == 3:
		print("METAL (Lixeira AMARELA)\n Decomposição na Natureza: 200 a 500 anos;\n Armazenamento: manter em local coberto, longe da luz solar e do calor. Tomar cuidado com possíveis pontas afiadas; \n Pós-reciclagem: cabos, fios acessórios de carro e etc. ")
		print("")
		print("Deseja saber sobre outro material? (0 para não)")

	elif mat == 4:
		print("VIDRO (Lixeira VERDE)\n Decomposição na Natureza: 1 milhão de anos;\n Armazenamento: manter em local seco, bem-ventilado e longe de umidade. Ter materiais separadores entre eles e muito cuidado ao manuseá-lo; \n Pós-reciclagem: Novas embalagens de vidro.")
		print("")
		print("Deseja saber sobre outro material? (0 para não)")

	elif mat == 5:
		print("ORGÂNICO (Lixeira MARROM	)\n Decomposição na Natureza: 1 a 3 meses; \n Armazenamento: não é recomendado armazenar por muito tempo por conta do mau cheiro, leve ao ecoponto o mais rápido que puder; \n Pós-reciclagem: Adubo orgânico usado na agricultura.")
		print("")
		print("Deseja saber sobre outro material? (0 para não)")
		
	elif mat == 0:
		print("Obrigado pela atenção!")
		break # esse comando quebra o loop quando a condição é satisfeita

	else:
		print("Código errado!")

	mat = float(input("Insira o código do material para mais informações:")) #mensagem que irá aparecer até o usuário digitar 0
	print("")

print("Como deseja saber a localização dos eco-pontos?")
loc = float(input("\n[1]Por bairro\n[2]Por sua localização\n[0]SAIR\n"))

while (loc != 1) or (loc != 2) or (loc != 0):
	if loc == 1:
		print("\nPrincipais Eco-Pontos em Regiões de Campinas:\n")
		print("[1] Região do Campo Grande\n[2] Região Central\n[3] Ouro Verde\n[4] Sousas\n[5] Barão Geraldo\n[6] Jardim Pacaembu\n[7] Jardim Eulina\n[0] SAIR")
		reg = float(input("\nInsira o código da região mais próxima de você:\n"))
		while (reg != 1 ) or (reg != 2) or (reg != 3 ) or (reg != 4) or (reg != 5) or (reg != 6) or (reg != 7) or (reg != 0):#loop para o usuário que escolheu ver a localização dos ecopontos
			if reg == 1:
				print("PARQUE ITAJAÍ\nRua Celso Soares Couto, s/n\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11h às 12h.\n\n")
				print("VILA UNIÃO\nRua Manoel Gomes Ferreira, esq. Rua Jose Ramos Catarino\nHorário de funcionamento: das 7h às 18h, todos os dias\nHorário de almoço: das 11h às 12h.\n\n")
				
			elif reg == 2:
				print("REGIÃO CENTRAL\n0 Rua Francisco Theodoro, 1050, Vila Industrial\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11hs às 12hs.\n\n")
				
			elif reg == 3:
				print("VIDA NOVA\nRua Góia Jr. s/n\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11h às 12h.\n\n")
				
			elif reg == 4:
				print("SOUSAS\nRua Dom Pedro, 464\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11h às 12h.\n\n")
				
			elif reg == 5:
				print("BARÃO GERALDO\nAv. Santa Isabel, s/nº\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11h às 12h.\n\n")
			
			elif reg == 6:
				print("JARDIM PACAEMBU\nRua Dante Suriane esq. com Av. Padre Gaspar Bertoni\nHorário de funcionamento: das 7h às 18h, todos os dias\nHorário de almoço: das 11h às 12h.\n\n")
			
			elif reg == 7:
				print("JARDIM EULINA\nAvenida Marechal Rondon\nHorário de funcionamento: das 7h às 18h, todos os dias\nHorário de almoço: das 11h às 12h.\n\n")
			
			elif reg == 0:
				print("Obrigado pela atenção!")
				break
			else:
				print("Código errado!")
			reg = float(input("\nInsira o código de outra região (0 para sair):\n"))
		break
	elif loc == 2:


		#principais ecopontos nas regiões de Campinas

		#Parque itajaí
		rua1 = geolocator.geocode("Rua Celso Soares Couto")
		eco1 = (rua1.latitude, rua1.longitude)
		#Centro
		rua2 = geolocator.geocode("Rua Francisco Theodoro")
		eco2 = (rua2.latitude, rua2.longitude)
		#Ouro verde
		rua3 = geolocator.geocode("Vida nova")
		eco3 = (rua3.latitude, rua3.longitude)
		#Sousas
		rua4 = geolocator.geocode("464 Rua Dom Pedro")
		eco4 = (rua4.latitude, rua4.longitude)
		#Barão geraldo
		rua5 = geolocator.geocode("Avenida Santa Isabel")
		eco5 = (rua5.latitude, rua5.longitude)

		#o usuário irá entrar com o nome do bairro

		bairro = str(input("Insira o Nome de seu Bairro:"))
		#end é uma váriavel para localizar a existencia desse bairro
		end = geolocator.geocode(bairro)
		#para pegar a latitude e longitude do bairro escolhido
		loca = (end.latitude, end.longitude)

		#condição que dirá qual eco-ponto é mais próximo da localização do usuário
		if (distance(loca,eco1).kilometers) < (distance(loca,eco2).kilometers) and (distance(loca,eco1).kilometers) < (distance(loca,eco3).kilometers) and (distance(loca,eco1).kilometers) < (distance(loca,eco4).kilometers) and (distance(loca,eco1).kilometers) < (distance(loca,eco5).kilometers):
			print("O eco-ponto mais próximo de você é esse:\n")
			print("PARQUE ITAJAÍ\nRua Celso Soares Couto, s/n\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11h às 12h.\n\n")

		elif (distance(loca,eco2).kilometers) < (distance(loca,eco1).kilometers) and (distance(loca,eco2).kilometers) < (distance(loca,eco3).kilometers) and (distance(loca,eco2).kilometers) < (distance(loca,eco4).kilometers) and (distance(loca,eco2).kilometers) < (distance(loca,eco5).kilometers):
			print("O eco-ponto mais próximo de você é esse:\n")
			print("REGIÃO CENTRAL\n0 Rua Francisco Theodoro, 1050, Vila Industrial\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11hs às 12hs.\n\n")

		elif (distance(loca,eco3).kilometers) < (distance(loca,eco1).kilometers) and (distance(loca,eco3).kilometers) < (distance(loca,eco2).kilometers) and (distance(loca,eco3).kilometers) < (distance(loca,eco4).kilometers) and (distance(loca,eco3).kilometers) < (distance(loca,eco5).kilometers):
			print("O eco-ponto mais próximo de você é esse:\n")
			print("VIDA NOVA\nRua Góia Jr. s/n\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11h às 12h.\n\n")

		elif (distance(loca,eco4).kilometers) < (distance(loca,eco1).kilometers) and (distance(loca,eco4).kilometers) < (distance(loca,eco2).kilometers) and (distance(loca,eco4).kilometers) < (distance(loca,eco3).kilometers) and (distance(loca,eco4).kilometers) < (distance(loca,eco5).kilometers):
			print("O eco-ponto mais próximo de você é esse:\n")
			print("SOUSAS\nRua Dom Pedro, 464\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11h às 12h.\n\n")

		elif (distance(loca,eco5).kilometers) < (distance(loca,eco1).kilometers) and (distance(loca,eco5).kilometers) < (distance(loca,eco2).kilometers) and (distance(loca,eco5).kilometers) < (distance(loca,eco3).kilometers) and (distance(loca,eco5).kilometers) < (distance(loca,eco4).kilometers):
			print("O eco-ponto mais próximo de você é esse:\n")
			print("BARÃO GERALDO\nAv. Santa Isabel, s/nº\nHorário de funcionamento: das 7h às 18h, todos os dias, exceto feriados\nHorário de almoço: das 11h às 12h.\n\n")

		break
	
	elif loc == 0:
		print("Obrigado pela atenção!")
		break
		
	else:
		print("Código errado!\n")
		print("Como deseja saber a localização dos eco-pontos?")
		loc = float(input("\n[1]Por região\n[2]Por bairro\n[0]SAIR"))

print("\nObrigado por usar nosso programa!")
