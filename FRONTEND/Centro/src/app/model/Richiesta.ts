import { Annuncio } from "./Annuncio";
import { UtentePrivato } from "./UtentePrivato";

export interface Richiesta {
  id: number | null;
  stato: number;
  data: Date | undefined;
  annuncio: Annuncio | undefined;
  utente: UtentePrivato | undefined;
}
