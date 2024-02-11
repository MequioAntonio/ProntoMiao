class AuthRequest {
    private email: string;
    private password: string;
    private tipoUtente: string;
    private nome: string;
    private descrizione: string;
    private orari: string;
    private eventi: string;
    private indirizzo: string;
    private cognome: string;
    private cf: string;
    private telefono: string;
    private preferenze: string;
    private condizioni_abitative: string;
    private informazioni_aggiuntive: string;
  
    constructor() {}
  
    getEmail(): string {
      return this.email;
    }
  
    setEmail(email: string): void {
      this.email = email;
    }
  
    getPassword(): string {
      return this.password;
    }
  
    setPassword(password: string): void {
      this.password = password;
    }
  
    getTipoUtente(): string {
      return this.tipoUtente;
    }
  
    setTipoUtente(tipoUtente: string): void {
      this.tipoUtente = tipoUtente;
    }
  
    getNome(): string {
      return this.nome;
    }
  
    setNome(nome: string): void {
      this.nome = nome;
    }
  
    getDescrizione(): string {
      return this.descrizione;
    }
  
    setDescrizione(descrizione: string): void {
      this.descrizione = descrizione;
    }
  
    getOrari(): string {
      return this.orari;
    }
  
    setOrari(orari: string): void {
      this.orari = orari;
    }
  
    getEventi(): string {
      return this.eventi;
    }
  
    setEventi(eventi: string): void {
      this.eventi = eventi;
    }
  
    getIndirizzo(): string {
      return this.indirizzo;
    }
  
    setIndirizzo(indirizzo: string): void {
      this.indirizzo = indirizzo;
    }
  
    getCognome(): string {
      return this.cognome;
    }
  
    setCognome(cognome: string): void {
      this.cognome = cognome;
    }
  
    getCf(): string {
      return this.cf;
    }
  
    setCf(cf: string): void {
      this.cf = cf;
    }
  
    getTelefono(): string {
      return this.telefono;
    }
  
    setTelefono(telefono: string): void {
      this.telefono = telefono;
    }
  
    getPreferenze(): string {
      return this.preferenze;
    }
  
    setPreferenze(preferenze: string): void {
      this.preferenze = preferenze;
    }
  
    getCondizioniAbitative(): string {
      return this.condizioni_abitative;
    }
  
    setCondizioniAbitative(condizioni_abitative: string): void {
      this.condizioni_abitative = condizioni_abitative;
    }
  
    getInformazioniAggiuntive(): string {
      return this.informazioni_aggiuntive;
    }
  
    setInformazioniAggiuntive(informazioni_aggiuntive: string): void {
      this.informazioni_aggiuntive = informazioni_aggiuntive;
    }
  }
  