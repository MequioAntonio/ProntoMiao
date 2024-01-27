import { Animale } from "./Animale";
import { Centro } from "./Centro";

export interface Annuncio {
    id : number;
    titolo: string;
    descrizione: string;
    foto_profilo: string;
    informazioni_mediche: string;
    animale : Animale;
    centro: Centro
}
