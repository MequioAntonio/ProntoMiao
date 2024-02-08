import { Annuncio } from "./Annuncio";
import { Richiesta } from "./Richiesta";
import { UtentePrivato } from "./UtentePrivato";

export class RichiestaImpl implements Richiesta{
    id = null;
    stato: number = 0;
    data: Date | undefined;
    annuncio: Annuncio | undefined;
    utente: UtentePrivato | undefined;

}
