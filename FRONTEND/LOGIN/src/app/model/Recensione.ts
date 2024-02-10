import { Centro } from "./Centro";
import { UtentePrivato } from "./UtentePrivato";

export interface Recensione {
    id : number | undefined;
    voto : number;
    descrizione : string;
    privato : UtentePrivato;
    centro : Centro;


}
