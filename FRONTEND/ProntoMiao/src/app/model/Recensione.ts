import { Centro } from "./Centro";
import { UtentePrivato } from "./UtentePrivato";

export interface Recensione {
    id : number;
    voto : number; 
    descrizione : string; 
    privato : UtentePrivato; 
    centro : Centro; 


}
