import { Centro } from "./Centro";
import { UtentePrivato } from "./UtentePrivato";

export interface Segnalazione {
    id : number | undefined;
    titolo : string;
    descrizione : string;
    indirizzo : string;
    privato : UtentePrivato;
    centro : Centro | undefined;
}
