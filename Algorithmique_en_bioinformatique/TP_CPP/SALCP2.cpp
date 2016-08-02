class SA{
	private :
		vector<size_t> sa,lcp;
		const string &seq; //travaille sur reference, direct sur l'original qu'on modifie pas
	public : 
		//recup la valeur a la pos i dans sa
		size_t getSAat(size_t i) const;
		size_t operator[](size_t i) const; //equivalent de la meth au dessus.
		//caract fin de chaine : \0 => octet nul.
		//distance entre deux suffixes donnés dans un tableau : nb de lettre en commun dans leur prefixe.
		size_t LCP(size_t i, size_t j=i+1) const;//si fourni pas j, par defaut i+1
		//avoir le i ème suffixe dans le tableau, renvoi un pointeur de caract const
		char* getSuffixe(size_t i) const; // char* renvoye sur le tableau de caractère où y a &seq a partir du suffixe
		char* operator() (size_t i) const;//meme chose qu'au dessus.
		
		SA::SA(const string &seq):sa(seq.length()+1),lcp(seq.length()+1,0),seq(seq){//on fourni une seq,initialise plein de truc.prend une seq et reference dessus, pour y accéder
			//sa
			iota(sa.being(),sa.end(),0);//créer tableau avec les position, mais pas encore trié.
			sort(sa.begin(),sa.end(),fct?) //foncteur (fonction de comparaison), renvoi vrai si elem x est plus petit que elem y, objet qui va fonctionner comme une fonction.
			//fct prend en param x,y des size_t
			//renvoi Vrai ssi suff(x)<suff(y)
			fct = SaComp(seq) //objet crée juste lors de l'appelle de la fonction sort (en plus struct < class), pas de pb de mémoire.
			//lcp
		
		struct SaComp{
			const string &seq;
			SaComp(const string &seq):seq(seq){}
			bool operator()(size_t a, size_t b) const{//renvoi V si suff(a) < suff(b)
				//seq.c_str : renvoi le char* correspondant : LE tableau de caract
				//bool res=true;//suppose que a < b, tq c'est vrai, on continue
				int res = 0; // condition vraie => 1; !res => condition fausse => 0;
				while(!res && a < seq.length() && b < seq.length()){ //seq.length = arrive a la fin de la chaine = mot vide. !res => res=0, tq la longueur entre les suff est a égalité
					if (seq[a] < seq[b]{ res=-1; }
					else { if (seq[a] > seq[b]) { res=1;}
					else {a++; b++}
					}
				} if (!res) {
					res=(a == seq.length() ? -1 : 1);
					}
					return (res == -1);
				}
			}
			
		//reste la table des lcp, on peut reprendre le code, assez similaire, puis calcul de la table.
		//sa[0] : suffixe le plus petit dans l'ordre lexico, les parcourir deux a deux et voir ce qu'ils ont en commun.
		
		//si avec nos sequences :
		//const FastXSeq &seq
		//appeler encode
		//sort
		//Sacomp { remplacer string par FastXSeq
		//nécessite que les operateurs soient bien redéfinis (c'est le cas). + fct taille() (le sortir et le stocker dans une variable, sinon besoin de tout reparcourir a chaque fois)
		//char* operator() (size_t i, size_t j=(size_t)-1)) const;//au lieu davoir un suff, on aura un facteur, en terme d'encodage = -1 =>  que des 1, valeur maxi. ou X(5,7)
		//va servir lors de la consultation de l'index: quel est le facteur a telle position.

//if ((enc(seq)) && (gre(tel))){
//	return swag;
//}
