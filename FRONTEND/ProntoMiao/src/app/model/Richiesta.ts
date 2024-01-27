import { Annuncio } from "./Annuncio";
import { UtentePrivato } from "./UtentePrivato";

export interface Richiesta {
  id: number;
  stato: number;
  data: Date;
  annuncio: Annuncio;
  utente: UtentePrivato;
}
