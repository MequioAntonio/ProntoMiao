import { Annuncio } from "./Annuncio";
import { Richiesta } from "./Richiesta";
import { UtentePrivato } from "./UtentePrivato";

export class RichiestaImpl implements Richiesta{
    id: number = 0;
    stato: number = 0;
    data: Date | undefined;
    annuncio: Annuncio | undefined;
    utente: UtentePrivato | undefined;
    
}